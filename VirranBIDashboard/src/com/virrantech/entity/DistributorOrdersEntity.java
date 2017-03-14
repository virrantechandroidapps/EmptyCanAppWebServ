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
public class DistributorOrdersEntity {
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key id;
  @Persistent
  private long orderId;
  @Persistent
  private String orderForwardedDate;
  @Persistent
  private String orderBookingId;
  @Persistent 
  private String consumerName;
  @Persistent
  private float toatalAmountToBePaid;
  @Persistent
  private String orderDescription;
  @Persistent
  private String consumerShortAddress;
  @Persistent 
  private String orderStatus; //Processed or Denied or Delivered
  
  @Persistent
  private long distributorId;
  
  @Persistent(mappedBy = "distributorOrdersEntity",defaultFetchGroup="true",loadFetchGroup="true")
  @OneToMany(mappedBy = "distributorOrdersEntity", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
  @Element(dependent = "true")
  private List<CartInfoEntity> cartInfoEntityList = new ArrayList<CartInfoEntity>();

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
   * @return the orderId
   */
  public long getOrderId() {
    return orderId;
  }

  /**
   * @param orderId the orderId to set
   */
  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  /**
   * @return the orderForwardedDate
   */
  public String getOrderForwardedDate() {
    return orderForwardedDate;
  }

  /**
   * @param orderForwardedDate the orderForwardedDate to set
   */
  public void setOrderForwardedDate(String orderForwardedDate) {
    this.orderForwardedDate = orderForwardedDate;
  }

  /**
   * @return the orderBookingId
   */
  public String getOrderBookingId() {
    return orderBookingId;
  }

  /**
   * @param orderBookingId the orderBookingId to set
   */
  public void setOrderBookingId(String orderBookingId) {
    this.orderBookingId = orderBookingId;
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
   * @return the toatalAmountToBePaid
   */
  public float getToatalAmountToBePaid() {
    return toatalAmountToBePaid;
  }

  /**
   * @param toatalAmountToBePaid the toatalAmountToBePaid to set
   */
  public void setToatalAmountToBePaid(float toatalAmountToBePaid) {
    this.toatalAmountToBePaid = toatalAmountToBePaid;
  }

  /**
   * @return the orderDescription
   */
  public String getOrderDescription() {
    return orderDescription;
  }

  /**
   * @param orderDescription the orderDescription to set
   */
  public void setOrderDescription(String orderDescription) {
    this.orderDescription = orderDescription;
  }

  /**
   * @return the consumerShortAddress
   */
  public String getConsumerShortAddress() {
    return consumerShortAddress;
  }

  /**
   * @param consumerShortAddress the consumerShortAddress to set
   */
  public void setConsumerShortAddress(String consumerShortAddress) {
    this.consumerShortAddress = consumerShortAddress;
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
   * @return the cartInfoEntityList
   */
  public List<CartInfoEntity> getCartInfoEntityList() {
    return cartInfoEntityList;
  }

  /**
   * @param cartInfoEntityList the cartInfoEntityList to set
   */
  public void setCartInfoEntityList(List<CartInfoEntity> cartInfoEntityList) {
    this.cartInfoEntityList = cartInfoEntityList;
  }

  /**
   * @return the distributorId
   */
  public long getDistributorId() {
    return distributorId;
  }

  /**
   * @param distributorId the distributorId to set
   */
  public void setDistributorId(long distributorId) {
    this.distributorId = distributorId;
  } 
  
  
  

}
