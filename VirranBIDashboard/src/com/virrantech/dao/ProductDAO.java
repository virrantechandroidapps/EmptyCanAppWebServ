package com.virrantech.dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.virrantech.entity.GroceryInfoEntity;
import com.virrantech.entity.ProductBrandEntity;
import com.virrantech.entity.ProductCategoryEntity;
import com.virrantech.entity.ProductEntity;

public interface ProductDAO {
  public JsonObject saveProduct(ProductEntity productEntity);
  public JsonArray findProductsByDistributor(long distributorId);
  public JsonObject saveProductCategory(ProductCategoryEntity categoryEntity);
  public JsonObject saveProductBrand(ProductBrandEntity brandEntity);
  public JsonObject saveGroceryInfo(GroceryInfoEntity groceryInfo);
  public GroceryInfoEntity findGroceryByItemName(String itemFullName);
  public JsonObject updateGroceryItem(GroceryInfoEntity groceryInfoEntity);
  public JsonArray findGroceryInfoByCategory(String  categoryName);
  public JsonObject deleteProduct(long productId);
}
