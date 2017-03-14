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
public class UserReferralEntity implements Serializable , Comparable<UserReferralEntity> {
  
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key id;
  @Persistent
  private long refererId;
  @Persistent
  private long benificaryId;
  @Persistent
  private long referralCode;
  @Persistent
  private String referralDoneDate;
  @Persistent
  private Date  referralISTDoneDate;
  @Persistent
  private String refererName;
  @Persistent
  private String status;//PENDING,DOWNLOADED,BOOKED
  @Persistent
  private String redeemStatus;//TOBEREEDEM,REDEEMED,
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
   * @return the refererId
   */
  public long getRefererId() {
    return refererId;
  }
  /**
   * @param refererId the refererId to set
   */
  public void setRefererId(long refererId) {
    this.refererId = refererId;
  }
  /**
   * @return the referralCode
   */
  public long getReferralCode() {
    return referralCode;
  }
  /**
   * @param referralCode the referralCode to set
   */
  public void setReferralCode(long referralCode) {
    this.referralCode = referralCode;
  }
  /**
   * @return the referralDoneDate
   */
  public String getReferralDoneDate() {
    return referralDoneDate;
  }
  /**
   * @param referralDoneDate the referralDoneDate to set
   */
  public void setReferralDoneDate(String referralDoneDate) {
    this.referralDoneDate = referralDoneDate;
  }
  /**
   * @return the referralISTDoneDate
   */
  public Date getReferralISTDoneDate() {
    return referralISTDoneDate;
  }
  /**
   * @param referralISTDoneDate the referralISTDoneDate to set
   */
  public void setReferralISTDoneDate(Date referralISTDoneDate) {
    this.referralISTDoneDate = referralISTDoneDate;
  }
  /**
   * @return the refererName
   */
  public String getRefererName() {
    return refererName;
  }
  /**
   * @param refererName the refererName to set
   */
  public void setRefererName(String refererName) {
    this.refererName = refererName;
  }
  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }
  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }
  @Override
  public int compareTo(UserReferralEntity o) {
    // TODO Auto-generated method stub
    
    return  getReferralISTDoneDate().compareTo(o.getReferralISTDoneDate());
  }
  /**
   * @return the benificaryId
   */
  public long getBenificaryId() {
    return benificaryId;
  }
  /**
   * @param benificaryId the benificaryId to set
   */
  public void setBenificaryId(long benificaryId) {
    this.benificaryId = benificaryId;
  }
  /**
   * @return the redeemStatus
   */
  public String getRedeemStatus() {
    return redeemStatus;
  }
  /**
   * @param redeemStatus the redeemStatus to set
   */
  public void setRedeemStatus(String redeemStatus) {
    this.redeemStatus = redeemStatus;
  }

}
