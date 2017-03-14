package com.virrantech.daoimpl;

import java.util.List;
import java.util.regex.Pattern;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.virrantech.dao.OrderDAO;
import com.virrantech.entity.CartInfoEntity;
import com.virrantech.entity.ConsumerProfile;
import com.virrantech.entity.OrderInfoEntity;
import com.virrantech.entity.UserReferralEntity;
import com.virrantech.utills.DateUtilities;
import com.virrantech.utills.GDataStoreUtills;
import com.virrantech.utills.HOTPAlgorithm;
import com.virrantech.utills.PMF;

public class OrderDAOImpl implements OrderDAO {
public GDataStoreUtills gDataStreUtills=null; 
  
  @Override
  public JsonObject saveOrder(OrderInfoEntity orderInfoEntity) {
    JsonObject jsonObject=null;
    PersistenceManager  pm = PMF.get().getPersistenceManager();
    try{
      orderInfoEntity.setGpsProvider(null);
      pm.makePersistent(orderInfoEntity);
      List<CartInfoEntity> cartIList= orderInfoEntity.getCartInfoList();
      jsonObject=new JsonObject();
      int totalNo= GDataStoreUtills.getCount("OrderInfoEntity");
      String orderOTP= HOTPAlgorithm.generateOTP(HOTPAlgorithm.getCode(), totalNo, 4, false, totalNo);
      String orderId="OID_"+totalNo+"_"+orderOTP;
      orderInfoEntity.setOrderId(orderId);
      Thread.sleep(200);
      long orderKey=orderInfoEntity.getId().getId();
      if(cartIList!=null){
         int size=cartIList.size();
         for(int m=0;m<size;m++){
           CartInfoEntity cartInfoEntity=  cartIList.get(m);
           cartInfoEntity.setOrderId(orderKey);
           pm.makePersistent(cartInfoEntity);
           Thread.sleep(200); 
         }
      }
      //Thread.sleep(200);
      jsonObject.addProperty("order_server_id", orderKey);
      jsonObject.addProperty("status","success");
      
     
      jsonObject.addProperty("order_otp",orderId);
    }catch(Exception e){
      jsonObject=new JsonObject();
      jsonObject.addProperty("status", "error"+e.getMessage());
      e.printStackTrace();
      
    }finally {
      pm.close();
    }

    return jsonObject;
  }

  
  @Override
  public JsonObject saveCart(CartInfoEntity cartInfoEntity) {
    JsonObject jsonObject=null;
    PersistenceManager  pm = PMF.get().getPersistenceManager();
    try{
      jsonObject=new JsonObject();
      cartInfoEntity=pm.makePersistent(cartInfoEntity);
      jsonObject.addProperty("cart_server_id", cartInfoEntity.getId().getId());
      jsonObject.addProperty("status","success");
    }catch(Exception e){
      jsonObject.addProperty("status", "error");
      e.printStackTrace();
    }finally {
      pm.close();
    }

    return jsonObject;
  }
  @SuppressWarnings("unchecked")
  @Override
  public JsonArray findOrdersbyConsumerId(long consumerId,int rangeFrm,int rangeTo) {
   // rangeFrm=0;
   // rangeTo=10;
    JsonArray jsonArray=null;
    PersistenceManager  pm=null;
    List <OrderInfoEntity> orderInfoEntityList =null;
  Query query = null;
    try{
     pm = PMF.get().getPersistenceManager();
     
     query = pm.newQuery( OrderInfoEntity.class ,"consumerKey=="+consumerId+"");
     query.setRange(rangeFrm, rangeTo);
     query.setOrdering("orderReceivedDateTime desc");
     //query.set
     orderInfoEntityList=  (List<OrderInfoEntity>) query.execute();
   
     
     //orderInfoEntityList.size();
     if(orderInfoEntityList!=null){
       Gson gson = new Gson();
      // Collections.sort(orderInfoEntityList,Collections.reverseOrder());
      for(int i=0;i<orderInfoEntityList.size();i++){
        System.out.println( orderInfoEntityList.get(i).getOrderReceivedDateTime());
        OrderInfoEntity orderInfoEntity=  orderInfoEntityList.get(i);
        String date= orderInfoEntity.getOrderDoneDateTime();
        orderInfoEntity.setFormattedDate(DateUtilities.convertTimeToISTFormate(date));
        //orderInfoEntity.setFormattedDate(changeFormage(orderInfoEntity.getFormattedDate()));
       }
      /*JSONUtils jsonUtills=new JSONUtils();
      JsonObject jsonObject=jsonUtills.getJSONObject(orderInfoEntityList);
      System.out.println(jsonObject);*/
       String strJsonArray =gson.toJson(orderInfoEntityList, new TypeToken<List<OrderInfoEntity>>() {}.getType());
        JsonParser parser = new JsonParser();
       JsonElement tradeElement = parser.parse(strJsonArray);
       jsonArray= tradeElement.getAsJsonArray();
     }
     

     }catch(Exception e){
      
       e.printStackTrace();
    }finally {
      pm.close();
    }
    System.out.println(jsonArray);
    return jsonArray;
  }

