package com.virrantech.entity;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
@Entity
public class ConsumerFCMInfoEntity implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key id;
  @Persistent
  private String fcmRegistrationId;
  @Persistent
  private String phoneUniqueKey;
  @Persistent
  private String fcmRegistrationDateTime;
  @Persistent
  private Date consumerLastLoginDate;
  @Persistent
  private long consumerId;
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
   * @return the fcmRegistrationId
   */
  public String getFcmRegistrationId() {
    return fcmRegistrationId;
  }
  /**
   * @param fcmRegistrationId the fcmRegistrationId to set
   */
  public void setFcmRegistrationId(String fcmRegistrationId) {
    this.fcmRegistrationId = fcmRegistrationId;
  }
  /**
   * @return the phoneUniqueKey
   */
  public String getPhoneUniqueKey() {
    return phoneUniqueKey;
  }
  /**
   * @param phoneUniqueKey the phoneUniqueKey to set
   */
  public void setPhoneUniqueKey(String phoneUniqueKey) {
    this.phoneUniqueKey = phoneUniqueKey;
  }
  /**
   * @return the fcmRegistrationDateTime
   */
  public String getFcmRegistrationDateTime() {
    return fcmRegistrationDateTime;
  }
  /**
   * @param fcmRegistrationDateTime the fcmRegistrationDateTime to set
   */
  public void setFcmRegistrationDateTime(String fcmRegistrationDateTime) {
    this.fcmRegistrationDateTime = fcmRegistrationDateTime;
  }
  /**
   * @return the consumerId
   */
  public long getConsumerId() {
    return consumerId;
  }
  /**
   * @param consumerId the consumerId to set
   */
  public void setConsumerId(long consumerId) {
    this.consumerId = consumerId;
  }
  /**
   * @return the consumerLastLoginDate
   */
  public Date getConsumerLastLoginDate() {
    return consumerLastLoginDate;
  }
  /**
   * @param consumerLastLoginDate the consumerLastLoginDate to set
   */
  public void setConsumerLastLoginDate(Date consumerLastLoginDate) {
    this.consumerLastLoginDate = consumerLastLoginDate;
  }

}
