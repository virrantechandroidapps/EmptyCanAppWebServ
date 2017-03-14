package com.virrantech.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.JsonObject;
import com.virrantech.dao.OrderDAO;
import com.virrantech.daoimpl.OrderDAOImpl;
import com.virrantech.entity.ConsumerProfile;
import com.virrantech.entity.NotificationEntity;
import com.virrantech.entity.OrderInfoEntity;
import com.virrantech.utills.Constants;
import com.virrantech.utills.DateUtilities;
import com.virrantech.utills.NotificationUtills;
import com.virrantech.utills.SpringBeanUtils;

public class OrderHandler {

  public String addNewOrder(OrderInfoEntity orderInfoEntity, HttpServletRequest request){
   JsonObject  result=null;
   String fcmId= "";
    try{
      String currentDateTime=DateUtilities.getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS);
      orderInfoEntity.setOrderDoneDateTime(currentDateTime);
      Date date=DateUtilities.convertStringDateToUtil(currentDateTime,DateUtilities.YYYY_MM_DD_24HH_MM_SS);
      orderInfoEntity.setOrderReceivedDateTime(date);
      orderInfoEntity.setOrderStatusModifiedTime(date);
     // String timePart=currentDateTime.split("\\s+")[1].replaceAll("[^\\d.]", "");
      //String timePart=currentDateTime.replaceAll("[^\\d.]", "");
       long consumerKey=orderInfoEntity.getConsumerKey();
       //String orderId="OID"+consumerKey%100000+timePart;
      //orderInfoEntity.setOrderId(orderId);
      OrderDAO  orderDAO=(OrderDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "orderDAOImpl",request);
      result=  orderDAO.saveOrder(orderInfoEntity);
     // orderId
      if(result.get("status").getAsString().equals("success")){
        ConsumerHandler consumerHandler=new ConsumerHandler();
        try {
          if(orderInfoEntity.getRefStatus().equals("HOLDREFERENCE") && orderInfoEntity.getIsFirstTimeBooking().equals("NOT_YET")){
            long referrerId= orderDAO.updateUserRefferalCode(orderInfoEntity.getConsumerKey(), "BOOKED","TOBEREEDEM");
            String referrerFcmId= consumerHandler.getLatestFcmId(referrerId, request);
            JSONObject dataPayloadObj =new JSONObject();
            
            dataPayloadObj.put("title","Congratz.");
            dataPayloadObj.put("body","You won free watercan for \n your referral.\n Please redeem it on your next booking.");
            dataPayloadObj.put("sound","default");
            dataPayloadObj.put("image","bootleicon");
            dataPayloadObj.put("click_action","NotificationListActivity.class");
            
            NotificationEntity notificationEntity=new NotificationEntity();
            notificationEntity.setReceiverFCMKey(referrerFcmId);
            notificationEntity.setReceiverId(consumerKey);
            notificationEntity.setNotificationType(Constants.NOTI_OFFER);
            notificationEntity.setSenderFCMKey(Constants.FIREBASE_CUSTOMER_FCM_KEY);
            notificationEntity.setDataPayLoad(dataPayloadObj);
            NotificationUtills.composeNotification(notificationEntity);
            
          }
               
          if(orderInfoEntity.getUserFcmId().equals("NOT_FOUND")){
            fcmId=consumerHandler.getLatestFcmId(consumerKey,request);;
          }else
            fcmId=orderInfoEntity.getUserFcmId();
               // ConsumerProfile consumerProfile=   consumerHandler.getConsumerProfile(consumerKey, request);
               // String fcmId= consumerHandler.getLatestFcmId(consumerKey,request);
                //if(consumerProfile!=null){
                  JSONObject dataPayloadObj =new JSONObject();
                  
                  dataPayloadObj.put("title","Booking Confirmed");
                  dataPayloadObj.put("body","Our delivery boy will \n reach you soon.\n Your Order no: "+result.get("order_otp").getAsString()+"");
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
                  
                //}
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      else{
        
      }
    }catch(Exception e){
      result=new JsonObject();
      result.addProperty("status", "error"+e.getMessage());
      e.printStackTrace();
    }
  
  return result.toString();
}
  public String getConsumerOrders(JSONObject queryInfo,HttpServletRequest request){
    String   result=null;
     try{
       long consumerId= queryInfo.getLong("consumerKey");
       int rangefrom=queryInfo.getInt("range_from");
       int rangeto=queryInfo.getInt("range_to");
       OrderDAO  orderDAO=(OrderDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "orderDAOImpl",request);
       result=  orderDAO.findOrdersbyConsumerId(consumerId,rangefrom,rangeto).toString();
     }catch(Exception e){
       
       e.printStackTrace();
     }
   
   return result;
 }
  public String getCartListOfOrder(long orderId,HttpServletRequest request){
    String   result=null;
     try{
      
       OrderDAO  orderDAO=(OrderDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "orderDAOImpl",request);
       result=  orderDAO.findCartsByOrderId(orderId);
     }catch(Exception e){
       
       e.printStackTrace();
     }
   
   return result;
 }
  public String cancelBookingOrder(long orderId,String cancelledBy,HttpServletRequest request){
    JsonObject   result=null;
     try{
      
       OrderDAO  orderDAO=(OrderDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "orderDAOImpl",request);
       result=  orderDAO.cancelOrder(orderId,cancelledBy);
       if(result.get("status").getAsString().equals("success")){
         String fcmId= result.get("fcm_id").getAsString();
         String orderRefNo= result.get("order_id").getAsString();
         JSONObject dataPayloadObj =new JSONObject();
         
         String stausMessage="";
         String title="";
         if(cancelledBy.equals(Constants.ORDER_CANCELLED_BY_CUS)){
           stausMessage=" cancelled By you";
           title="You Order Cancelled";
         }else if(cancelledBy.equals(Constants.ORDER_CANCELLED_BY_DELVIRYBOY)){
           stausMessage=" cancelled By Team";
           title="You Order Cancelled";
         }else if(cancelledBy.equals(Constants.ORDER_SCHEDULED)){
           stausMessage=" order schedulled.our team will deliver shortly.";
           title="You Order Schedulled";
         }
         dataPayloadObj.put("title",title);
         dataPayloadObj.put("body","Order Ref.No "+orderRefNo+"\n"+stausMessage);
         dataPayloadObj.put("sound","default");
         dataPayloadObj.put("image","bootleicon");
         dataPayloadObj.put("click_action","NotificationListActivity.class");
         
         NotificationEntity notificationEntity=new NotificationEntity();
         notificationEntity.setReceiverFCMKey(fcmId);
        // notificationEntity.setReceiverId(consumerKey);
         notificationEntity.setNotificationType(Constants.NOTI_BOOKING_CONIRM);
         notificationEntity.setSenderFCMKey(Constants.FIREBASE_CUSTOMER_FCM_KEY);
         notificationEntity.setDataPayLoad(dataPayloadObj);
         NotificationUtills.composeNotification(notificationEntity);
       }
     }catch(Exception e){
       
       e.printStackTrace();
     }
   
   return result.toString();
 }
  public String getOrderForDistributors(long distributorId,HttpServletRequest request){
   String result="";
    try{
      OrderDAO  orderDAO=(OrderDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "orderDAOImpl",request);
      result=  orderDAO.getRecentOrders(distributorId,Constants.ORDER_INITIATED);
    }catch(Exception e){
      
    }
    return result;
    
  }
}
