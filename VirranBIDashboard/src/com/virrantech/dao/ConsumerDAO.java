package com.virrantech.dao;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.virrantech.entity.ConsumerAddress;
import com.virrantech.entity.ConsumerFCMInfoEntity;
import com.virrantech.entity.LocationInfoEntity;
import com.virrantech.entity.NotificationEntity;
import com.virrantech.entity.PasswordEntity;
import com.virrantech.entity.ConsumerProfile;
import com.virrantech.entity.ServiceRequestEntity;
import com.virrantech.entity.UserReferralEntity;

public interface ConsumerDAO {

  public JSONObject getConsumerUserProfile(String consumerKey);

  public boolean isValidConsumer(String consumerUserName, String consumerPassword);

  public JSONObject getConsumerAddress(String consumerKey);

  public JsonObject insertConsumerServiceRequest(ServiceRequestEntity serviceRequest);

  public JSONArray getConsumerServiceRequests(String consumerKey, String date);

  public JSONArray getConsumerServiceRequests(String consumerKey);

  public JsonObject insertConsumer(ConsumerProfile consumerProfile);

  public JsonObject updateConsumerProfile(ConsumerProfile consumerProfile);

  public JSONObject updateConsumerAddress(String consumerKey, String consumerAddress);

  public JSONObject changeConsumerPassword(String consumerKey, String oldPassword,
      String newPassword);

  public JSONObject rateDistributorByService(String consumerKey, String distributorKey,
      int ratingsCnt);

  public JSONObject rateDistributorByDelivery(String consumerKey, String deliveryBoyId,
      int ratingsCnt);

  public JSONObject addDistributor(String consumerKey, String distributorKey, String addedDate);

  public JsonObject addBasicProfile(ConsumerProfile consumerProfile);

  public String getConsumerList();

  public JsonObject insertPassword(PasswordEntity passwordEntity);

  public PasswordEntity getPasswordEntity(Long passWrdId);

  public ConsumerProfile findConsumerById(Long consumerId);

  public ConsumerProfile findConsumerUserName(String uNaee);

  public JsonObject saveConsumerAddress(Long consumerId, ConsumerAddress consumerAddress);

  public JsonObject saveNotification(NotificationEntity notificationEntity);

  public JsonArray findNotificationByUser(Long consumerId);

  public JsonArray findAddressByUser(Long consumerId);

  public JsonObject saveConsumerFcmInfo(ConsumerFCMInfoEntity consumerFCMInfoEntity);

  public boolean checkPhoneNumberExists(String phoneNumber);

  public ConsumerAddress findConsumerDefaultAddress(long consumerId);

  public boolean updateNotificationReceivedStatus(long consumerId, String messageId);
  
  public JsonObject deleteAddress(long consumerId,long addressId);
  public JsonObject changeDefaultAddress(long consumerId,long addressId);
  public JsonObject saveReferralDetails(UserReferralEntity userReferralEntity);
  public String updateUserRefferalCode(long userRefferalCode,long benificaryId,String status);
  public String findUserLatestFcmId(long consumerId);
  public String updateConsumerIdInFcm(long consumerId,String phoneKey);
  public String updateConsumerImage(long consumerId,String consumerImgUrl,String blobKey);
  public String saveUserLocaion(LocationInfoEntity locationInfoEntity);
  
}
