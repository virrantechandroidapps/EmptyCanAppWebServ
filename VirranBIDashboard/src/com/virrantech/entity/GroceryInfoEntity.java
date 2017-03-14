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
public class GroceryInfoEntity {

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key id;
  @Persistent
  private long itemId;
  @Persistent
  private String itemName;
  @Persistent
  private String itemFullName;
  @Persistent
  private String itemCategoryName;
  @Persistent
  private String itemBrandName;
  @Persistent
  private float itemCost;
  @Persistent
  private String itemMeasurementType;//Kg,ltr
  @Persistent
  private String itemImage;
  @Persistent
  private String isItemAvailable="FALSE";
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
   * @return the itemId
   */
  public long getItemId() {
    return itemId;
  }
  /**
   * @param itemId the itemId to set
   */
  public void setItemId(long itemId) {
    this.itemId = itemId;
  }
  /**
   * @return the itemName
   */
  public String getItemName() {
    return itemName;
  }
  /**
   * @param itemName the itemName to set
   */
  public void setItemName(String itemName) {
    this.itemName = itemName;
  }
  /**
   * @return the itemFullName
   */
  public String getItemFullName() {
    return itemFullName;
  }
  /**
   * @param itemFullName the itemFullName to set
   */
  public void setItemFullName(String itemFullName) {
    this.itemFullName = itemFullName;
  }
  /**
   * @return the itemCategoryName
   */
  public String getItemCategoryName() {
    return itemCategoryName;
  }
  /**
   * @param itemCategoryName the itemCategoryName to set
   */
  public void setItemCategoryName(String itemCategoryName) {
    this.itemCategoryName = itemCategoryName;
  }
  /**
   * @return the itemBrandName
   */
  public String getItemBrandName() {
    return itemBrandName;
  }
  /**
   * @param itemBrandName the itemBrandName to set
   */
  public void setItemBrandName(String itemBrandName) {
    this.itemBrandName = itemBrandName;
  }
  /**
   * @return the itemCost
   */
  public float getItemCost() {
    return itemCost;
  }
  /**
   * @param itemCost the itemCost to set
   */
  public void setItemCost(float itemCost) {
    this.itemCost = itemCost;
  }
  /**
   * @return the itemMeasurementType
   */
  public String getItemMeasurementType() {
    return itemMeasurementType;
  }
  /**
   * @param itemMeasurementType the itemMeasurementType to set
   */
  public void setItemMeasurementType(String itemMeasurementType) {
    this.itemMeasurementType = itemMeasurementType;
  }
  /**
   * @return the itemImage
   */
  public String getItemImage() {
    return itemImage;
  }
  /**
   * @param itemImage the itemImage to set
   */
  public void setItemImage(String itemImage) {
    this.itemImage = itemImage;
  }
  /**
   * @return the isItemAvailable
   */
  public String getIsItemAvailable() {
    return isItemAvailable;
  }
  /**
   * @param isItemAvailable the isItemAvailable to set
   */
  public void setIsItemAvailable(String isItemAvailable) {
    this.isItemAvailable = isItemAvailable;
  }
  
  
}
