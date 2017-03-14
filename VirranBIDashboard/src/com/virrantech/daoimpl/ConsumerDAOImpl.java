package com.virrantech.daoimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.apache.commons.lang.StringEscapeUtils;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.virrantech.dao.ConsumerDAO;
import com.virrantech.entity.ConsumerAddress;
import com.virrantech.entity.ConsumerFCMInfoEntity;
import com.virrantech.entity.ConsumerProfile;
import com.virrantech.entity.LocationInfoEntity;
import com.virrantech.entity.NotificationEntity;
import com.virrantech.entity.OrderInfoEntity;
import com.virrantech.entity.PasswordEntity;
import com.virrantech.entity.ServiceRequestEntity;
import com.virrantech.entity.UserReferralEntity;
import com.virrantech.utills.DateUtilities;
import com.virrantech.utills.PMF;

public class ConsumerDAOImpl implements ConsumerDAO {

  @Override
  public JSONObject getConsumerUserProfile(String consumerKey) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isValidConsumer(String consumerUserName, String consumerPassword) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public JSONObject getConsumerAddress(String consumerKey) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JsonObject insertConsumerServiceRequest(ServiceRequestEntity serviceRequest) {
    JsonObject jsonObject = null;
    try {
      jsonObject = new JsonObject();
      PersistenceManager pm = PMF.get().getPersistenceManager();
      serviceRequest = pm.makePersistent(serviceRequest);
      jsonObject.addProperty("service_server_key", serviceRequest.getId().getId());
      jsonObject.addProperty("status", "success");
    } catch (Exception e) {
      jsonObject.addProperty("status", "error");
      e.printStackTrace();
    }

    return jsonObject;

  }

  @Override
  public ConsumerAddress findConsumerDefaultAddress(long consumerId) {
    ConsumerAddress consumerAddress = null;
    PersistenceManager pm = null;
    List<ConsumerAddress> consumerAddressList = null;
    Query query = null;
    try {
      pm = PMF.get().getPersistenceManager();
      consumerAddress = new ConsumerAddress();

      /*
       * query = pm.newQuery( ConsumerProfile.class); query.setFilter("consumerProfileId == :1");
       * Map<String, Long> paramValues = new HashMap(); paramValues.put("1", consumerId);
       */
      // paramValues.put("2", "YES");
      query =
          pm.newQuery(ConsumerAddress.class, "consumerProfileId == " + consumerId
              + " && defaultAddress == 'YES'");
      consumerAddressList = (List<ConsumerAddress>) query.execute();
      if (!consumerAddressList.isEmpty())
        consumerAddress = consumerAddressList.get(0);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      pm.close();
    }
    return consumerAddress;
  }



  @Override
  public JSONArray getConsumerServiceRequests(String consumerKey, String date) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JSONArray getConsumerServiceRequests(String consumerKey) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JsonObject insertConsumer(ConsumerProfile consumerProfile) {
    JsonObject jsonObject = null;
    try {
      jsonObject = new JsonObject();
      PersistenceManager pm = PMF.get().getPersistenceManager();
      String consumerPassword = consumerProfile.getConsumerPassword();
      consumerProfile = pm.makePersistent(consumerProfile);
      Long cnsumrId = consumerProfile.getId().getId();
      PasswordEntity passwrdEntity = new PasswordEntity();
      passwrdEntity.setUserId(cnsumrId);
      passwrdEntity.setPswrdLastUpdatedDate(DateUtilities
          .getCurrentDateAsString(DateUtilities.DD_MON_YYYY_24HH_MM_SS));
      passwrdEntity.setUserPassword(consumerPassword);
      JsonObject passWrdRslt = insertPassword(passwrdEntity);
      if (passWrdRslt.get("status").getAsString().equals("success")) {
        jsonObject.addProperty("consumer_pswrd_key", passWrdRslt.get("passwrd_id").getAsString());
        jsonObject.addProperty("consumer_key", cnsumrId);
        jsonObject.addProperty("status", "success");
      } else {
        jsonObject.addProperty("status", "error");
      }

    } catch (Exception e) {
      jsonObject.addProperty("status", "error");
      e.printStackTrace();
    }

    return jsonObject;
  }

