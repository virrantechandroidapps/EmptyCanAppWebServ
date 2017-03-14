package com.virrantech.entity;

import java.io.Serializable;

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
public class ShopInfo implements Serializable {

  private static final long serialVersionUID = 1L;
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key id;
  @Persistent
  private int shopId;
  @Persistent
  private String shopName;
  @Persistent
  private String shopUserName;
  @Persistent
  private String shopOfficialRegNo;
  @Persistent
  private String shopStreetName;
  @Persistent
  private String shopDoorNumber;
  @Persistent
  private String shopAreaName;
  @Persistent
  private String shopLocation;
  @Persistent
  private String shopLat;
  @Persistent
  private String shopLang;
  @Persistent
  private String shopEmailId;
  @Persistent
  private String shopPhoneNumber1;
  @Persistent
  private String shopPhoneNumber2;
  @Persistent
  private String shopPhoneNumber3;
  @Persistent 
  private String shopImage;
  @Persistent
  private String shopLogo;
  @Persistent
  private String shopUserPasswrd;
  @Persistent
  private String shopType;//("PROVISIONAL,MEDICAL,WATERCAN")
  @Persistent 
  private String shopRegistrationDate;
   
  
  
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
   * @return the shopId
   */
  public int getShopId() {
    return shopId;
  }
  /**
   * @param shopId the shopId to set
   */
  public void setShopId(int shopId) {
    this.shopId = shopId;
  }
  /**
   * @return the shopName
   */
  public String getShopName() {
    return shopName;
  }
  /**
   * @param shopName the shopName to set
   */
  public void setShopName(String shopName) {
    this.shopName = shopName;
  }
  /**
   * @return the shopOwnerName
   */
  public String getShopOwnerName() {
    return shopUserName;
  }
  /**
   * @param shopOwnerName the shopOwnerName to set
   */
  public void setShopOwnerName(String shopUserName) {
    this.shopUserName = shopUserName;
  }
 
  /**
   * @return the shopStreetName
   */
  public String getShopStreetName() {
    return shopStreetName;
  }
  /**
   * @param shopStreetName the shopStreetName to set
   */
  public void setShopStreetName(String shopStreetName) {
    this.shopStreetName = shopStreetName;
  }
  /**
   * @return the shopDoorNumber
   */
  public String getShopDoorNumber() {
    return shopDoorNumber;
  }
  /**
   * @param shopDoorNumber the shopDoorNumber to set
   */
  public void setShopDoorNumber(String shopDoorNumber) {
    this.shopDoorNumber = shopDoorNumber;
  }
  /**
   * @return the shopAreaName
   */
  public String getShopAreaName() {
    return shopAreaName;
  }
  /**
   * @param shopAreaName the shopAreaName to set
   */
  public void setShopAreaName(String shopAreaName) {
    this.shopAreaName = shopAreaName;
  }
  /**
   * @return the shopLocation
   */
  public String getShopLocation() {
    return shopLocation;
  }
  /**
   * @param shopLocation the shopLocation to set
   */
  public void setShopLocation(String shopLocation) {
    this.shopLocation = shopLocation;
  }
  /**
   * @return the shopLat
   */
  public String getShopLat() {
    return shopLat;
  }
  /**
   * @param shopLat the shopLat to set
   */
  public void setShopLat(String shopLat) {
    this.shopLat = shopLat;
  }
  /**
   * @return the shopLang
   */
  public String getShopLang() {
    return shopLang;
  }
  /**
   * @param shopLang the shopLang to set
   */
  public void setShopLang(String shopLang) {
    this.shopLang = shopLang;
  }
  /**
   * @return the shopEmailId
   */
  public String getShopEmailId() {
    return shopEmailId;
  }
  /**
   * @param shopEmailId the shopEmailId to set
   */
  public void setShopEmailId(String shopEmailId) {
    this.shopEmailId = shopEmailId;
  }
  /**
   * @return the shopPhoneNumber1
   */
  public String getShopPhoneNumber1() {
    return shopPhoneNumber1;
  }
  /**
   * @param shopPhoneNumber1 the shopPhoneNumber1 to set
   */
  public void setShopPhoneNumber1(String shopPhoneNumber1) {
    this.shopPhoneNumber1 = shopPhoneNumber1;
  }
  /**
   * @return the shopPhoneNumber2
   */
  public String getShopPhoneNumber2() {
    return shopPhoneNumber2;
  }
  /**
   * @param shopPhoneNumber2 the shopPhoneNumber2 to set
   */
  public void setShopPhoneNumber2(String shopPhoneNumber2) {
    this.shopPhoneNumber2 = shopPhoneNumber2;
  }
  /**
   * @return the shopPhoneNumber3
   */
  public String getShopPhoneNumber3() {
    return shopPhoneNumber3;
  }
  /**
   * @param shopPhoneNumber3 the shopPhoneNumber3 to set
   */
  public void setShopPhoneNumber3(String shopPhoneNumber3) {
    this.shopPhoneNumber3 = shopPhoneNumber3;
  }
  /**
   * @return the shopOfficialRegNo
   */
  public String getShopOfficialRegNo() {
    return shopOfficialRegNo;
  }
  /**
   * @param shopOfficialRegNo the shopOfficialRegNo to set
   */
  public void setShopOfficialRegNo(String shopOfficialRegNo) {
    this.shopOfficialRegNo = shopOfficialRegNo;
  }
  /**
   * @return the shopUserPasswrd
   */
  public String getShopUserPasswrd() {
    return shopUserPasswrd;
  }
  /**
   * @param shopUserPasswrd the shopUserPasswrd to set
   */
  public void setShopUserPasswrd(String shopUserPasswrd) {
    this.shopUserPasswrd = shopUserPasswrd;
  }
  /**
   * @return the shopUserName
   */
  public String getShopUserName() {
    return shopUserName;
  }
  /**
   * @param shopUserName the shopUserName to set
   */
  public void setShopUserName(String shopUserName) {
    this.shopUserName = shopUserName;
  }
  /**
   * @return the shopImage
   */
  public String getShopImage() {
    return shopImage;
  }
  /**
   * @param shopImage the shopImage to set
   */
  public void setShopImage(String shopImage) {
    this.shopImage = shopImage;
  }
  /**
   * @return the shopLogo
   */
  public String getShopLogo() {
    return shopLogo;
  }
  /**
   * @param shopLogo the shopLogo to set
   */
  public void setShopLogo(String shopLogo) {
    this.shopLogo = shopLogo;
  }
  /**
   * @return the shopType
   */
  public String getShopType() {
    return shopType;
  }
  /**
   * @param shopType the shopType to set
   */
  public void setShopType(String shopType) {
    this.shopType = shopType;
  }
  /**
   * @return the shopRegistrationDate
   */
  public String getShopRegistrationDate() {
    return shopRegistrationDate;
  }
  /**
   * @param shopRegistrationDate the shopRegistrationDate to set
   */
  public void setShopRegistrationDate(String shopRegistrationDate) {
    this.shopRegistrationDate = shopRegistrationDate;
  }
  
}
