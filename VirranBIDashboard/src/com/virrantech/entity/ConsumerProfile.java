package com.virrantech.entity;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")

@Entity
public class ConsumerProfile {
  
/*  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Key id;*/
 
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key  id;
  @Persistent
  private Long consumerProfileId;
  @Persistent
  private String consumerName;
  @Persistent
  private String consumerFirstName;
  @Persistent
  private String consumerLastName;
  @Persistent
  private String consumerDOB;
  @Persistent
  private String consumerPhoneNumber;
  @Persistent
  private String consumerEmailId;
  @Persistent
  private String consumerPassword;
  @Persistent
  private String consumerRegistredDate;
  @Persistent
  private String consumerDeviceName;
  @Persistent
  private String consumerDeviceId;
  @Persistent
  private String consumerDeviceNotificationId;
  @Persistent
  private String deviceSuperInfo;
  @Persistent
  private String consumerGender;
  @Persistent
  private String consumerProfileLastUpdate ;
  @Persistent
  private String consumerProfileImageBlobUrl;
  @Persistent
  private long defaultDistributorId;
  @Persistent
  private String consumerDeviceModel;
  @Persistent
  private String consumerProfileImageBlobKey;
  @Persistent(mappedBy = "consumerProfile",defaultFetchGroup="true",loadFetchGroup="true")
  @OneToMany(mappedBy = "consumerProfile", fetch=FetchType.EAGER, orphanRemoval=true)
  @Element(dependent = "true")
  //private ConsumerAddress consumerAddress;
  private List<ConsumerAddress> consumerAddressList = new ArrayList<ConsumerAddress>();

  
 
  /**
   * @return the consumerProfileId
   */
  public Long getConsumerProfileId() {
    return consumerProfileId;
  }
  /**
   * @param consumerProfileId the consumerProfileId to set
   */
  public void setConsumerProfileId(Long consumerProfileId) {
    this.consumerProfileId = consumerProfileId;
  }
  /**
   * @return the consumerName
   */
  public String getConsumerName() {
    return consumerName;
  }
  /**
   * @param consumerName the consumerName to set
   */
  public void setConsumerName(String consumerName) {
    this.consumerName = consumerName;
  }
  /**
   * @return the consumerFirstName
   */
  public String getConsumerFirstName() {
    return consumerFirstName;
  }
  /**
   * @param consumerFirstName the consumerFirstName to set
   */
  public void setConsumerFirstName(String consumerFirstName) {
    this.consumerFirstName = consumerFirstName;
  }
  /**
   * @return the consumerLastName
   */
  public String getConsumerLastName() {
    return consumerLastName;
  }
  /**
   * @param consumerLastName the consumerLastName to set
   */
  public void setConsumerLastName(String consumerLastName) {
    this.consumerLastName = consumerLastName;
  }
  /**
   * @return the consumerDOB
   */
  public String getConsumerDOB() {
    return consumerDOB;
  }
  /**
   * @param consumerDOB the consumerDOB to set
   */
  public void setConsumerDOB(String consumerDOB) {
    this.consumerDOB = consumerDOB;
  }
  /**
   * @return the consumerPhoneNumber
   */
  public String getConsumerPhoneNumber() {
    return consumerPhoneNumber;
  }
  /**
   * @param consumerPhoneNumber the consumerPhoneNumber to set
   */
  public void setConsumerPhoneNumber(String consumerPhoneNumber) {
    this.consumerPhoneNumber = consumerPhoneNumber;
  }
  /**
   * @return the consumerEmailId
   */
  public String getConsumerEmailId() {
    return consumerEmailId;
  }
  /**
   * @param consumerEmailId the consumerEmailId to set
   */
  public void setConsumerEmailId(String consumerEmailId) {
    this.consumerEmailId = consumerEmailId;
  }
  /**
   * @return the consumerPassword
   */
  public String getConsumerPassword() {
    return consumerPassword;
  }
  /**
   * @param consumerPassword the consumerPassword to set
   */
  public void setConsumerPassword(String consumerPassword) {
    this.consumerPassword = consumerPassword;
  }
  /**
   * @return the consumerRegistredDate
   */
  public String getConsumerRegistredDate() {
    return consumerRegistredDate;
  }
  /**
   * @param consumerRegistredDate the consumerRegistredDate to set
   */
  public void setConsumerRegistredDate(String consumerRegistredDate) {
    this.consumerRegistredDate = consumerRegistredDate;
  }
  /**
   * @return the consumerDeviceName
   */
  public String getConsumerDeviceName() {
    return consumerDeviceName;
  }
  /**
   * @param consumerDeviceName the consumerDeviceName to set
   */
  public void setConsumerDeviceName(String consumerDeviceName) {
    this.consumerDeviceName = consumerDeviceName;
  }
  /**
   * @return the consumerDeviceId
   */
  public String getConsumerDeviceId() {
    return consumerDeviceId;
  }
  /**
   * @param consumerDeviceId the consumerDeviceId to set
   */
  public void setConsumerDeviceId(String consumerDeviceId) {
    this.consumerDeviceId = consumerDeviceId;
  }
  /**
   * @return the consumerDeviceModel
   */
  public String getConsumerDeviceModel() {
    return consumerDeviceModel;
  }
  /**
   * @param consumerDeviceModel the consumerDeviceModel to set
   */
  public void setConsumerDeviceModel(String consumerDeviceModel) {
    this.consumerDeviceModel = consumerDeviceModel;
  }
  