  @Override
  public JsonObject updateConsumerProfile(ConsumerProfile consumerProfile) {
    PersistenceManager pm = null;
    JsonObject jsonObject = null;
    try {
      jsonObject = new JsonObject();
      pm = PMF.get().getPersistenceManager();
      pm.makePersistent(consumerProfile);
      jsonObject.addProperty("status", "success");
    } catch (Exception e) {
      jsonObject.addProperty("status", "fail");
      e.printStackTrace();
    }
    return jsonObject;
  }

  @Override
  public JSONObject updateConsumerAddress(String consumerKey, String consumerAddress) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JSONObject changeConsumerPassword(String consumerKey, String oldPassword,
      String newPassword) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JSONObject rateDistributorByService(String consumerKey, String distributorKey,
      int ratingsCnt) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JSONObject rateDistributorByDelivery(String consumerKey, String deliveryBoyId,
      int ratingsCnt) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JSONObject addDistributor(String consumerKey, String distributorKey, String addedDate) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getConsumerList() {
    String consumerJsonArrayString = null;
    PersistenceManager pm = null;
    try {
      pm = PMF.get().getPersistenceManager();
      Query queryForConsumerList = pm.newQuery(ConsumerProfile.class, "");
      @SuppressWarnings("unchecked")
      List<ConsumerProfile> consumerProfileList =
          (List<ConsumerProfile>) queryForConsumerList.execute();
      /*
       * List<ConsumerProfile> consumerProfileList=dummyList; Iterator<ConsumerProfile>
       * iterator=consumerProfileList.iterator(); while(iterator.hasNext()){ ConsumerProfile
       * consumerProfile= iterator.next(); Iterator<ConsumerAddress> addressIterator=
       * consumerProfile.getConsumerAddressList().iterator(); while(addressIterator.hasNext()){
       * ConsumerAddress consumerAddress= addressIterator.next(); addressIterator.remove(); } }
       */
      /*
       * if(!consumerProfileList.isEmpty()){ for(int s=0;s<consumerProfileList.size();s++){
       * if(consumerProfileList.get(s).getConsumerAddressList() !=null &&
       * !(consumerProfileList.get(s).getConsumerAddressList().isEmpty())){ int
       * leng=consumerProfileList.get(s).getConsumerAddressList().size(); for(int m=0;m<leng;m++){
       * consumerProfileList.get(s).getConsumerAddressList().remove(m); } }
       * 
       * } }
       */

      Gson gson = new Gson();
      consumerJsonArrayString =
          gson.toJson(consumerProfileList, new TypeToken<List<ConsumerProfile>>() {}.getType());
      System.out.println(consumerJsonArrayString);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      pm.close();
    }
    return consumerJsonArrayString;
  }

