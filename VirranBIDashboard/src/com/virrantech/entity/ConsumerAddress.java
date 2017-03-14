package com.virrantech.entity;

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
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
@Entity
public class ConsumerAddress 
 {
 
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key id;
  @Persistent
  private String consumerKey;
  @Persistent
  private String addressHeader;
  @Persistent
  private String consumerFullName;
  @Persistent
  private String consumerHouseNo;
  @Persistent
  private String livingType;//("APARTMENT","OFFICE","HOTEL","HOME")
  @Persistent
  private String addressAsJson;
  @Persistent
  private Long consumerProfileId;
  @Persistent
  private String consumerLocLat;
  @Persistent
  private String consumerLocLang;
  @Persistent
  private String consumerStreetName;
  @Persistent
  private String consumerAreaName;
  @Persistent
  private String consumerCity;
  @Persistent
  private String defaultAddress;
  @Persistent
  private String contactNumber;
  @Persistent
  private String locationName;
  @Persistent
  private String district;
  @Persistent
  private String postalCode;
  @Persistent
  private String state;
  @Persistent
  private String countryCode;
  @Persistent
  private String subArea;
  @Persistent
  private String premises;
  
  @Persistent
  private String doorNumber;
  @Persistent
  private String apartmentName;
  @Persistent
  private String apartmentFloor;
  @Persistent
  private String officeName;
  @Persistent
  private String officeFloor;
  @Persistent
  private String hotelName;
  @Persistent
  @ManyToOne(fetch = FetchType.LAZY)
  private ConsumerProfile consumerProfile;
  

  /*
  JsonObject addresobj=new JsonObject();
  
  addresobj.addProperty("delivery_type", "APARTMENT");
  addresobj.addProperty("apartment_name", "");
  addresobj.addProperty("apartment_floor", "");
  addresobj.addProperty("street_name", "");
  
  addresobj.addProperty("delivery_type", "OFFICE");
  addresobj.addProperty("office_name", "");
  addresobj.addProperty("office_floor", "");
  addresobj.addProperty("street_name", "");
  
  addresobj.addProperty("delivery_type", "HOTEL");
  addresobj.addProperty("hotel_name", "");
  addresobj.addProperty("street_name", "");
  
  addresobj.addProperty("delivery_type", "HOME");
  addresobj.addProperty("door_number", "");
  addresobj.addProperty("street_name", "");*/
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
   * @return the consumerKey
   */
  public String getConsumerKey() {
    return consumerKey;
  }
  /**
   * @param consumerKey the consumerKey to set
   */
  public void setConsumerKey(String consumerKey) {
    this.consumerKey = consumerKey;
  }
  /**
   * @return the addressHeader
   */
  public String getAddressHeader() {
    return addressHeader;
  }
  /**
   * @param addressHeader the addressHeader to set
   */
  public void setAddressHeader(String addressHeader) {
    this.addressHeader = addressHeader;
  }
  /**
   * @return the consumerFullName
   */
  public String getConsumerFullName() {
    return consumerFullName;
  }
  /**
   * @param consumerFullName the consumerFullName to set
   */
  public void setConsumerFullName(String consumerFullName) {
    this.consumerFullName = consumerFullName;
  }
  /**
   * @return the consumerHouseNo
   */
  public String getConsumerHouseNo() {
    return consumerHouseNo;
  }
  /**
   * @param consumerHouseNo the consumerHouseNo to set
   */
  public void setConsumerHouseNo(String consumerHouseNo) {
    this.consumerHouseNo = consumerHouseNo;
  }
  /**
   * @return the livingType
   */
  public String getLivingType() {
    return livingType;
  }
  /**
   * @param livingType the livingType to set
   */
  public void setLivingType(String livingType) {
    this.livingType = livingType;
  }
  /**
   * @return the addressAsJson
   */
  public String getAddressAsJson() {
    return addressAsJson;
  }
  /**
   * @param addressAsJson the addressAsJson to set
   */
  public void setAddressAsJson(String addressAsJson) {
    this.addressAsJson = addressAsJson;
  }
  /**
   * @return the consumerLocLat
   */
  public String getConsumerLocLat() {
    return consumerLocLat;
  }
  /**
   * @param consumerLocLat the consumerLocLat to set
   */
  public void setConsumerLocLat(String consumerLocLat) {
    this.consumerLocLat = consumerLocLat;
  }
  /**
   * @return the consumerLocLang
   */
  public String getConsumerLocLang() {
    return consumerLocLang;
  }
  /**
   * @param consumerLocLang the consumerLocLang to set
   */
  public void setConsumerLocLang(String consumerLocLang) {
    this.consumerLocLang = consumerLocLang;
  }
  /**
   * @return the consumerStreetName
   */
  public String getConsumerStreetName() {
    return consumerStreetName;
  }
  /**
   * @param consumerStreetName the consumerStreetName to set
   */
  public void setConsumerStreetName(String consumerStreetName) {
    this.consumerStreetName = consumerStreetName;
  }
  /**
   * @return the consumerAreaName
   */
  public String getConsumerAreaName() {
    return consumerAreaName;
  }
  /**
   * @param consumerAreaName the consumerAreaName to set
   */
  public void setConsumerAreaName(String consumerAreaName) {
    this.consumerAreaName = consumerAreaName;
  }
  /**
   * @return the consumerCity
   */
  public String getConsumerCity() {
    return consumerCity;
  }
  /**
   * @param consumerCity the consumerCity to set
   */
  public void setConsumerCity(String consumerCity) {
    this.consumerCity = consumerCity;
  }
  /**
   * @return the consumerProfile
   */
  public ConsumerProfile getConsumerProfile() {
    return consumerProfile;
  }
  /**
   * @param consumerProfile the consumerProfile to set
   */
  public void setConsumerProfile(ConsumerProfile consumerProfile) {
    this.consumerProfile = consumerProfile;
  }
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
   * @return the defaultAddress
   */
  public String getDefaultAddress() {
    return defaultAddress;
  }
  /**
   * @param defaultAddress the defaultAddress to set
   */
  public void setDefaultAddress(String defaultAddress) {
    this.defaultAddress = defaultAddress;
  }
  /**
   * @return the contactNumber
   */
  public String getContactNumber() {
    return contactNumber;
  }
  /**
   * @param contactNumber the contactNumber to set
   */
  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }
  /**
   * @return the locationName
   */
  public String getLocationName() {
    return locationName;
  }
  /**
   * @param locationName the locationName to set
   */
  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }
  /**
   * @return the district
   */
  public String getDistrict() {
    return district;
  }
  /**
   * @param district the district to set
   */
  public void setDistrict(String district) {
    this.district = district;
  }
  /**
   * @return the postalCode
   */
  public String getPostalCode() {
    return postalCode;
  }
  /**
   * @param postalCode the postalCode to set
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }
  /**
   * @return the state
   */
  public String getState() {
    return state;
  }
  /**
   * @param state the state to set
   */
  public void setState(String state) {
    this.state = state;
  }
 
  
  
 
}
