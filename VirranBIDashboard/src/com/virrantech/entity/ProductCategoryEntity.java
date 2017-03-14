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
public class ProductCategoryEntity implements Serializable {
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
  private String productCategory;
  @Persistent
  private long productCategoryId;
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
   * @return the productCategory
   */
  public String getProductCategory() {
    return productCategory;
  }
  /**
   * @param productCategory the productCategory to set
   */
  public void setProductCategory(String productCategory) {
    this.productCategory = productCategory;
  }
  /**
   * @return the productCategoryId
   */
  public long getProductCategoryId() {
    return productCategoryId;
  }
  /**
   * @param productCategoryId the productCategoryId to set
   */
  public void setProductCategoryId(long productCategoryId) {
    this.productCategoryId = productCategoryId;
  }
}
