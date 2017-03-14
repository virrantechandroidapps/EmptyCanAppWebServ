package com.virrantech.handler;

import java.nio.ByteBuffer;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.InputSettings;
import com.google.appengine.api.images.OutputSettings;
import com.google.appengine.api.images.ServingUrlOptions;
import com.google.appengine.api.images.Transform;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsOutputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.virrantech.dao.ConsumerDAO;
import com.virrantech.dao.OrderDAO;
import com.virrantech.daoimpl.ConsumerDAOImpl;
import com.virrantech.daoimpl.OrderDAOImpl;
import com.virrantech.entity.ConsumerAddress;
import com.virrantech.entity.ConsumerFCMInfoEntity;
import com.virrantech.entity.ConsumerProfile;
import com.virrantech.entity.LocationInfoEntity;
import com.virrantech.entity.NotificationEntity;
import com.virrantech.entity.OrderInfoEntity;
import com.virrantech.entity.ServiceRequestEntity;
import com.virrantech.entity.UserReferralEntity;
import com.virrantech.utills.AppUtills;
import com.virrantech.utills.Constants;
import com.virrantech.utills.DateUtilities;
import com.virrantech.utills.GDataStoreUtills;
import com.virrantech.utills.JSONUtils;
import com.virrantech.utills.NotificationUtills;
import com.virrantech.utills.SaltUtils;
import com.virrantech.utills.SpringBeanUtils;

public class ConsumerHandler {