  @Override
  @SuppressWarnings("unchecked")
  public int findOrderListSizeByConsumerId(long consumerId) {
    
   int totalOrders=0;
    PersistenceManager  pm=null;
    List <OrderInfoEntity> orderInfoEntityList =null;
  Query query = null;
    try{
     pm = PMF.get().getPersistenceManager();
     
     query = pm.newQuery( OrderInfoEntity.class ,"consumerKey=="+consumerId+"");
     orderInfoEntityList=  (List<OrderInfoEntity>) query.execute();
   
     //orderInfoEntityList.size();
     if(!orderInfoEntityList.isEmpty()){
       totalOrders=orderInfoEntityList.size();
     }
     

     }catch(Exception e){
      
       e.printStackTrace();
    }finally {
      pm.close();
    }
    return totalOrders;
  }
  @Override
  public long updateUserRefferalCode(long benificaryId, String status,String redeemStatus) {
    PersistenceManager  pm=null;
    UserReferralEntity userRefferalEntity=null;
    long referrerId=0l;
    try{
      pm = PMF.get().getPersistenceManager();
      pm.currentTransaction().begin();
      Query query=   pm.newQuery(UserReferralEntity.class,"benificaryId == "+benificaryId+"" );
      List<UserReferralEntity> notificationListEntity= (List<UserReferralEntity>) query.execute();
      
      if ( !notificationListEntity.isEmpty() ){
        //Collections.sort(notificationListEntity,Collections.reverseOrder());
        userRefferalEntity = notificationListEntity.get( 0 );
      }
        
      if(userRefferalEntity!=null){
        userRefferalEntity.setStatus(status);
        userRefferalEntity.setRedeemStatus(redeemStatus);
        referrerId= userRefferalEntity.getRefererId();
        //userRefferalEntity.setBenificaryId(benificaryId);
        pm.currentTransaction().commit();
        return referrerId;
      }else{
        return referrerId;
      }
     
    
  }catch(Exception e){
    e.printStackTrace();
    return referrerId;
  }
   
  }
  public String changeFormage(String inputDteStr){
    String formatedDate="";
     try{
      String todayDate= DateUtilities.convertTimeToISTFormate(DateUtilities.getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS)).split("\\s+")[0];
      String[] inputDate= inputDteStr.split("\\s+");
      int yesterDate= Integer.parseInt(todayDate.split(Pattern.quote("-"))[2])-1;
      int compareDate= Integer.parseInt(inputDate[0].split(Pattern.quote("-"))[2]);
      
      if(todayDate.equals(inputDate[0])){
        formatedDate=   inputDate[0]="Today,"+inputDate[1];
      }else if(yesterDate==compareDate){
        formatedDate=   inputDate[0]="Yesterday,"+inputDate[1];
      }else{
        formatedDate=inputDteStr;
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    
     return formatedDate;
   }


  @Override
  public String findCartsByOrderId(long orderId) {
    // rangeFrm=0;
    // rangeTo=10;
     String strJsonArray=null;
     PersistenceManager  pm=null;
     List <CartInfoEntity> cartInfoEntityLst =null;
   Query query = null;
     try{
      pm = PMF.get().getPersistenceManager();
      query = pm.newQuery( CartInfoEntity.class ,"orderId=="+orderId+"");
           //query.set
      cartInfoEntityLst=  (List<CartInfoEntity>) query.execute();
    //orderInfoEntityList.size();
      if(cartInfoEntityLst!=null && cartInfoEntityLst.size() > 0){
        Gson gson = new Gson();
          strJsonArray =gson.toJson(cartInfoEntityLst, new TypeToken<List<CartInfoEntity>>() {}.getType());
        /* JsonParser parser = new JsonParser();
        JsonElement tradeElement = parser.parse(strJsonArray);
        jsonArray= tradeElement.getAsJsonArray();*/
      }
      
      }catch(Exception e){
       
        e.printStackTrace();
     }finally {
       pm.close();
     }
    
     return strJsonArray;
   }


  @Override
  public JsonObject cancelOrder(long orderId,String cancelledby) {
    PersistenceManager pm = null;
    OrderInfoEntity orderInfoEntity = null;
  JsonObject jsonObject=null;
    try {
      pm = PMF.get().getPersistenceManager();
      pm.currentTransaction().begin();
      orderInfoEntity=new OrderInfoEntity();
      orderInfoEntity.setId(KeyFactory.createKey("OrderInfoEntity", orderId));
      orderInfoEntity = pm.getObjectById(OrderInfoEntity.class, KeyFactory.createKey("OrderInfoEntity", orderId));
      
      
      
      
      if (orderInfoEntity != null) {
      
        orderInfoEntity.setOrderStatus(cancelledby);
        orderInfoEntity.setOrderStatusModifiedTime(DateUtilities.convertStringDateToUtil(DateUtilities.getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS), DateUtilities.YYYY_MM_DD_24HH_MM_SS));
        pm.currentTransaction().commit();
        jsonObject= new JsonObject();
        jsonObject.addProperty("status", "success");
        jsonObject.addProperty("fcm_id", orderInfoEntity.getUserFcmId());
        jsonObject.addProperty("order_id", orderInfoEntity.getOrderId());
      } else {
        jsonObject= new JsonObject();
        jsonObject.addProperty("status", "faillure");
      }


    } catch (Exception e) {
      jsonObject= new JsonObject();
      jsonObject.addProperty("status", "faillure");
      e.printStackTrace();
    
    }
    return jsonObject;

  }


  @Override
  public String getRecentOrders(long distributorId, String status) {
 // rangeFrm=0;
    // rangeTo=10;
     String strJsonArray=null;
     PersistenceManager  pm=null;
     List <OrderInfoEntity> cartInfoEntityLst =null;
   Query query = null;
     try{
      pm = PMF.get().getPersistenceManager();
      query = pm.newQuery( OrderInfoEntity.class ,"distibutorId =="+distributorId+" && orderStatus=='"+status+"'");
      query.setOrdering("orderReceivedDateTime desc");
           //query.set
      cartInfoEntityLst=  (List<OrderInfoEntity>) query.execute();
    //orderInfoEntityList.size();
      if(cartInfoEntityLst!=null && cartInfoEntityLst.size() > 0){
        Gson gson = new Gson();
          strJsonArray =gson.toJson(cartInfoEntityLst, new TypeToken<List<OrderInfoEntity>>() {}.getType());
        /* JsonParser parser = new JsonParser();
        JsonElement tradeElement = parser.parse(strJsonArray);
        jsonArray= tradeElement.getAsJsonArray();*/
      }
      
      }catch(Exception e){
       
        e.printStackTrace();
     }finally {
       pm.close();
     }
    
     return strJsonArray;
  }

  



  
}
