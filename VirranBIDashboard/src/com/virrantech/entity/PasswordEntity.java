package com.virrantech.entity;

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
public class PasswordEntity {
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key id;
  @Persistent
  private Long changePswrdId;
  @Persistent
  private String userPassword;
  @Persistent
  private Long userId;
  @Persistent
  private String pswrdLastUpdatedDate;
  
  private String currentPassword;
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
   * @return the changePswrdId
   */
  public Long getChangePswrdId() {
    return changePswrdId;
  }
  /**
   * @param changePswrdId the changePswrdId to set
   */
  public void setChangePswrdId(Long changePswrdId) {
    this.changePswrdId = changePswrdId;
  }
  /**
   * @return the userPassword
   */
  public String getUserPassword() {
    return userPassword;
  }
  /**
   * @param userPassword the userPassword to set
   */
  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }
  /**
   * @return the userId
   */
  public Long getUserId() {
    return userId;
  }
  /**
   * @param userId the userId to set
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }
  /**
   * @return the pswrdLastUpdatedDate
   */
  public String getPswrdLastUpdatedDate() {
    return pswrdLastUpdatedDate;
  }
  /**
   * @param pswrdLastUpdatedDate the pswrdLastUpdatedDate to set
   */
  public void setPswrdLastUpdatedDate(String pswrdLastUpdatedDate) {
    this.pswrdLastUpdatedDate = pswrdLastUpdatedDate;
  }
  /**
   * @return the currentPassword
   */
  public String getCurrentPassword() {
    return currentPassword;
  }
  /**
   * @param currentPassword the currentPassword to set
   */
  public void setCurrentPassword(String currentPassword) {
    this.currentPassword = currentPassword;
  }
  
}