  public ConsumerProfile consumerProifle=null;
  public static String baseBucketName= "/gs/";
  public JsonObject saveConsumerObject(ConsumerProfile consumerProfile,HttpServletRequest request){
    JsonObject result=null;
    try{
      consumerProfile.setConsumerRegistredDate(DateUtilities.getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS));
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      consumerProfile.setConsumerPassword(convertAsEncryptionPwd(consumerProfile.getConsumerPassword()));
      result=consumerDAO.insertConsumer(consumerProfile);
     
      if(result.get("status").getAsString().equals("success")){
         long consumerKey=result.get("consumer_key").getAsLong();
        String referenceStatus= consumerDAO.updateUserRefferalCode(Long.parseLong(consumerProfile.getConsumerPhoneNumber()),consumerKey, "DOWNLOADED");
        result.addProperty("referencestatus", referenceStatus);
        consumerDAO.updateConsumerIdInFcm(consumerKey, consumerProfile.getConsumerDeviceId());
        ConsumerFCMInfoEntity consumerFcmEntity=new ConsumerFCMInfoEntity();
        String dateTime=DateUtilities.getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS);
        consumerFcmEntity.setFcmRegistrationDateTime((dateTime));
        consumerFcmEntity.setConsumerLastLoginDate(DateUtilities.convertStringDateToUtil(dateTime, DateUtilities.YYYY_MM_DD_24HH_MM_SS));
        consumerFcmEntity.setConsumerId(consumerKey);
        consumerFcmEntity.setFcmRegistrationDateTime(consumerProfile.getConsumerDeviceNotificationId());
        consumerDAO.saveConsumerFcmInfo(consumerFcmEntity);
        sendWelcomeNotice(consumerProfile.getConsumerDeviceNotificationId());
      }
        
      
  
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }
  public JsonObject saveConsumerAddress(ConsumerAddress consumerAddress,HttpServletRequest request){
    JsonObject result=null;
    try{
      
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
     
      result= consumerDAO.saveConsumerAddress(consumerAddress.getConsumerProfileId(),consumerAddress);
    
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }
  public String addConsumerUserProfileImage(String url,String blobKey,long consumerId,HttpServletRequest request){
    String result=null;
    try{
      
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
     
      result= consumerDAO.updateConsumerImage(consumerId, url,blobKey);
    
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }
  public JsonObject addBasicConsumer(ConsumerProfile consumerProfile,HttpServletRequest request){
    JsonObject result=null;
    try{
     
     ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
     result=consumerDAO.addBasicProfile(consumerProfile);
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }
  public JsonObject saveNewServiceRequest(ServiceRequestEntity serviceRequestEntity,HttpServletRequest request){
    JsonObject result=null;
    try{
      serviceRequestEntity.setServiceRequestedDateTime(DateUtilities.getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS));
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      result=consumerDAO.insertConsumerServiceRequest(serviceRequestEntity);
      if(result.get("status").getAsString().equals("success")){
        
      }
       // sendWelcomeNotice(consumerProfile.getConsumerDeviceNotificationId());
      
    
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }
  public JsonObject saveConsumerFCMInfo(ConsumerFCMInfoEntity consumerFCMEntity,HttpServletRequest request){
    JsonObject result=null;
    try{
      String dateTime=DateUtilities.getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS);
      consumerFCMEntity.setFcmRegistrationDateTime((dateTime));
      consumerFCMEntity.setConsumerLastLoginDate(DateUtilities.convertStringDateToUtil(dateTime, DateUtilities.YYYY_MM_DD_24HH_MM_SS));
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      result=consumerDAO.saveConsumerFcmInfo(consumerFCMEntity);
            // sendWelcomeNotice(consumerProfile.getConsumerDeviceNotificationId());
      
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }
  public String getConsumerArray(HttpServletRequest request){
   String resultList=null;
    try{
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      resultList=  consumerDAO.getConsumerList();
    }catch(Exception e){
      e.printStackTrace();
    }
    return resultList;
  }
  public boolean checkPhoneNumberExists(HttpServletRequest request,String phoneNumber){
    boolean isExists=false;
    try{
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      
     isExists=  consumerDAO.checkPhoneNumberExists(phoneNumber);
    }catch(Exception e){
      e.printStackTrace();
    }
    return isExists;
  }
  public void sendWelcomeNotice(String receivernotificationId){
    NotificationEntity notificationEntity=null;
    try{
      if(receivernotificationId!=null){
         notificationEntity=new NotificationEntity();
         notificationEntity.setReceiverFCMKey(receivernotificationId);
         notificationEntity.setSenderFCMKey(Constants.FIREBASE_CUSTOMER_FCM_KEY);
         JSONObject notificationPayLoad=new JSONObject();
         notificationPayLoad.put("title","Welcome to EmptyCan App");
         notificationPayLoad.put("body","You are registred successfully");
         notificationPayLoad.put("click_action","");
         notificationEntity.setDataPayLoad(notificationPayLoad);
         NotificationUtills.composeNotification(notificationEntity);
         
      }
       
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public boolean authenticateCnsumrPWd(Long consumerId,String consumerPassword,HttpServletRequest request){
    boolean result=false;
    try{
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
     ConsumerProfile consumerProfile=  consumerDAO.findConsumerById(consumerId);
      result= SaltUtils.authenticate(consumerPassword, consumerProfile.getConsumerPassword());
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }

  public ConsumerProfile getConsumerProfile(Long consumerId,HttpServletRequest request){
    ConsumerProfile consumerProfile=null;
    try{
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      consumerProfile=  consumerDAO.findConsumerById(consumerId);
      
    }catch(Exception e){
      e.printStackTrace();
    }
    return consumerProfile;
  }
  public boolean authenticateCnsumrLogin(String userName,String consumerPassword,HttpServletRequest request){
    boolean result=false;
    try{
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
     ConsumerProfile consumerProfile=  consumerDAO.findConsumerUserName(userName);
     if(consumerProfile!=null)
     if(SaltUtils.authenticate(consumerPassword, consumerProfile.getConsumerPassword())){
       this.consumerProifle=consumerProfile; 
       result= true;
     }
        
    
       
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }
  public JsonObject getConsumerDefaultAddress(HttpServletRequest request,long conusmerProfileId){
   JsonObject addressObj=null;
    try{
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      ConsumerAddress consumerAddress=  consumerDAO.findConsumerDefaultAddress(conusmerProfileId);
      if(consumerAddress!=null && consumerAddress.getId() !=null){
        addressObj=new JsonObject();
        addressObj.addProperty("fullName",consumerAddress.getConsumerFullName());
        addressObj.addProperty("locationName",consumerAddress.getLocationName());
        addressObj.addProperty("contactNumber",consumerAddress.getContactNumber());
        addressObj.addProperty("consumerHouseNo",consumerAddress.getConsumerHouseNo());
        addressObj.addProperty("streetName",consumerAddress.getConsumerStreetName());
        addressObj.addProperty("postalCode",consumerAddress.getPostalCode());
        addressObj.addProperty("consumerAreaName",consumerAddress.getConsumerAreaName());
        addressObj.addProperty("addressServerKey",consumerAddress.getId().getId());
      }else{
        addressObj=new JsonObject();
      }
     
    }catch(Exception e){
      e.printStackTrace();
      
    }
    return addressObj;
  }
  public JsonArray getAllNotification(Long consumerId,HttpServletRequest request){
  JsonArray resultArry=null;
    try{
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      resultArry=  consumerDAO.findNotificationByUser(consumerId);
     if(resultArry==null)
       resultArry=new JsonArray();
    }catch(Exception e){
      e.printStackTrace();
    }
    return resultArry;
  }
  public JsonArray getConsumerAllAddress(Long consumerId,HttpServletRequest request){
  JsonArray resultArry=null;
    try{
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      resultArry=  consumerDAO.findAddressByUser(consumerId);
     if(resultArry==null)
       resultArry=new JsonArray();
    }catch(Exception e){
      e.printStackTrace();
    }
    return resultArry;
  }
  public boolean updateNotificationRcvdStatus(JSONObject updateBundle,HttpServletRequest request){
    try{
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      long consumerId= updateBundle.getLong("consumerId");
      return consumerDAO.updateNotificationReceivedStatus(consumerId, updateBundle.getString("messageId"));
    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
   
  }
  public String addReferralEntry(UserReferralEntity userReferralEntity,HttpServletRequest request){
    String result="";
    try{
     String currentDateTime= DateUtilities.getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS);
      userReferralEntity.setReferralDoneDate(currentDateTime);
      userReferralEntity.setReferralISTDoneDate(DateUtilities.convertStringDateToUtil(currentDateTime,DateUtilities.YYYY_MM_DD_24HH_MM_SS));
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
   
      result=consumerDAO.saveReferralDetails(userReferralEntity).toString();
    }catch(Exception e){
      e.printStackTrace();
    
    }
    return result;
  }
  public JSONObject sendNotification(NotificationEntity notificationEntity,HttpServletRequest request){
    JSONObject  result=null;
    ConsumerDAO  consumerDAO=null;
    try{
      if(notificationEntity!=null){
       String notificationTye=notificationEntity.getNotificationType();
       String contextPath=AppUtills.getURLWithContextPath(request);
       contextPath="http://virranbi.appspot.com";
       System.out.println("THE CONTEXT PATH :  "+contextPath+"//images//"+Constants.IMG_BOOK_CONFIRM);
       if(notificationTye!=null && !(notificationTye.equals(""))){
         if(notificationTye.equals(Constants.NOTI_BOOKING_CONIRM))
           notificationEntity.setNotificationImageUrl(contextPath+"/images/"+Constants.IMG_BOOK_CONFIRM);
         else if(notificationTye.equals(Constants.NOTI_ORDER_ON_THE_WAY))
           notificationEntity.setNotificationImageUrl(contextPath+"/images/"+Constants.IMG_ORDER_ONTHEWAY);
         else if(notificationTye.equals(Constants.NOTI_OFFER))
           notificationEntity.setNotificationImageUrl(contextPath+"/images/"+Constants.IMG_DISCOUNT);
         else if(notificationTye.equals(Constants.NOTI_ALERT))
           notificationEntity.setNotificationImageUrl(contextPath+"/images/"+Constants.IMG_ALERT);
         else if(notificationTye.equals(Constants.NOTI_COMMON))
           notificationEntity.setNotificationImageUrl(contextPath+"/images/"+Constants.IMG_DUMMY);
       }else{
         notificationEntity.setNotificationType(Constants.NOTI_COMMON);
         notificationEntity.setNotificationImageUrl(contextPath+"//images//"+Constants.IMG_DUMMY);
       }
        
          
        
        
         result= NotificationUtills.composeNotification(notificationEntity);
         consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
         JSONObject resultJson=new JSONObject(result.getString("asJsonObject"));
         JSONObject googleResponse= new JSONObject( resultJson.getString("google_respone"));
         JSONArray resultArray= googleResponse.getJSONArray("results");
         
           int resultSize=resultArray.length();
          for(int i=0;i<resultSize;i++){
            JSONObject output= resultArray.getJSONObject(i);
            if(output.has("message_id")){
              notificationEntity.setMessageId( output.getString("message_id"));
            }
          }
         if(consumerDAO!=null  && googleResponse.getInt("success")==1 ){
           notificationEntity.setDataPayLoad(null);
           notificationEntity.setNotificationNetwrkStatus(Constants.SUCCESS);
           notificationEntity.setNotificationSentDateTime(DateUtilities.getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS));
           //notificationEntity.setNotificationImageUrl("http://virranbi.appspot.com/images/bell.png");
          // notificationEntity.setNotificationType(Constants.NOTI_COMMON);
           notificationEntity.setNotificationPayLoad(null);
           //notificationEntity.setDataPayLoad(null);
           notificationEntity.setNotificationReadStatus(Constants.NOTI_UNREAD);
          // notificationEntity.setNotificationImageUrl(null);
           consumerDAO.saveNotification(notificationEntity);
         }
         
        }
      
       
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }
  
  public String convertAsEncryptionPwd(String passWrd){
    
    try{
     String encryptedPassword=  SaltUtils.encrypt(passWrd);
    
     return encryptedPassword;
    }catch(Exception e){
      e.printStackTrace();
    }
    return "";
  }
  public JsonObject getConsumerById(long consumerId,HttpServletRequest request){
  JsonObject result=null;
    try{
      ProductHandler productHandler=new ProductHandler();
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      JSONUtils jsonUtills=new JSONUtils();
      ConsumerProfile consumerProfile= consumerDAO.findConsumerById(consumerId);
      if(consumerProfile!=null){
        result=new JsonObject();
        result.addProperty("status", "valid");
        consumerProfile.setConsumerPassword("");
        JsonObject consumerObject= jsonUtills.getJSONObject(consumerProfile);
        
        result.addProperty("consumer_info",   consumerObject.toString());
        result.addProperty("products", productHandler.getAllDistributorProducts(consumerProfile.getDefaultDistributorId(), request).toString());
        if(consumerProfile!=null){
          JsonObject defaluAddress= getConsumerDefaultAddress(request, consumerProfile.getId().getId());
          result.addProperty("default_address",defaluAddress!=null? defaluAddress.toString():new JsonObject().toString());
        }
         
      }else{
        result.addProperty("status", "invalid");
      }
           
    }catch(Exception e){
      result.addProperty("status", "invalid");
      e.printStackTrace();
    }
    return result;
  }
  public JsonObject deleteAddress(JSONObject deleteObject,HttpServletRequest request){
    JsonObject resultObject=null;
    try{
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      long consumerId= deleteObject.getLong("consumer_id");
      long consumerAddressId=deleteObject.getLong("consumer_address_id");
      resultObject=  consumerDAO.deleteAddress(consumerId, consumerAddressId);
     if(resultObject==null)
       resultObject=new JsonObject();
    }catch(Exception e){
      e.printStackTrace();
    }
    return resultObject;
  }
  public String getLatestFcmId(long consumerId,HttpServletRequest request){
    String fcmId="";
    try{
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      fcmId=consumerDAO.findUserLatestFcmId(consumerId);
    }catch(Exception e){
      e.printStackTrace();
    }
    return fcmId;
  }
  public String getConsumerOrdersSize(long consumerId,HttpServletRequest request){
    String   result=null;
     try{
       
       
       //OrderDAO  orderDAO=(OrderDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "orderDAOImpl",request);
     //  int size=  orderDAO.findOrderListSizeByConsumerId(consumerId);
       @SuppressWarnings("static-access")
      int size=  GDataStoreUtills.getInstance().getCountByFilter("OrderInfoEntity", "consumerKey", consumerId);
       if(size!=0){
         result="BOOKED";
       }else{
         result="NOT_YET";
       }
     }catch(Exception e){
       
       e.printStackTrace();
     }
   
   return result;
 }
  /**
   * @return the consumerProifle
   */
  public ConsumerProfile getConsumerProifle() {
    return consumerProifle;
  }
  /**
   * @param consumerProifle the consumerProifle to set
   */
  public void setConsumerProifle(ConsumerProfile consumerProifle) {
    this.consumerProifle = consumerProifle;
  }
  
  public String writeToBucket(String fileName,byte[] squareCardImageBytes){
    String photoUrl="";
    JsonObject report=new JsonObject();
    try{
      BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

      ImagesService imagesService = ImagesServiceFactory.getImagesService();
     // File fileObj=new File(filePath);
      // byte[] data=   Files.readAllBytes(fileObj.toPath());
          //FileInputStream fileInputStream=new FileInputStream(fileObj);
          //byte[] squareCardImageBytes = new byte[(int)fileObj.length()];
     String BUCKETNAME="virranbi.appspot.com";
      String gcsCardObjectName =fileName+".jpg" ;
      String bucket =  "/gs/"+ BUCKETNAME + "/" + gcsCardObjectName;
     // String gcsPath = "/gs/" + bucket + "/" + gcsCardObjectName;
      GcsFilename gcsCardFilename = new GcsFilename(BUCKETNAME, gcsCardObjectName);
      GcsFileOptions gcsOptions = new GcsFileOptions.Builder().mimeType("image/jpeg").build();
      GcsService gcsService = GcsServiceFactory.createGcsService();
      GcsOutputChannel outputChannel = gcsService.createOrReplace(gcsCardFilename, gcsOptions);
      outputChannel.write(ByteBuffer.wrap(squareCardImageBytes));
      outputChannel.close();

      //generate a blobkey for the GCS object.
      //this is a little different because the blobkey is based off the GCS filename
      //and it doesn't actually check that the object exists in GCS so it's fast and immediately available
     // BlobKey cardBlobKey = blobstoreService.createGsBlobKey(bucket);
     //blobstoreService.
     // String keyString= cardBlobKey.getKeyString();     //generate the two image URLs
     // BlobKey blobKeey=new BlobKey(keyString);
      //System.out.println(keyString);
    // System.out.println( getImageURL("/gs/virranbi.appspot.com/Grocery Images/beverages/100006629_2-horlicks-junior-health-nutrition-drink-original-flavor-stage-1-2-3-years.jpg"));
      //blobstoreService.serve(cardBlobKey, response);
      //photoUrl = imagesService.getServingUrl(cardBlobKey, true);       
     /* ServingUrlOptions options = ServingUrlOptions.Builder.withBlobKey(blobKeey).secureUrl(false);
      photoUrl = imagesService.getServingUrl(
          ServingUrlOptions.Builder.withBlobKey(blobKeey));
      String servingUrl = ImagesServiceFactory.getImagesService().getServingUrl(options);

       photoUrl = imagesService.getServingUrl(
       ServingUrlOptions.Builder.withBlobKey(cardBlobKey));
      String cardUrl = imagesService.getServingUrl(
       ServingUrlOptions.Builder.withBlobKey(cardBlobKey));*/
      
      

      BlobKey cardBlobKey = blobstoreService.createGsBlobKey(bucket);
      //generate the two image URLs
      // photoUrl = imagesService.getServingUrl(ServingUrlOptions.Builder.withBlobKey(blobKey));
      String cardUrl = imagesService.getServingUrl(ServingUrlOptions.Builder.withBlobKey(cardBlobKey));
      report.addProperty("result", "success");
      report.addProperty("imageurl", cardUrl);
      
    }catch(Exception e){
      report.addProperty("result", "error");
      report.addProperty("result_update1", "error");
      report.addProperty("error_def", e.getMessage());
      e.printStackTrace();
      
    }
    
    return report.toString();
   }
  
  public String saveUserCurrentLocation(LocationInfoEntity locationInfo,HttpServletRequest request){
    JsonObject jsonObj=null;
    locationInfo.setCurentDateTime(DateUtilities.convertStringDateToUtil(DateUtilities.getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS), DateUtilities.YYYY_MM_DD_24HH_MM_SS));
    try{
      jsonObj=new JsonObject();
      ConsumerDAO  consumerDAO=(ConsumerDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "consumerDAOImpl",request);
      jsonObj.addProperty("status", consumerDAO.saveUserLocaion(locationInfo));    
    }catch(Exception e){
      jsonObj=new JsonObject();
      jsonObj.addProperty("status", "failure");  
      e.printStackTrace();
    }
    return jsonObj.toString();
  }
  public void sendNewLoginNotification(long consumerKey,HttpServletRequest request){
    
      try {
              ConsumerHandler consumerHandler=new ConsumerHandler();
              ConsumerProfile consumerProfile=   consumerHandler.getConsumerProfile(consumerKey, request);
              String fcmId= consumerHandler.getLatestFcmId(consumerKey,request);
              if(consumerProfile!=null){
                JSONObject dataPayloadObj =new JSONObject();
                
                dataPayloadObj.put("title","Login Alert");
                dataPayloadObj.put("body","You have been login from new device.");
                dataPayloadObj.put("sound","default");
                dataPayloadObj.put("image","bootleicon");
                dataPayloadObj.put("click_action","NotificationListActivity.class");
                
                NotificationEntity notificationEntity=new NotificationEntity();
                notificationEntity.setReceiverFCMKey(fcmId);
                notificationEntity.setReceiverId(consumerKey);
                notificationEntity.setNotificationType(Constants.NOTI_BOOKING_CONIRM);
                notificationEntity.setSenderFCMKey(Constants.FIREBASE_CUSTOMER_FCM_KEY);
                notificationEntity.setDataPayLoad(dataPayloadObj);
                NotificationUtills.composeNotification(notificationEntity);
                
              }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
  }
  public static byte[] resizeImage(Image oldImage, int height, int width, ImagesService imagesService)
  {
      InputSettings is = new InputSettings();
      is.setOrientationCorrection(InputSettings.OrientationCorrection.CORRECT_ORIENTATION);
      OutputSettings os = new OutputSettings(ImagesService.OutputEncoding.JPEG);
      Transform resizeToCard = ImagesServiceFactory.makeResize(width,height);
      Image squareCardImage = imagesService.applyTransform(resizeToCard, oldImage, is, os);
      byte[] squareCardImageBytes = squareCardImage.getImageData();
      return squareCardImageBytes;
  }
}


/*
 * Command for generate security file
 * keytool -genkey -alias emptycan -keystore C:\Users\varadhan\keystore.pfx -storepass Symonds@123 -validity 365 -keyalg RSA -keysize 2048 -storetype pkcs12*/
 