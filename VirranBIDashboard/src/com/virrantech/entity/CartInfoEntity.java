package com.virrantech.entity;

import java.io.Serializable;

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

/**
 * Created by varadhan on 10-12-2016.
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
@Entity
public class CartInfoEntity implements Serializable {

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
  private int cartId;
  @Persistent
  private String cartPrdctName;
  @Persistent
  private long cartPrdctId;
  @Persistent
  private int cartPrdctQty;
  @Persistent
  private float cartPrdctPrice;
  @Persistent
  private int cartPrdctUnit;
  @Persistent
  private String cartBookDate;
  @Persistent
  private long cartBookby;
  @Persistent
  private String cartPrdctOffer;
  @Persistent 
  private long orderId;

/*  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private OrderInfoEntity orderInfoEntity;*/


  public long getCartBookby() {
    return cartBookby;
  }

  public void setCartBookby(long cartBookby) {
    this.cartBookby = cartBookby;
  }

  public String getCartBookDate() {
    return cartBookDate;
  }

  public void setCartBookDate(String cartBookDate) {
    this.cartBookDate = cartBookDate;
  }

  public int getCartId() {
    return cartId;
  }

  public void setCartId(int cartId) {
    this.cartId = cartId;
  }

  public long getCartPrdctId() {
    return cartPrdctId;
  }

  public void setCartPrdctId(long cartPrdctId) {
    this.cartPrdctId = cartPrdctId;
  }

  public String getCartPrdctName() {
    return cartPrdctName;
  }

  public void setCartPrdctName(String cartPrdctName) {
    this.cartPrdctName = cartPrdctName;
  }

  public String getCartPrdctOffer() {
    return cartPrdctOffer;
  }

  public void setCartPrdctOffer(String cartPrdctOffer) {
    this.cartPrdctOffer = cartPrdctOffer;
  }

  public float getCartPrdctPrice() {
    return cartPrdctPrice;
  }

  public void setCartPrdctPrice(float cartPrdctPrice) {
    this.cartPrdctPrice = cartPrdctPrice;
  }

  public int getCartPrdctQty() {
    return cartPrdctQty;
  }

  public void setCartPrdctQty(int cartPrdctQty) {
    this.cartPrdctQty = cartPrdctQty;
  }

  public int getCartPrdctUnit() {
    return cartPrdctUnit;
  }

  public void setCartPrdctUnit(int cartPrdctUnit) {
    this.cartPrdctUnit = cartPrdctUnit;
  }

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

 /* *//**
   * @return the orderInfoEntity
   *//*
  public OrderInfoEntity getOrderInfoEntity() {
    return orderInfoEntity;
  }

  *//**
   * @param orderInfoEntity the orderInfoEntity to set
   *//*
  public void setOrderInfoEntity(OrderInfoEntity orderInfoEntity) {
    this.orderInfoEntity = orderInfoEntity;
  }*/

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
   * @return the serialversionuid
   */
  public static long getSerialversionuid() {
    return serialVersionUID;
  }



}
