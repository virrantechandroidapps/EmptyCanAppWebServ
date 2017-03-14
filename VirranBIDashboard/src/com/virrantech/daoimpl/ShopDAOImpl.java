package com.virrantech.daoimpl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gson.JsonObject;
import com.virrantech.dao.ShopDAO;
import com.virrantech.entity.ConsumerProfile;
import com.virrantech.entity.ShopInfo;
import com.virrantech.utills.PMF;

public class ShopDAOImpl implements ShopDAO {

  @Override
  public JsonObject saveShop(ShopInfo shopInfo) {
    JsonObject jsonObject=null;
    try{
      jsonObject=new JsonObject();
      PersistenceManager  pm = PMF.get().getPersistenceManager();
     shopInfo=pm.makePersistent(shopInfo);
     jsonObject.addProperty("shopId", shopInfo.getId().getId());
     jsonObject.addProperty("status", "success");
    }catch(Exception e){
      jsonObject.addProperty("status", "error");
      e.printStackTrace();
    }

    return jsonObject;
  }

  @Override
  public ShopInfo findShopInfoById(long shopId) {

    ShopInfo shopInfo=null;
      PersistenceManager  pm=null;
      
      try{
       pm = PMF.get().getPersistenceManager();
       shopInfo=new ShopInfo();
       Key  keyId= KeyFactory.createKey("ShopInfo", shopId);
       shopInfo= (ShopInfo) pm.getObjectById(ShopInfo.class,keyId);
      
       }catch(Exception e){
         e.printStackTrace();
      }finally {
        pm.close();
      }
      return shopInfo;
    
  }
  


}
