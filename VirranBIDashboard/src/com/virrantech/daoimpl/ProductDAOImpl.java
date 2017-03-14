package com.virrantech.daoimpl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.virrantech.dao.ProductDAO;
import com.virrantech.entity.GroceryInfoEntity;
import com.virrantech.entity.ProductBrandEntity;
import com.virrantech.entity.ProductCategoryEntity;
import com.virrantech.entity.ProductEntity;
import com.virrantech.utills.PMF;

public class ProductDAOImpl implements ProductDAO {

  @Override
  public JsonObject saveProduct(ProductEntity productEntity) {

    JsonObject jsonObject=null;
    try{
      jsonObject=new JsonObject();
      PersistenceManager  pm = PMF.get().getPersistenceManager();
      productEntity=pm.makePersistent(productEntity);
      jsonObject.addProperty("product_server_id", productEntity.getId().getId());
      jsonObject.addProperty("status","success");
    }catch(Exception e){
      jsonObject.addProperty("status", "error");
      e.printStackTrace();
    }

    return jsonObject;
  
  }
  
  @Override
  public JsonArray findProductsByDistributor(long distributorId) {

    
    JsonArray jsonArray=null;
    PersistenceManager  pm=null;
    List <ProductEntity> productList =null;
  Query query = null;
    try{
     pm = PMF.get().getPersistenceManager();
     query = pm.newQuery( ProductEntity.class ,"distributorId=="+distributorId+"");
     productList=  (List<ProductEntity>) query.execute();
     productList.size();
     Gson gson = new Gson();
     String strJsonArray =gson.toJson(productList, new TypeToken<List<ProductEntity>>() {}.getType());
      JsonParser parser = new JsonParser();
     JsonElement tradeElement = parser.parse(strJsonArray);
     jsonArray= tradeElement.getAsJsonArray();

     }catch(Exception e){
      
       e.printStackTrace();
    }finally {
      pm.close();
    }
    return jsonArray;
  
   
  }

  @Override
  public JsonObject saveProductCategory(ProductCategoryEntity categoryEntity) {
    JsonObject jsonObject=null;
    try{
      jsonObject=new JsonObject();
      PersistenceManager  pm = PMF.get().getPersistenceManager();
      categoryEntity=pm.makePersistent(categoryEntity);
      jsonObject.addProperty("product_category_server_id", categoryEntity.getId().getId());
      jsonObject.addProperty("status","success");
    }catch(Exception e){
      jsonObject.addProperty("status", "error");
      e.printStackTrace();
    }

    return jsonObject;
  }

  @Override
  public JsonObject saveProductBrand(ProductBrandEntity brandEntity) {
    JsonObject jsonObject=null;
    try{
      jsonObject=new JsonObject();
      PersistenceManager  pm = PMF.get().getPersistenceManager();
      brandEntity=pm.makePersistent(brandEntity);
      jsonObject.addProperty("product_brand_server_id", brandEntity.getId().getId());
      jsonObject.addProperty("status","success");
    }catch(Exception e){
      jsonObject.addProperty("status", "error");
      e.printStackTrace();
    }

    return jsonObject;
  }

  @Override
  public JsonObject saveGroceryInfo(GroceryInfoEntity groceryInfo) {
    JsonObject jsonObject=null;
    try{
      jsonObject=new JsonObject();
      PersistenceManager  pm = PMF.get().getPersistenceManager();
      groceryInfo=pm.makePersistent(groceryInfo);
      jsonObject.addProperty("product_brand_server_id", groceryInfo.getId().getId());
      jsonObject.addProperty("status","success");
    }catch(Exception e){
      jsonObject.addProperty("status", "error");
      e.printStackTrace();
    }

    return jsonObject;
  }

  @Override
  public GroceryInfoEntity findGroceryByItemName(String itemFullName) {

    GroceryInfoEntity groceryInfoEntity=null;
      PersistenceManager  pm=null;
      List <GroceryInfoEntity> groceryInfoList =null;
    Query query = null;
      try{
       pm = PMF.get().getPersistenceManager();
       query = pm.newQuery( GroceryInfoEntity.class , "itemFullName == '"+itemFullName+"'" );
       groceryInfoList=  (List<GroceryInfoEntity>) query.execute();
       if ( !groceryInfoList.isEmpty() )
         groceryInfoEntity = groceryInfoList.get( 0 );
       }catch(Exception e){
        
         e.printStackTrace();
      }finally {
        pm.close();
      }
      return groceryInfoEntity;
    
  }

 
  public JsonObject updateGroceryItem(GroceryInfoEntity groceryInfoEntity) {
    PersistenceManager  pm=null;
    JsonObject jsonObject=null;
    try{
      jsonObject=new JsonObject();
      pm = PMF.get().getPersistenceManager();
      pm.makePersistent(groceryInfoEntity);
      jsonObject.addProperty("status", "success");
   }catch(Exception e){
     jsonObject.addProperty("status", "fail");
     e.printStackTrace();
   }
    return jsonObject;
  }
  

  @Override
  public JsonArray findGroceryInfoByCategory(String categoryName) {

    
    JsonArray jsonArray=null;
    PersistenceManager  pm=null;
    List <GroceryInfoEntity> groceryInfoListFromDb =null;
  Query query = null;
    try{
     pm = PMF.get().getPersistenceManager();
     
     query = pm.newQuery( GroceryInfoEntity.class ,"itemCategoryName=='"+categoryName+"'");
     groceryInfoListFromDb=  (List<GroceryInfoEntity>) query.execute();
     //groceryInfoListFromDb.size();
     Gson gson = new Gson();
     String strJsonArray =gson.toJson(groceryInfoListFromDb, new TypeToken<List<GroceryInfoEntity>>() {}.getType());
      JsonParser parser = new JsonParser();
     JsonElement tradeElement = parser.parse(strJsonArray);
     jsonArray= tradeElement.getAsJsonArray();

     }catch(Exception e){
      
       e.printStackTrace();
    }finally {
      pm.close();
    }
    return jsonArray;
  
  }

  @Override
  public JsonObject deleteProduct(long productId) {
    JsonObject jsonObject=null;
    PersistenceManager  pm=null;
    List <ProductEntity> productEntitlyList =null;
  Query query = null;
    try{
      jsonObject=new JsonObject();
     pm = PMF.get().getPersistenceManager();
     pm.currentTransaction().begin();
     query = pm.newQuery( ProductEntity.class ,"productId=="+productId+"");
     
     productEntitlyList=  (List<ProductEntity>) query.execute();
     if(productEntitlyList!=null && productEntitlyList.size() > 0){
       pm.deletePersistent(productEntitlyList.get(0));   
     }
     pm.currentTransaction().commit();
     jsonObject.addProperty("status", "success");
   }catch(Exception e){
     jsonObject.addProperty("status", "failled");
     e.printStackTrace();
   }finally {
     if (pm.currentTransaction().isActive()) {
       pm.currentTransaction().rollback();
     }

   }
    return jsonObject;
  }
  

}
