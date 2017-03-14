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
public class ProductEntity implements Serializable {

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
  private long productId;
  @Persistent
  private String productName;
  @Persistent
  private String productQtyType;//KG,LITER
  @Persistent
  private int productQty;
  @Persistent
  private float productPrice;
  @Persistent
  private String productManufacturingDate;
  @Persistent
  private String productExpiryDate;
  @Persistent
  private String discountType; //OFFER ,DISCOUNT,NONE
  @Persistent
  private String productImgUrl;//NONE
  @Persistent
  private int productDiscountPercentage;
  @Persistent
  private String offerName;
  @Persistent
  private String offerEndDate;
  @Persistent
  private long distributorId;
  @Persistent
  private String productBrandName;
  @Persistent
  private String productCategoryName;
  @Persistent
  private String productFullName;
  @Persistent
  private String productAvailable;
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
   * @return the productId
   */
  public long getProductId() {
    return productId;
  }
  /**
   * @param productId the productId to set
   */
  public void setProductId(long productId) {
    this.productId = productId;
  }
  /**
   * @return the productName
   */
  public String getProductName() {
    return productName;
  }
  /**
   * @param productName the productName to set
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }
  /**
   * @return the productQtyType
   */
  public String getProductQtyType() {
    return productQtyType;
  }
  /**
   * @param productQtyType the productQtyType to set
   */
  public void setProductQtyType(String productQtyType) {
    this.productQtyType = productQtyType;
  }
  /**
   * @return the productQty
   */
  public int getProductQty() {
    return productQty;
  }
  /**
   * @param productQty the productQty to set
   */
  public void setProductQty(int productQty) {
    this.productQty = productQty;
  }
  /**
   * @return the productPrice
   */
  public float getProductPrice() {
    return productPrice;
  }
  /**
   * @param productPrice the productPrice to set
   */
  public void setProductPrice(float productPrice) {
    this.productPrice = productPrice;
  }
  /**
   * @return the productManufacturingDate
   */
  public String getProductManufacturingDate() {
    return productManufacturingDate;
  }
  /**
   * @param productManufacturingDate the productManufacturingDate to set
   */
  public void setProductManufacturingDate(String productManufacturingDate) {
    this.productManufacturingDate = productManufacturingDate;
  }
  /**
   * @return the productExpiryDate
   */
  public String getProductExpiryDate() {
    return productExpiryDate;
  }
  /**
   * @param productExpiryDate the productExpiryDate to set
   */
  public void setProductExpiryDate(String productExpiryDate) {
    this.productExpiryDate = productExpiryDate;
  }
  /**
   * @return the discountType
   */
  public String getDiscountType() {
    return discountType;
  }
  /**
   * @param discountType the discountType to set
   */
  public void setDiscountType(String discountType) {
    this.discountType = discountType;
  }
  /**
   * @return the productImgUrl
   */
  public String getProductImgUrl() {
    return productImgUrl;
  }
  /**
   * @param productImgUrl the productImgUrl to set
   */
  public void setProductImgUrl(String productImgUrl) {
    this.productImgUrl = productImgUrl;
  }
  /**
   * @return the productDiscountPercentage
   */
  public int getProductDiscountPercentage() {
    return productDiscountPercentage;
  }
  /**
   * @param productDiscountPercentage the productDiscountPercentage to set
   */
  public void setProductDiscountPercentage(int productDiscountPercentage) {
    this.productDiscountPercentage = productDiscountPercentage;
  }
  /**
   * @return the offerName
   */
  public String getOfferName() {
    return offerName;
  }
  /**
   * @param offerName the offerName to set
   */
  public void setOfferName(String offerName) {
    this.offerName = offerName;
  }
  /**
   * @return the offerEndDate
   */
  public String getOfferEndDate() {
    return offerEndDate;
  }
  /**
   * @param offerEndDate the offerEndDate to set
   */
  public void setOfferEndDate(String offerEndDate) {
    this.offerEndDate = offerEndDate;
  }
  /**
   * @return the serialversionuid
   */
  public static long getSerialversionuid() {
    return serialVersionUID;
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
  /**
   * @return the productBrandName
   */
  public String getProductBrandName() {
    return productBrandName;
  }
  /**
   * @param productBrandName the productBrandName to set
   */
  public void setProductBrandName(String productBrandName) {
    this.productBrandName = productBrandName;
  }
  /**
   * @return the productCategoryName
   */
  public String getProductCategoryName() {
    return productCategoryName;
  }
  /**
   * @param productCategoryName the productCategoryName to set
   */
  public void setProductCategoryName(String productCategoryName) {
    this.productCategoryName = productCategoryName;
  }
  /**
   * @return the productFullName
   */
  public String getProductFullName() {
    return productFullName;
  }
  /**
   * @param productFullName the productFullName to set
   */
  public void setProductFullName(String productFullName) {
    this.productFullName = productFullName;
  }
  /**
   * @return the productAvailable
   */
  public String getProductAvailable() {
    return productAvailable;
  }
  /**
   * @param productAvailable the productAvailable to set
   */
  public void setProductAvailable(String productAvailable) {
    this.productAvailable = productAvailable;
  }

}
