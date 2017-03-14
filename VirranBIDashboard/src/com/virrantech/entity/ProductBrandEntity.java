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
public class ProductBrandEntity  implements Serializable {

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
  private String brandName;
  @Persistent
  private long productBrandId;
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
   * @return the brandName
   */
  public String getBrandName() {
    return brandName;
  }
  /**
   * @param brandName the brandName to set
   */
  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }
  /**
   * @return the productBrandId
   */
  public long getProductBrandId() {
    return productBrandId;
  }
  /**
   * @param productBrandId the productBrandId to set
   */
  public void setProductBrandId(long productBrandId) {
    this.productBrandId = productBrandId;
  }
 
}