  @Override
  public JsonObject addBasicProfile(ConsumerProfile consumerProfile) {
    JsonObject consumerProfileData = new JsonObject();
    PersistenceManager pm = null;
    try {

      pm = PMF.get().getPersistenceManager();
      long consumerId = consumerProfile.getConsumerProfileId();
      ConsumerProfile newConsumerProfile = (ConsumerProfile) findConsumerById(consumerId);
      newConsumerProfile.setConsumerName(consumerProfile.getConsumerName());
      newConsumerProfile.setConsumerDOB(consumerProfile.getConsumerDOB());
      newConsumerProfile.setConsumerEmailId(consumerProfile.getConsumerEmailId());
      newConsumerProfile.setConsumerGender(consumerProfile.getConsumerGender());
      newConsumerProfile.setConsumerProfileImageBlobUrl(consumerProfile
          .getConsumerProfileImageBlobUrl());
      newConsumerProfile.setConsumerProfileLastUpdate(DateUtilities
          .getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS));
      pm.makePersistent(newConsumerProfile);
      consumerProfileData.addProperty("status", "success");

    } catch (Exception e) {
      consumerProfileData.addProperty("status", "failliure");
      e.printStackTrace();
    } finally {
      pm.close();
    }
    return consumerProfileData;
  }

  @Override
  public JsonObject insertPassword(PasswordEntity passwordEntity) {
    JsonObject result = null;
    PersistenceManager pm = null;
    try {
      result = new JsonObject();
      pm = PMF.get().getPersistenceManager();
      passwordEntity = pm.makePersistent(passwordEntity);
      result.addProperty("passwrd_id", passwordEntity.getId().getId());
      result.addProperty("status", "success");
    } catch (Exception e) {
      result.addProperty("status", "error");
      e.printStackTrace();
    } finally {
      pm.close();
    }
    return result;
  }

  @Override
  public PasswordEntity getPasswordEntity(Long passWrdId) {
    PersistenceManager pm = null;
    PasswordEntity passWrdEntity = null;
    try {
      passWrdEntity = new PasswordEntity();
      passWrdEntity.setId(KeyFactory.createKey("PasswordEntity", passWrdId));
      passWrdEntity = (PasswordEntity) pm.getObjectById(passWrdEntity);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return passWrdEntity;
  }

  @Override
  public ConsumerProfile findConsumerById(Long consumerId) {
    ConsumerProfile consumerProfile = null;
    PersistenceManager pm = null;
    List<ConsumerProfile> consumerProfileListFromDb = null;
    Query query = null;
    try {
      pm = PMF.get().getPersistenceManager();
      consumerProfile = new ConsumerProfile();
      Key keyId = KeyFactory.createKey("ConsumerProfile", consumerId);
      consumerProfile = (ConsumerProfile) pm.getObjectById(ConsumerProfile.class, keyId);

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      pm.close();
    }
    return consumerProfile;
  }

  @Override
  public ConsumerProfile findConsumerUserName(String uNaem) {

    ConsumerProfile consumerProfile = null;
    PersistenceManager pm = null;
    List<ConsumerProfile> consumerProfileListFromDb = null;
    Query query = null;
    try {
      pm = PMF.get().getPersistenceManager();
      query = pm.newQuery(ConsumerProfile.class, "consumerPhoneNumber == '" + uNaem + "' ");
      consumerProfileListFromDb = (List<ConsumerProfile>) query.execute();
      if (!consumerProfileListFromDb.isEmpty())
        consumerProfile = consumerProfileListFromDb.get(0);
    } catch (Exception e) {

      e.printStackTrace();
    } finally {
      pm.close();
    }
    return consumerProfile;

  }

  @Override
  public JsonObject saveConsumerAddress(Long consumerId, ConsumerAddress consumerAddress) {
    ConsumerProfile consumerProfile = null;
    PersistenceManager pm = null;
    JsonObject result = null;
    Key consumerKey = null;
    try {
      pm = PMF.get().getPersistenceManager();
      pm.currentTransaction().begin();
      consumerKey = KeyFactory.createKey("ConsumerProfile", consumerId);
      consumerProfile = (ConsumerProfile) pm.getObjectById(ConsumerProfile.class, consumerKey);
      System.out.println(StringEscapeUtils.escapeJavaScript(consumerAddress.getAddressAsJson()));
      consumerAddress.setAddressAsJson(StringEscapeUtils.escapeJavaScript(consumerAddress
          .getAddressAsJson()));
      if (consumerProfile.getConsumerAddressList() != null)
        consumerProfile.getConsumerAddressList().add(consumerAddress);
      else {
        List<ConsumerAddress> consumerAddressList = new ArrayList<ConsumerAddress>();
        consumerProfile.setConsumerAddressList(consumerAddressList);
        consumerProfile.getConsumerAddressList().add(consumerAddress);
      }

      pm.currentTransaction().commit();
      result = new JsonObject();
      result.addProperty("server_address_key", consumerAddress.getId().getId());
      result.addProperty("status", "success");

    } catch (Exception e) {
      result = new JsonObject();
      result.addProperty("status", "error");
      e.printStackTrace();
    } finally {
      if (pm.currentTransaction().isActive()) {
        pm.currentTransaction().rollback();
      }

    }
    return result;
  }

  @Override
  public JsonObject saveNotification(NotificationEntity notificationEntity) {
    PersistenceManager pm = null;
    JsonObject jsonObject = null;
    try {
      jsonObject = new JsonObject();
      pm = PMF.get().getPersistenceManager();
      pm.makePersistent(notificationEntity);
      jsonObject.addProperty("status", "success");
    } catch (Exception e) {
      jsonObject.addProperty("status", "fail");
      e.printStackTrace();
    } finally {
      pm.close();
    }
    return jsonObject;
  }

  @SuppressWarnings("unchecked")
  @Override
  public JsonArray findNotificationByUser(Long consumerId) {

    JsonArray jsonArray = null;
    PersistenceManager pm = null;
    List<NotificationEntity> notificationEntityFromDb = null;
    Query query = null;
    try {
      pm = PMF.get().getPersistenceManager();
      
      query =
          pm.newQuery(NotificationEntity.class, "receiverId==" + consumerId
              + " && isNotificationAcknowledged == 'TRUE'");
      notificationEntityFromDb = (List<NotificationEntity>) query.execute();
      notificationEntityFromDb.size();
      Gson gson = new Gson();
      String strJsonArray =
          gson.toJson(notificationEntityFromDb, new TypeToken<List<ConsumerProfile>>() {}.getType());
      JsonParser parser = new JsonParser();
      JsonElement tradeElement = parser.parse(strJsonArray);
      jsonArray = tradeElement.getAsJsonArray();

    } catch (Exception e) {

      e.printStackTrace();
    } finally {
      pm.close();
    }
    return jsonArray;
  }

  @Override
  public JsonObject saveConsumerFcmInfo(ConsumerFCMInfoEntity consumerFCMInfoEntity) {

    JsonObject jsonObject = null;
    PersistenceManager pm = null;
    try {
      jsonObject = new JsonObject();
      pm = PMF.get().getPersistenceManager();
      consumerFCMInfoEntity = pm.makePersistent(consumerFCMInfoEntity);
      jsonObject.addProperty("fcm_server_key", consumerFCMInfoEntity.getId().getId());
      jsonObject.addProperty("status", "success");
    } catch (Exception e) {
      jsonObject.addProperty("status", "error");
      e.printStackTrace();
    } finally {
      pm.close();
    }

    return jsonObject;

  }

  @Override
  public JsonArray findAddressByUser(Long consumerId) {


    JsonArray jsonArray = null;
    PersistenceManager pm = null;
    List<ConsumerAddress> consumerAddressList = null;
    Query query = null;
    try {
      pm = PMF.get().getPersistenceManager();

      query = pm.newQuery(ConsumerAddress.class, "consumerProfileId==" + consumerId + "");
      consumerAddressList = (List<ConsumerAddress>) query.execute();
      consumerAddressList.size();
      Gson gson = new Gson();
      String strJsonArray =
          gson.toJson(consumerAddressList, new TypeToken<List<ConsumerAddress>>() {}.getType());
      JsonParser parser = new JsonParser();
      JsonElement tradeElement = parser.parse(strJsonArray);
      jsonArray = tradeElement.getAsJsonArray();

    } catch (Exception e) {

      e.printStackTrace();
    } finally {
      pm.close();
    }
    return jsonArray;


  }

  @Override
  public boolean checkPhoneNumberExists(String phoneNumber) {

    PersistenceManager pm = null;
    List<ConsumerProfile> consumerProfileListFromDb = null;
    Query query = null;
    try {
      pm = PMF.get().getPersistenceManager();
      query = pm.newQuery(ConsumerProfile.class, "consumerPhoneNumber == '" + phoneNumber + "' ");
      consumerProfileListFromDb = (List<ConsumerProfile>) query.execute();
      return !consumerProfileListFromDb.isEmpty();

    } catch (Exception e) {

      e.printStackTrace();
    } finally {
      pm.close();
    }
    return false;
  }

  @Override
  public boolean updateNotificationReceivedStatus(long consumerId, String messageId) {
    PersistenceManager pm = null;
    NotificationEntity notificationEntity = null;

    try {
      pm = PMF.get().getPersistenceManager();
      pm.currentTransaction().begin();
      Query query =
          pm.newQuery(NotificationEntity.class, "receiverId == " + consumerId
              + " && messageId == '" + messageId + "'");
      List<NotificationEntity> notificationListEntity = (List<NotificationEntity>) query.execute();
      if (!notificationListEntity.isEmpty())
        notificationEntity = notificationListEntity.get(0);
      if (notificationEntity != null) {
        notificationEntity.setIsNotificationAcknowledged("TRUE");
        pm.currentTransaction().commit();
        return true;
      } else {
        return false;
      }


    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

  }

  @Override
  public JsonObject deleteAddress(long consumerId, long addressId) {

    ConsumerProfile consumerProfile = null;
    PersistenceManager pm = null;
    JsonObject result = null;
    Key consumerKey = null;
    Key addressKey = null;
    try {
      pm = PMF.get().getPersistenceManager();
      pm.currentTransaction().begin();
      consumerKey = KeyFactory.createKey("ConsumerProfile", consumerId);
      /*
       * addressKey= KeyFactory.createKey("ConsumerAddress", addressId); ConsumerAddress
       * consumerAddress=new ConsumerAddress(); consumerAddress.setId(addressKey);
       */
      consumerProfile = (ConsumerProfile) pm.getObjectById(ConsumerProfile.class, consumerKey);
      addressKey = consumerProfile.getId().getChild("ConsumerAddress", addressId);
      ConsumerAddress consumerAddress = pm.getObjectById(ConsumerAddress.class, addressKey);
      pm.deletePersistent(consumerAddress);

      pm.currentTransaction().commit();
      result = new JsonObject();


      result.addProperty("status", "success");

    } catch (Exception e) {
      result = new JsonObject();
      result.addProperty("status", "error");
      e.printStackTrace();
    } finally {
      if (pm.currentTransaction().isActive()) {
        pm.currentTransaction().rollback();
      }

    }


    return result;
  }

  @Override
  public JsonObject changeDefaultAddress(long consumerId, long addressId) {
    try {

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public JsonObject saveReferralDetails(UserReferralEntity userReferralEntity) {


    JsonObject jsonObject = null;
    try {
      jsonObject = new JsonObject();
      PersistenceManager pm = PMF.get().getPersistenceManager();
      userReferralEntity = pm.makePersistent(userReferralEntity);
      jsonObject.addProperty("refferer_server_key", userReferralEntity.getId().getId());
      jsonObject.addProperty("status", "success");
    } catch (Exception e) {
      jsonObject.addProperty("status", "error");
      e.printStackTrace();
    }

    return jsonObject;


  }

  @Override
  public String updateUserRefferalCode(long refferalCode, long benificaryId, String status) {
    PersistenceManager pm = null;
    UserReferralEntity userRefferalEntity = null;

    try {
      pm = PMF.get().getPersistenceManager();
      pm.currentTransaction().begin();
      Query query = pm.newQuery(UserReferralEntity.class, "referralCode == " + refferalCode + "");
      List<UserReferralEntity> notificationListEntity = (List<UserReferralEntity>) query.execute();

      if (!notificationListEntity.isEmpty()) {
        Collections.sort(notificationListEntity, Collections.reverseOrder());
        userRefferalEntity = notificationListEntity.get(0);
      }

      if (userRefferalEntity != null) {
        userRefferalEntity.setStatus(status);
        userRefferalEntity.setBenificaryId(benificaryId);
        pm.currentTransaction().commit();
        return "HOLDREFERENCE";
      } else {
        return "UNHOLDREFERENCE";
      }


    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }

  }

  /*
   * @Override public String findUserLatestFcmId(long consumerId) { // TODO Auto-generated method
   * stub return null; }
   */

  @SuppressWarnings("unchecked")
  @Override
  public String findUserLatestFcmId(long consumerId) {
    PersistenceManager pm = null;
    String fcmId = "";
    List<ConsumerFCMInfoEntity> consumerFcmEntityLst = null;
    Query query = null;
    try {
      pm = PMF.get().getPersistenceManager();

      query = pm.newQuery(ConsumerFCMInfoEntity.class, "consumerId==" + consumerId + "");
      query.setOrdering("consumerLastLoginDate desc");
      // query.set
      consumerFcmEntityLst = (List<ConsumerFCMInfoEntity>) query.execute();
      System.out.println("======>>>>" + consumerFcmEntityLst.size());
      // orderInfoEntityList.size();
      if (consumerFcmEntityLst != null && !consumerFcmEntityLst.isEmpty()) {
        fcmId = consumerFcmEntityLst.get(0).getFcmRegistrationId();
      }
    } catch (Exception e) {

      e.printStackTrace();
    } finally {
      pm.close();
    }

    return fcmId;
  }

  @Override
  public String updateConsumerIdInFcm(long consumerId, String phoneKey) {
    PersistenceManager pm = null;
    ConsumerFCMInfoEntity consumerFCMInfoEntity = null;

    try {
      pm = PMF.get().getPersistenceManager();
      pm.currentTransaction().begin();
      Query query =
          pm.newQuery(ConsumerFCMInfoEntity.class, "phoneUniqueKey == '" + phoneKey + "'");
      query.setOrdering("consumerLastLoginDate desc");
      List<ConsumerFCMInfoEntity> consumerFcmlist = (List<ConsumerFCMInfoEntity>) query.execute();
      if (!consumerFcmlist.isEmpty())
        consumerFCMInfoEntity = consumerFcmlist.get(0);
      if (consumerFCMInfoEntity != null) {
        consumerFCMInfoEntity.setConsumerId(consumerId);
        pm.currentTransaction().commit();

      } else {

      }


    } catch (Exception e) {
      e.printStackTrace();
      // return consumerFCMInfoEntity.getFcmRegistrationId();
    }
    return consumerFCMInfoEntity.getFcmRegistrationId();
  }

  @Override
  public String updateConsumerImage(long consumerId, String consumerImgUrl, String blobKey) {
    PersistenceManager pm = null;
    ConsumerProfile consumerProfile = null;
    String result = "success";
    try {
      pm = PMF.get().getPersistenceManager();
      pm.currentTransaction().begin();
      consumerProfile = new ConsumerProfile();
      consumerProfile.setId(KeyFactory.createKey("ConsumerProfile", consumerId));
      consumerProfile = (ConsumerProfile) pm.getObjectById(ConsumerProfile.class, consumerId);

      if (consumerProfile != null) {
        consumerProfile.setConsumerProfileImageBlobUrl(consumerImgUrl);
        consumerProfile.setConsumerProfileImageBlobKey(blobKey);
        pm.currentTransaction().commit();

      } else {

      }


    } catch (Exception e) {
      result = "failure" + e.getLocalizedMessage() + "_" + consumerId;
      e.printStackTrace();
      // return consumerFCMInfoEntity.getFcmRegistrationId();
    }
    return result;
  }

  @Override
  public String saveUserLocaion(LocationInfoEntity locationInfoEntity) {
    PersistenceManager pm = null;
    String status="";
    try {
      pm = PMF.get().getPersistenceManager();
      pm.makePersistent(locationInfoEntity);
      status="success";
    } catch (Exception e) {
      status="failure";
      e.printStackTrace();
    } finally {
      pm.close();
    }

    return status;

  }

}
