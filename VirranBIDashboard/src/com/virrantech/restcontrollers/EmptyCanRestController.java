package com.virrantech.restcontrollers;

import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.virrantech.entity.ConsumerAddress;
import com.virrantech.entity.ConsumerFCMInfoEntity;
import com.virrantech.entity.ConsumerProfile;
import com.virrantech.entity.LocationInfoEntity;
import com.virrantech.entity.NotificationEntity;
import com.virrantech.entity.OrderInfoEntity;
import com.virrantech.entity.ProductEntity;
import com.virrantech.entity.ServiceRequestEntity;
import com.virrantech.entity.UserReferralEntity;
import com.virrantech.handler.ConsumerHandler;
import com.virrantech.handler.OrderHandler;
import com.virrantech.handler.ProductHandler;
import com.virrantech.utills.DateUtilities;
import com.virrantech.utills.JSONUtils;
import com.virrantech.utills.PMF;


@RestController
@ContextConfiguration("classpath:dispatcher-servlet.xml")
@RequestMapping("/rest")
public class EmptyCanRestController     {
  BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
  @RequestMapping(value="/getiplteam/{iplcode}", method=RequestMethod.GET)
  public String getIPLTeam(@PathVariable String iplcode) {
    
    PersistenceManager pm = null;
    try{
      UUID key = UUID.randomUUID();
     
      ConsumerProfile consumerProfile=new ConsumerProfile();
      //consumerProfile.setId(key.toString());
      consumerProfile.setConsumerName("VARADHARAJAN");
      consumerProfile.setConsumerPhoneNumber("8754694454");
      consumerProfile.setConsumerEmailId("aniruthan123@gmail.com");
      consumerProfile.setConsumerProfileId(34234L);
       ConsumerAddress consumerAddres=new ConsumerAddress();
       UUID key2 = UUID.randomUUID();
      //consumerAddres.setId(key2.toString());
     // consumerAddres.setConsumerProfile(consumerProfile);
      consumerProfile.getConsumerAddressList().add(consumerAddres);
      pm = PMF.get().getPersistenceManager();
     
      pm.makePersistent(consumerProfile);
    }catch(Exception e){
      e.printStackTrace();
    }finally {
    if (pm.currentTransaction().isActive()) {
        pm.currentTransaction().rollback();
    }
}
      if(null != iplcode && !"".equalsIgnoreCase(iplcode)){

          if("MI".equalsIgnoreCase(iplcode)){
              return "Mumbai Indians";
          }
          else if("DD".equalsIgnoreCase(iplcode)){
              return "Delhi Daredevils";
          }
          else{
              return "Chennai Super Kings";
          }
      }
      else{
          return "Enter correct IPL team code";
      }
  }
  @RequestMapping(value="/save-new-consumer", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String byConsumes(@RequestBody ConsumerProfile consumerProfile, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
    System.out.println("=================>>>"+consumerProfile.getConsumerName());
   ConsumerHandler consumerHandler=new ConsumerHandler();
   ProductHandler productHandler=new ProductHandler();
  JsonObject result= consumerHandler.saveConsumerObject(consumerProfile, request);
  ConsumerFCMInfoEntity consumerFCMEntity=new ConsumerFCMInfoEntity();
  consumerFCMEntity.setConsumerId(result.get("consumer_key").getAsLong());
  consumerFCMEntity.setFcmRegistrationId(consumerProfile.getConsumerDeviceNotificationId());
  consumerFCMEntity.setPhoneUniqueKey(consumerProfile.getConsumerDeviceId());
  consumerHandler.saveConsumerFCMInfo(consumerFCMEntity, request);
  result.addProperty("products", productHandler.getAllDistributorProducts(consumerProfile.getDefaultDistributorId(), request).toString());
   //consumerHandler.saveConsumerObject(consumerProfile, request);
  return result.toString();
  }
  @RequestMapping(value="/consumer-new-servicerequest", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String bookNewWaterCan(@RequestBody ServiceRequestEntity serviceRequest, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
    System.out.println("=================>>>"+serviceRequest);
   ConsumerHandler consumerHandler=new ConsumerHandler();
  // JsonObject result=new JsonObject();
  JsonObject result= consumerHandler.saveNewServiceRequest(serviceRequest, request);
  
  return result.toString();
  }
  @RequestMapping(value="/send-notification-to-phone", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String sendNotification(@RequestBody NotificationEntity notificationEntity, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
    System.out.println("=================>>>"+notificationEntity);
      ConsumerHandler consumerHandler=new ConsumerHandler();
      JSONObject result=  consumerHandler.sendNotification(notificationEntity,request);
      return result.toString();
  }
  @RequestMapping(value="/save-new-product", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String saveProductForm(@RequestBody ProductEntity productEntity, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
    System.out.println("==========Product=======>>>"+productEntity);
    ProductHandler productHandler=new ProductHandler();
      String result=  productHandler.addNewProduct(productEntity, request);
      return result;
  }
  @RequestMapping(value="/consumer-add-basic-profile", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String addConsumerBasicProfile(@RequestBody ConsumerProfile  consumerProfile, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
    System.out.println("=================>>>"+consumerProfile);
      ConsumerHandler consumerHandler=new ConsumerHandler();
     
      JsonObject result=  consumerHandler.addBasicConsumer(consumerProfile, request);
      return result.toString();
  }
  @RequestMapping(value="/consumer-pwrd-authenticate", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String consumerPwdAuthenticate(@RequestBody JsonObject  passwordJsonObj, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
   ConsumerHandler consumerHandler=new ConsumerHandler();
      JsonObject result=null;
      
       if(passwordJsonObj!=null){
        result=  new JsonObject();
        Long consumerKey= passwordJsonObj.get("consumer_key").getAsLong();
        String consumerPwd= passwordJsonObj.get("consumer_pwd").getAsString();
       if( consumerHandler.authenticateCnsumrPWd(consumerKey,consumerPwd,request)){
         result.addProperty("status", "valid");
       }else{
         result.addProperty("status", "invalid");
       }
      }
    return result.toString();
  }
  @RequestMapping(value="/consumer-login-authenticate", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String consumerLoginAuthenticate(@RequestBody String  consumerLoginJsonStr, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException, JSONException {
   ConsumerHandler consumerHandler=new ConsumerHandler();
   ProductHandler productHandler=new ProductHandler();
      JsonObject result=null;
      JSONObject passwordJsonObj=new JSONObject(consumerLoginJsonStr);
       if(passwordJsonObj!=null){
         String consumerUserName= passwordJsonObj.get("consumer_username").toString();
         String consumerPwd= passwordJsonObj.get("consumer_pwd").toString();
         //String fcmId= 
        boolean isFcm= passwordJsonObj.has("fcm_token");
         result=  new JsonObject();
       if( consumerHandler.authenticateCnsumrLogin(consumerUserName,consumerPwd,request)){
         result.addProperty("status", "valid");
         JSONUtils jsonUtills=new JSONUtils();
         ConsumerProfile consumerProfile=  consumerHandler.getConsumerProifle();
         consumerProfile.setConsumerPassword("");
         JsonObject consumerJson= jsonUtills.getJSONObject(consumerProfile);
         consumerJson.remove("consumerPassword");
         result.addProperty("consumer_info",   consumerJson.toString());
         result.addProperty("products", productHandler.getAllDistributorProducts(consumerProfile.getDefaultDistributorId(), request).toString());
         if(consumerProfile!=null){
           long consumerId= consumerProfile.getId().getId();
           result.addProperty("default_address",consumerHandler.getConsumerDefaultAddress(request, consumerId).toString());
           result.addProperty("first_time_booking_status", consumerHandler.getConsumerOrdersSize(consumerId,request));
           if(isFcm){
             //phone_unique_key
             String fcmToken= passwordJsonObj.get("fcm_token").toString();
             String phoneUniqueKey= passwordJsonObj.get("phone_unique_key").toString();
             ConsumerFCMInfoEntity consumerFCMInfoEntity=new ConsumerFCMInfoEntity();
             consumerFCMInfoEntity.setConsumerId(consumerId);
             consumerFCMInfoEntity.setFcmRegistrationId(fcmToken);
             consumerFCMInfoEntity.setPhoneUniqueKey(phoneUniqueKey);
             consumerHandler.saveConsumerFCMInfo(consumerFCMInfoEntity, request);
             consumerHandler.sendNewLoginNotification(consumerId,request);
           }
         }
        
       }else{
         result.addProperty("status", "invalid");
       }
      }
      // request.getSession().setAttribute("consumerObject",result.toString());
    return result.toString();
  }
  
  @RequestMapping(value="/consumer-new-address", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String consumerAddNewAddress(@RequestBody ConsumerAddress  consumerAddress, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
   ConsumerHandler consumerHandler=new ConsumerHandler();
      JsonObject result=null;
      
       if(consumerAddress!=null){
         result= consumerHandler.saveConsumerAddress(consumerAddress, request);
       
      }
    return result.toString();
  }
  @RequestMapping(value="/consumer-notifications/{consumerId}", method=RequestMethod.GET )
  public @ResponseBody String getConsumerNotification(@PathVariable Long consumerId, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
   ConsumerHandler consumerHandler=new ConsumerHandler();
      JsonArray result=null;
      result= consumerHandler.getAllNotification(consumerId, request);
       
      System.out.print(consumerId);
    return result.toString();
  }
 
  
  @RequestMapping(value="/consumer-fcm-token-registraion", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String consumerFCMToken(@RequestBody ConsumerFCMInfoEntity  consumerFcmTokens, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException, JSONException {
   ConsumerHandler consumerHandler=new ConsumerHandler();
  JsonObject result= consumerHandler.saveConsumerFCMInfo(consumerFcmTokens, request);
       
    return result.toString();
  }
  @RequestMapping(value="/consumer-new-order", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String consumerNewOrder(@RequestBody OrderInfoEntity  orderInfoEntity, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException, JSONException {
   OrderHandler orderHndlr=new OrderHandler();
   String result= orderHndlr.addNewOrder(orderInfoEntity, request);
       
    return result;
  }
  
  @RequestMapping(value="/consumer-address/{consumerId}", method=RequestMethod.POST )
  public @ResponseBody String getConsumerAddress(@PathVariable Long consumerId, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
   ConsumerHandler consumerHandler=new ConsumerHandler();
      JsonArray result=null;
      result= consumerHandler.getConsumerAllAddress(consumerId, request);
       
      System.out.print(result);
    return result.toString();
  }
  @RequestMapping(value="/consumer-phone-no-exists/{phoneNo}", method=RequestMethod.POST )
  public @ResponseBody String checkPhoneNoExists(@PathVariable String phoneNo, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException
  {
   ConsumerHandler consumerHandler=new ConsumerHandler();
      JsonObject result=new JsonObject();
      result.addProperty("phone_exists", consumerHandler.checkPhoneNumberExists(request, phoneNo));
      result.addProperty("status", "success");
      
    return result.toString();
  }
  @RequestMapping(value="/get-distributor-products/{distributorId}", method=RequestMethod.POST )
  public @ResponseBody String getDistributorProducts(@PathVariable String distributorId, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException
  {
   ProductHandler productHandler=new ProductHandler();
   JsonArray result=null;
   result= productHandler.getAllDistributorProducts(Long.parseLong(distributorId),request );
    return result.toString();
  }
  
  
  @RequestMapping(value="/update-notification-status", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  //@RequestMapping(value="/consumer-login-authenticate", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String updateNotificationStatus(@RequestBody String statusBundal, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
   ConsumerHandler consumerHandler=new ConsumerHandler();
       JSONObject result=null;
      try{
        if(statusBundal!=null){
          result=  new JSONObject(statusBundal);
          if( consumerHandler.updateNotificationRcvdStatus(result, request)){
           result.put("status", "valid");
         }else{
           result.put("status", "invalid");
         }
        }
      }catch(Exception e){
        e.printStackTrace();
      }
      
    return result.toString();
  }
  @RequestMapping(value="/delete-consumer-address", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String deleteConsumerAddress(@RequestBody String  deleteAddressKeys, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException, JSONException {
    JSONObject deleteAddressJsonKeys=new JSONObject(deleteAddressKeys);
    ConsumerHandler consumerHandler=new ConsumerHandler();
    JsonObject result=null;
    if(deleteAddressJsonKeys!=null){
      result=  consumerHandler.deleteAddress(deleteAddressJsonKeys, request);
    }
    return result.toString();
  }
  
  @RequestMapping(value="/get-consumer-orders", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String getConsumerOrder(@RequestBody String orderDetailQuery, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException
  {
    String result=null;
    try{
      //orderDetailQuery=StringEscapeUtils.escapeJavaScript(orderDetailQuery);
      OrderHandler orderHandler=new OrderHandler();
      
      JSONObject queryJson=new JSONObject(orderDetailQuery);
      result= orderHandler.getConsumerOrders(queryJson, request);
    }catch(Exception e){
      e.printStackTrace();
    }
  
    return result;
  }
  @RequestMapping(value="/consumer-refferal-details", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String consumerRefferalDetails(@RequestBody UserReferralEntity  userReferralEntity, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException, JSONException {
   ConsumerHandler consumerHandler=new ConsumerHandler();
  String result= consumerHandler.addReferralEntry(userReferralEntity, request);
       
    return result;
  }
  
  @RequestMapping(value="/consumer-image-upload/{consumerKey}", method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody  String uploadImage(@RequestPart(value = "file",required=false) MultipartFile  file,@PathVariable String consumerKey,HttpServletResponse response,HttpServletRequest  request) throws PropertyVetoException, SQLException, JSONException, FileNotFoundException, IOException {
  
    
 
    ConsumerHandler consumerHandler=new ConsumerHandler();
    String result=    consumerHandler.writeToBucket(consumerKey, file.getBytes());
  // String  result="I am not called";
  
    return result;
  }
  @RequestMapping(value="/blob/upload", method=RequestMethod.POST )
  public @ResponseBody String updateImageValue(@RequestBody UserReferralEntity  userReferralEntity, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException, JSONException {
    ConsumerHandler consumerHandler=new ConsumerHandler();
    System.out.println("Calling at blob creation");
    String consumerKey=(String) request.getParameter("consumerKey");
    List<BlobKey> blobs = blobstoreService.getUploads(request).get("file");
    BlobKey blobKey = blobs.get(0);
    ImagesService imagesService = ImagesServiceFactory.getImagesService();
    ServingUrlOptions servingOptions = ServingUrlOptions.Builder.withBlobKey(blobKey);
    String servingUrl = imagesService.getServingUrl(servingOptions);
    response.setStatus(HttpServletResponse.SC_OK);
    response.setContentType("application/json");
    JSONObject json = new JSONObject();
    json.put("servingUrl", servingUrl);
    json.put("blobKey", blobKey.getKeyString());
    json.put("status", consumerHandler.addConsumerUserProfileImage(servingUrl,blobKey.getKeyString(), Long.parseLong(consumerKey), request));
       
    return json.toString();
  }
  @RequestMapping(value="/update-app-products", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String updateAppProducts(@RequestParam(value="distributorId") String  distributorId,@RequestParam(value="authPassword") String  authPassword,@RequestParam(value="consumerKey") String  consumerKey, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException
  {
    JsonObject result=new JsonObject();;
    try{
      //orderDetailQuery=StringEscapeUtils.escapeJavaScript(orderDetailQuery);
      ProductHandler productHandler=new ProductHandler();
      JsonArray latestProductList= productHandler.getAllDistributorProducts(Long.valueOf(distributorId), request);
      productHandler.sendProductUpdateNotification(latestProductList,request,Long.valueOf(consumerKey));
      result.addProperty("status", "updated successfully");
    }catch(Exception e){
      result.addProperty("status", "failed to update");
      e.printStackTrace();
    }
  
    return result.toString();
  }
  @RequestMapping(value="/update-user-location", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String updateUserLocation(@RequestBody LocationInfoEntity locationInfoEntity, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
  
   ConsumerHandler consumerHandler=new ConsumerHandler();
   String result= consumerHandler.saveUserCurrentLocation(locationInfoEntity, request);
  
  return result;
  }
  @RequestMapping(value="/find-order-cartlist/{orderId}", method=RequestMethod.POST )
  public @ResponseBody String getCartList(@PathVariable Long orderId, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
   OrderHandler orderHandler=new OrderHandler();
   String result=  orderHandler.getCartListOfOrder(orderId, request);
   System.out.print(result);
    return result;
  }
  @RequestMapping(value="/cancel-booking-order/{orderId}", method=RequestMethod.POST )
  public @ResponseBody String cancelBookingOrder(@PathVariable Long orderId, @RequestParam(value="canceledBy") String canceledBy, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
   OrderHandler orderHandler=new OrderHandler();
   String result=  orderHandler.cancelBookingOrder(orderId, canceledBy, request);
   
    return result;
  }
  public static Date convertJodaTimezone(LocalDateTime date, String srcTz, String destTz) {
    Set<String> timeZones= DateTimeZone.getAvailableIDs();
    int len=timeZones.size();
    for(String timeZone:timeZones){
      System.out.println(timeZone);
    }
    DateTime srcDateTime = new DateTime("2017-03-10 12:10:58");
    srcDateTime= srcDateTime.parse("");
    
    DateTime dstDateTime = srcDateTime.withZone(DateTimeZone.forID("Asia/Kolkata"));
    return dstDateTime.toLocalDateTime().toDateTime().toDate();
}
  @RequestMapping(value="/dummy-call", method=RequestMethod.GET )
  public @ResponseBody String dummyCall( HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
   OrderHandler orderHandler=new OrderHandler();
   LocalDateTime localDateTime=new LocalDateTime();
   String time=DateUtilities.convertTimeToISTFormate("2017-03-06 10:15:34");
  // localDateTime.parse("2017-03-10 12:10:58");
   convertJodaTimezone(localDateTime,"","");
   
    return "";
  }
  
 /* @RequestMapping(value="/consumer-image-upload/{consumerKey}", method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody  String uploadImage(@PathVariable String consumerKey,HttpServletResponse response,HttpServletRequest  request) throws PropertyVetoException, SQLException, JSONException, FileNotFoundException, IOException {
  
     ConsumerHandler consumerHandler=new ConsumerHandler();
   System.out.println(userReferralEntity);
 // String result= consumerHandler.addReferralEntry(userReferralEntity, request);
    ConsumerHandler consumerHandler=new ConsumerHandler();
    //String result=    consumerHandler.writeToBucket(consumerKey, file.getBytes());
   String  result="I am not called";
  
    return result;
  }*/
  
}
