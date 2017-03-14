package com.virrantech.entity;


import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@Entity
public class NotificationEntity implements Serializable {
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key  id;
  @Persistent
  private String senderFCMKey;
  @Persistent
  private String receiverFCMKey;
  @Persistent
  private long receiverId;
  @Persistent
  private long notificationKeyId;
  @Persistent
  private long senderId;
  @Persistent
  private JSONObject notificationPayLoad;
  @Persistent
  private JSONObject  dataPayLoad;
  @Persistent
  private String  dataPayLoadString;
  @Persistent 
  private String notificationSentDateTime;
  @Persistent 
  private String notificationType;
  @Persistent 
  private String notificationImageUrl;
  @Persistent 
  private String notificationReadStatus;
  @Persistent 
  private String title;
  @Persistent 
  private String body;
  @Persistent 
  private String message;
  @Persistent 
  private String clickAction;
  @Persistent 
  private String notificationIcon;
  @Persistent 
  private String notificationSound;
  @Persistent 
  private String notificationNetwrkStatus;
  @Persistent
  private String messageId;
  @Persistent
  private String isNotificationAcknowledged="NO";
  public NotificationEntity(){
    try{
      notificationPayLoad=new JSONObject();
      notificationPayLoad.put("title", "");
      notificationPayLoad.put("body", "");
      notificationPayLoad.put("click_action", "NOTIFICATION_BOOTH");
      dataPayLoad=new JSONObject();
    }catch(Exception e){
      
    }
  
  }
  /**
   * @return the id
   */
  public Key getId() {
    return id;
  }
  /**
   * @param id the id to set
   */
  public void setId(Key id) {
    this.id = id;
  }
  /**
   * @return the senderFCMKey
   */
  public String getSenderFCMKey() {
    return senderFCMKey;
  }
  /**
   * @param senderFCMKey the senderFCMKey to set
   */
  public void setSenderFCMKey(String senderFCMKey) {
    this.senderFCMKey = senderFCMKey;
  }
  /**
   * @return the receiverFCMKey
   */
  public String getReceiverFCMKey() {
    return receiverFCMKey;
  }
  /**
   * @param receiverFCMKey the receiverFCMKey to set
   */
  public void setReceiverFCMKey(String receiverFCMKey) {
    this.receiverFCMKey = receiverFCMKey;
  }
  /**
   * @return the receiverId
   */
  public long getReceiverId() {
    return receiverId;
  }
  /**
   * @param receiverId the receiverId to set
   */
  public void setReceiverId(long receiverId) {
    this.receiverId = receiverId;
  }
  /**
   * @return the notificationKeyId
   */
  public long getNotificationKeyId() {
    return notificationKeyId;
  }
  /**
   * @param notificationKeyId the notificationKeyId to set
   */
  public void setNotificationKeyId(long notificationKeyId) {
    this.notificationKeyId = notificationKeyId;
  }
  /**
   * @return the senderId
   */
  public long getSenderId() {
    return senderId;
  }
  /**
   * @param senderId the senderId to set
   */
  public void setSenderId(long senderId) {
    this.senderId = senderId;
  }
  /**
   * @return the notificationPayLoad
   */
  public JSONObject getNotificationPayLoad() {
    return notificationPayLoad;
  }
  /**
   * @param notificationPayLoad the notificationPayLoad to set
   */
  public void setNotificationPayLoad(JSONObject notificationPayLoad) {
    this.notificationPayLoad = notificationPayLoad;
  }
  /**
   * @return the dataPayLoad
   */
  public JSONObject getDataPayLoad() {
    return dataPayLoad;
  }
  /**
   * @param dataPayLoad the dataPayLoad to set
   */
  public void setDataPayLoad(JSONObject dataPayLoad) {
    this.dataPayLoad = dataPayLoad;
  }
  /**
   * @return the dataPayLoadString
   */
  public String getDataPayLoadString() {
    return dataPayLoadString;
  }
  /**
   * @param dataPayLoadString the dataPayLoadString to set
   */
  public void setDataPayLoadString(String dataPayLoadString) {
    this.dataPayLoadString = dataPayLoadString;
  }
  /**
   * @return the notificationSentDateTime
   */
  public String getNotificationSentDateTime() {
    return notificationSentDateTime;
  }
  /**
   * @param notificationSentDateTime the notificationSentDateTime to set
   */
  public void setNotificationSentDateTime(String notificationSentDateTime) {
    this.notificationSentDateTime = notificationSentDateTime;
  }
  /**
   * @return the notificationType
   */
  public String getNotificationType() {
    return notificationType;
  }
  /**
   * @param notificationType the notificationType to set
   */
  public void setNotificationType(String notificationType) {
    this.notificationType = notificationType;
  }
  /**
   * @return the notificationImageUrl
   */
  public String getNotificationImageUrl() {
    return notificationImageUrl;
  }
  /**
   * @param notificationImageUrl the notificationImageUrl to set
   */
  public void setNotificationImageUrl(String notificationImageUrl) {
    this.notificationImageUrl = notificationImageUrl;
  }
  /**
   * @return the notificationReadStatus
   */
  public String getNotificationReadStatus() {
    return notificationReadStatus;
  }
  /**
   * @param notificationReadStatus the notificationReadStatus to set
   */
  public void setNotificationReadStatus(String notificationReadStatus) {
    this.notificationReadStatus = notificationReadStatus;
  }
  /**
   * @return the notificationNetwrkStatus
   */
  public String getNotificationNetwrkStatus() {
    return notificationNetwrkStatus;
  }
  /**
   * @param notificationNetwrkStatus the notificationNetwrkStatus to set
   */
  public void setNotificationNetwrkStatus(String notificationNetwrkStatus) {
    this.notificationNetwrkStatus = notificationNetwrkStatus;
  }
  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }
  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }
  /**
   * @return the body
   */
  public String getBody() {
    return body;
  }
  /**
   * @param body the body to set
   */
  public void setBody(String body) {
    this.body = body;
  }
  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }
  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }
  /**
   * @return the clickAction
   */
  public String getClickAction() {
    return clickAction;
  }
  /**
   * @param clickAction the clickAction to set
   */
  public void setClickAction(String clickAction) {
    this.clickAction = clickAction;
  }
  /**
   * @return the notificationIcon
   */
  public String getNotificationIcon() {
    return notificationIcon;
  }
  /**
   * @param notificationIcon the notificationIcon to set
   */
  public void setNotificationIcon(String notificationIcon) {
    this.notificationIcon = notificationIcon;
  }
  /**
   * @return the notificationSound
   */
  public String getNotificationSound() {
    return notificationSound;
  }
  /**
   * @param notificationSound the notificationSound to set
   */
  public void setNotificationSound(String notificationSound) {
    this.notificationSound = notificationSound;
  }
  /**
   * @return the messageId
   */
  public String getMessageId() {
    return messageId;
  }
  /**
   * @param messageId the messageId to set
   */
  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }
  /**
   * @return the isNotificationAcknowledged
   */
  public String getIsNotificationAcknowledged() {
    return isNotificationAcknowledged;
  }
  /**
   * @param isNotificationAcknowledged the isNotificationAcknowledged to set
   */
  public void setIsNotificationAcknowledged(String isNotificationAcknowledged) {
    this.isNotificationAcknowledged = isNotificationAcknowledged;
  }
  
 

}
