package com.virrantech.entity;



import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * Created by varadhan on 10-12-2016.
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
@Entity
public class OrderInfoEntity  {
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
  private String orderDoneDateTime;
  @Persistent
  private Date orderReceivedDateTime;
  @Persistent
  private long consumerKey;
  @Persistent
  private long orderAddressId;
  @Persistent
  private Float totalPayment;
  @Persistent
  private String paymentMode;
  @NotPersistent
  private String formattedDate;
  @Persistent
  private String orderId;
  @Persistent
  private String latitude;
  @Persistent
  private String longitude;
  @Persistent
  private String altitude;
  @Persistent
  private String accuracy;
  @Persistent
  private String bearing;
  @Persistent
  private String gpsProvider;
  @Persistent
  private String speed;
  @Persistent
  private String time;
  @Persistent
  private String describeContents;
  @Persistent
  private String orderStatus;
  @Persistent
  private Date orderStatusModifiedTime;
  @NotPersistent
  private String isFirstTimeBooking;
  @NotPersistent
  private String refStatus;
  @NotPersistent
  private String userFcmId;
  /*@Persistent(mappedBy = "orderInfoEntity", defaultFetchGroup = "true", loadFetchGroup = "true")
  @OneToMany(mappedBy = "orderInfoEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)*/
 /* @NotPersistent
  private List<CartInfoEntity> cartInfoList;*/
  @Persistent
  private long distibutorId;
  
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
   * @return the orderDoneDateTime
   */
  public String getOrderDoneDateTime() {
    return orderDoneDateTime;
  }
  /**
   * @param orderDoneDateTime the orderDoneDateTime to set
   */
  public void setOrderDoneDateTime(String orderDoneDateTime) {
    this.orderDoneDateTime = orderDoneDateTime;
  }
  /**
   * @return the consumerKey
   */
  public long getConsumerKey() {
    return consumerKey;
  }
  /**
   * @param consumerKey the consumerKey to set
   */
  public void setConsumerKey(long consumerKey) {
    this.consumerKey = consumerKey;
  }
  /**
   * @return the orderAddressId
   */
  public long getOrderAddressId() {
    return orderAddressId;
  }
  /**
   * @param orderAddressId the orderAddressId to set
   */
  public void setOrderAddressId(long orderAddressId) {
    this.orderAddressId = orderAddressId;
  }
  
  
  /**
   * @return the paymentMode
   */
  public String getPaymentMode() {
    return paymentMode;
  }
  /**
   * @param paymentMode the paymentMode to set
   */
  public void setPaymentMode(String paymentMode) {
    this.paymentMode = paymentMode;
  }
  /**
   * @return the cartInfoList
   */
 
  /*@Override
  public int compareTo(OrderInfoEntity o) {
    // TODO Auto-generated method stub
    
    return  getOrderReceivedDateTime().compareTo(o.getOrderReceivedDateTime());
  }*/
  /**
   * @return the orderReceivedDateTime
   */
  public Date getOrderReceivedDateTime() {
    return orderReceivedDateTime;
  }
  /**
   * @param orderReceivedDateTime the orderReceivedDateTime to set
   */
  public void setOrderReceivedDateTime(Date orderReceivedDateTime) {
    this.orderReceivedDateTime = orderReceivedDateTime;
  }
  /**
   * @return the formatterDate
   */
 
