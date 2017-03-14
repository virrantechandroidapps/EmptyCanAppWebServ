package com.virrantech.entity;

import java.io.Serializable;

public class GroceryInfo implements Serializable {
  
  private String product_category;
  private String product_brand;
  private String img_title;
  private String img_src;
  private String column1;
  private String column2;
  /**
   * @return the product_category
   */
  public String getProduct_category() {
    return product_category;
  }
  /**
   * @param product_category the product_category to set
   */
  public void setProduct_category(String product_category) {
    this.product_category = product_category;
  }
  /**
   * @return the product_brand
   */
  public String getProduct_brand() {
    return product_brand;
  }
  /**
   * @param product_brand the product_brand to set
   */
  public void setProduct_brand(String product_brand) {
    this.product_brand = product_brand;
  }
  /**
   * @return the img_title
   */
  public String getImg_title() {
    return img_title;
  }
  /**
   * @param img_title the img_title to set
   */
  public void setImg_title(String img_title) {
    this.img_title = img_title;
  }
  /**
   * @return the img_src
   */
  public String getImg_src() {
    return img_src;
  }
  /**
   * @param img_src the img_src to set
   */
  public void setImg_src(String img_src) {
    this.img_src = img_src;
  }
  /**
   * @return the column1
   */
  public String getColumn1() {
    return column1;
  }
  /**
   * @param column1 the column1 to set
   */
  public void setColumn1(String column1) {
    this.column1 = column1;
  }
  /**
   * @return the column2
   */
  public String getColumn2() {
    return column2;
  }
  /**
   * @param column2 the column2 to set
   */
  public void setColumn2(String column2) {
    this.column2 = column2;
  }

}
