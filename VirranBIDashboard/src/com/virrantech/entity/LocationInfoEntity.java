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
public class LocationInfoEntity implements Serializable {
  private static final long serialVersionUID = 1L;
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key id;
  @Persistent
  private String locLat;
  @Persistent
  private String locLang;
  @Persistent
  private long userId;
  @Persistent
  private Date curentDateTime;
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
   * @return the locLat
   */
  public String getLocLat() {
    return locLat;
  }
  /**
   * @param locLat the locLat to set
   */
  public void setLocLat(String locLat) {
    this.locLat = locLat;
  }
  /**
   * @return the locLang
   */
  public String getLocLang() {
    return locLang;
  }
  /**
   * @param locLang the locLang to set
   */
  public void setLocLang(String locLang) {
    this.locLang = locLang;
  }
  /**
   * @return the userId
   */
  public long getUserId() {
    return userId;
  }
  /**
   * @param userId the userId to set
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }
  /**
   * @return the curentDateTime
   */
  public Date getCurentDateTime() {
    return curentDateTime;
  }
  /**
   * @param curentDateTime the curentDateTime to set
   */
  public void setCurentDateTime(Date curentDateTime) {
    this.curentDateTime = curentDateTime;
  }
  /**
   * @return the serialversionuid
   */
  public static long getSerialversionuid() {
    return serialVersionUID;
  }
  
}