  /**
   * @return the orderId
   */
  public String getOrderId() {
    return orderId;
  }
  /**
   * @param orderId the orderId to set
   */
  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }
  /**
   * @return the firstTimeBooking
   */
  /**
   * @return the isFirstTimeBooking
   */
  public String getIsFirstTimeBooking() {
    return isFirstTimeBooking;
  }
  /**
   * @param isFirstTimeBooking the isFirstTimeBooking to set
   */
  public void setIsFirstTimeBooking(String isFirstTimeBooking) {
    this.isFirstTimeBooking = isFirstTimeBooking;
  }
  /**
   * @return the refStatus
   */
  public String getRefStatus() {
    return refStatus;
  }
  /**
   * @param refStatus the refStatus to set
   */
  public void setRefStatus(String refStatus) {
    this.refStatus = refStatus;
  }
  /**
   * @return the userFcmId
   */
  public String getUserFcmId() {
    return userFcmId;
  }
  /**
   * @param userFcmId the userFcmId to set
   */
  public void setUserFcmId(String userFcmId) {
    this.userFcmId = userFcmId;
  }
  /**
   * @return the formattedDate
   */
  public String getFormattedDate() {
    return formattedDate;
  }
  /**
   * @param formattedDate the formattedDate to set
   */
  public void setFormattedDate(String formattedDate) {
    this.formattedDate = formattedDate;
  }
 
  /**
   * @return the serialversionuid
   */
  public static long getSerialversionuid() {
    return serialVersionUID;
  }
  
  /**
   * @return the orderStatus
   */
  public String getOrderStatus() {
    return orderStatus;
  }
  /**
   * @param orderStatus the orderStatus to set
   */
  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }
  /**
   * @return the orderStatusModifiedTime
   */
  public Date getOrderStatusModifiedTime() {
    return orderStatusModifiedTime;
  }
  /**
   * @param orderStatusModifiedTime the orderStatusModifiedTime to set
   */
  public void setOrderStatusModifiedTime(Date orderStatusModifiedTime) {
    this.orderStatusModifiedTime = orderStatusModifiedTime;
  }
  /**
   * @param totalPayment the totalPayment to set
   */
  public void setTotalPayment(Float totalPayment) {
    this.totalPayment = totalPayment;
  }
  /**
   * @return the totalPayment
   */
  public Float getTotalPayment() {
    return totalPayment;
  }
  /**
   * @return the latitude
   */
  public String getLatitude() {
    return latitude;
  }
  /**
   * @param latitude the latitude to set
   */
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }
  /**
   * @return the longitude
   */
  public String getLongitude() {
    return longitude;
  }
  /**
   * @param longitude the longitude to set
   */
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }
  /**
   * @return the altitude
   */
  public String getAltitude() {
    return altitude;
  }
  /**
   * @param altitude the altitude to set
   */
  public void setAltitude(String altitude) {
    this.altitude = altitude;
  }
  /**
   * @return the accuracy
   */
  public String getAccuracy() {
    return accuracy;
  }
  /**
   * @param accuracy the accuracy to set
   */
  public void setAccuracy(String accuracy) {
    this.accuracy = accuracy;
  }
  /**
   * @return the bearing
   */
  public String getBearing() {
    return bearing;
  }
  /**
   * @param bearing the bearing to set
   */
  public void setBearing(String bearing) {
    this.bearing = bearing;
  }
  
  /**
   * @return the speed
   */
  public String getSpeed() {
    return speed;
  }
  /**
   * @param speed the speed to set
   */
  public void setSpeed(String speed) {
    this.speed = speed;
  }
  /**
   * @return the time
   */
  public String getTime() {
    return time;
  }
  /**
   * @param time the time to set
   */
  public void setTime(String time) {
    this.time = time;
  }
  /**
   * @return the describeContents
   */
  public String getDescribeContents() {
    return describeContents;
  }
  /**
   * @param describeContents the describeContents to set
   */
  public void setDescribeContents(String describeContents) {
    this.describeContents = describeContents;
  }
  /**
   * @return the gpsProvider
   */
  public String getGpsProvider() {
    return gpsProvider;
  }
  /**
   * @param gpsProvider the gpsProvider to set
   */
  public void setGpsProvider(String gpsProvider) {
    this.gpsProvider = gpsProvider;
  }
  /**
   * @return the distibutorId
   */
  public long getDistibutorId() {
    return distibutorId;
  }
  /**
   * @param distibutorId the distibutorId to set
   */
  public void setDistibutorId(long distibutorId) {
    this.distibutorId = distibutorId;
  }
  
 
  
  
}