  /**
   * @return the id
   */
 /* public Key getId() {
    return id;
  }
  *//**
   * @param id the id to set
   *//*
  public void setId(Key id) {
    this.id = id;
  }
  *//**
   * @return the consumerId
   */
 
  /**
   * @return the consumerAddressList
   */
  public List<ConsumerAddress> getConsumerAddressList() {
    return consumerAddressList;
  }
  /**
   * @param consumerAddressList the consumerAddressList to set
   */
  public void setConsumerAddressList(List<ConsumerAddress> consumerAddressList) {
    this.consumerAddressList = consumerAddressList;
  }
  /**
   * @return the id
   */
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
   * @return the consumerDeviceNotificationId
   */
  public String getConsumerDeviceNotificationId() {
    return consumerDeviceNotificationId;
  }
  /**
   * @param consumerDeviceNotificationId the consumerDeviceNotificationId to set
   */
  public void setConsumerDeviceNotificationId(String consumerDeviceNotificationId) {
    this.consumerDeviceNotificationId = consumerDeviceNotificationId;
  }
  /**
   * @return the consumerProfileImageBlobUrl
   */
  public String getConsumerProfileImageBlobUrl() {
    return consumerProfileImageBlobUrl;
  }
  /**
   * @param consumerProfileImageBlobUrl the consumerProfileImageBlobUrl to set
   */
  public void setConsumerProfileImageBlobUrl(String consumerProfileImageBlobUrl) {
    this.consumerProfileImageBlobUrl = consumerProfileImageBlobUrl;
  }
  /**
   * @return the deviceSuperInfo
   */
  public String getDeviceSuperInfo() {
    return deviceSuperInfo;
  }
  /**
   * @param deviceSuperInfo the deviceSuperInfo to set
   */
  public void setDeviceSuperInfo(String deviceSuperInfo) {
    this.deviceSuperInfo = deviceSuperInfo;
  }
  /**
   * @return the consumerGender
   */
  public String getConsumerGender() {
    return consumerGender;
  }
  /**
   * @param consumerGender the consumerGender to set
   */
  public void setConsumerGender(String consumerGender) {
    this.consumerGender = consumerGender;
  }
  /**
   * @return the consumerProfileLastUpdate
   */
  public String getConsumerProfileLastUpdate() {
    return consumerProfileLastUpdate;
  }
  /**
   * @param consumerProfileLastUpdate the consumerProfileLastUpdate to set
   */
  public void setConsumerProfileLastUpdate(String consumerProfileLastUpdate) {
    this.consumerProfileLastUpdate = consumerProfileLastUpdate;
  }
  /**
   * @return the defaultDistributorId
   */
  public long getDefaultDistributorId() {
    return defaultDistributorId;
  }
  /**
   * @param defaultDistributorId the defaultDistributorId to set
   */
  public void setDefaultDistributorId(long defaultDistributorId) {
    this.defaultDistributorId = defaultDistributorId;
  }
  /**
   * @return the consumerProfileImageBlobKey
   */
  public String getConsumerProfileImageBlobKey() {
    return consumerProfileImageBlobKey;
  }
  /**
   * @param consumerProfileImageBlobKey the consumerProfileImageBlobKey to set
   */
  public void setConsumerProfileImageBlobKey(String consumerProfileImageBlobKey) {
    this.consumerProfileImageBlobKey = consumerProfileImageBlobKey;
  }
 
  
  
  

}
