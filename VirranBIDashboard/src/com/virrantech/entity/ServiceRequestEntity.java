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
public class ServiceRequestEntity {

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key  id;
  @Persistent
  private Long consumerId;
  @Persistent
  private Integer serviceId;
  @Persistent
  private String serviceRequestedDateTime;
  @Persistent
  private String serviceRequestedTo;
  @Persistent
  private String serviceName;
  @Persistent
  private String servicRequestFrmCurrentLatLng;
  @Persistent
  private String servicDeliveryAddressId;
  @Persistent
  private int servicQty;
  @Persistent
  private String paymentMode;
  @Persistent
  private String serviceConfirmationCode;
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
   * @return the consumerId
   */
  public Long getConsumerId() {
    return consumerId;
  }
  /**
   * @param consumerId the consumerId to set
   */
  public void setConsumerId(Long consumerId) {
    this.consumerId = consumerId;
  }
  /**
   * @return the serviceId
   */
  public Integer getServiceId() {
    return serviceId;
  }
  /**
   * @param serviceId the serviceId to set
   */
  public void setServiceId(Integer serviceId) {
    this.serviceId = serviceId;
  }
  /**
   * @return the serviceRequestedDateTime
   */
  public String getServiceRequestedDateTime() {
    return serviceRequestedDateTime;
  }
  /**
   * @param serviceRequestedDateTime the serviceRequestedDateTime to set
   */
  public void setServiceRequestedDateTime(String serviceRequestedDateTime) {
    this.serviceRequestedDateTime = serviceRequestedDateTime;
  }
  /**
   * @return the serviceRequestedTo
   */
  public String getServiceRequestedTo() {
    return serviceRequestedTo;
  }
  /**
   * @param serviceRequestedTo the serviceRequestedTo to set
   */
  public void setServiceRequestedTo(String serviceRequestedTo) {
    this.serviceRequestedTo = serviceRequestedTo;
  }
  /**
   * @return the serviceName
   */
  public String getServiceName() {
    return serviceName;
  }
  /**
   * @param serviceName the serviceName to set
   */
  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }
  /**
   * @return the servicRequestFrmCurrentLatLng
   */
  public String getServicRequestFrmCurrentLatLng() {
    return servicRequestFrmCurrentLatLng;
  }
  /**
   * @param servicRequestFrmCurrentLatLng the servicRequestFrmCurrentLatLng to set
   */
  public void setServicRequestFrmCurrentLatLng(String servicRequestFrmCurrentLatLng) {
    this.servicRequestFrmCurrentLatLng = servicRequestFrmCurrentLatLng;
  }
  /**
   * @return the servicDeliveryAddressId
   */
  public String getServicDeliveryAddressId() {
    return servicDeliveryAddressId;
  }
  /**
   * @param servicDeliveryAddressId the servicDeliveryAddressId to set
   */
  public void setServicDeliveryAddressId(String servicDeliveryAddressId) {
    this.servicDeliveryAddressId = servicDeliveryAddressId;
  }
  /**
   * @return the servicQty
   */
  public int getServicQty() {
    return servicQty;
  }
  /**
   * @param servicQty the servicQty to set
   */
  public void setServicQty(int servicQty) {
    this.servicQty = servicQty;
  }
}
