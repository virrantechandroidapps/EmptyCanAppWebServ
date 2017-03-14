package com.virrantech.handler;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.virrantech.dao.ConsumerDAO;
import com.virrantech.dao.ShopDAO;
import com.virrantech.daoimpl.ConsumerDAOImpl;
import com.virrantech.daoimpl.ShopDAOImpl;
import com.virrantech.entity.ShopInfo;
import com.virrantech.utills.DateUtilities;
import com.virrantech.utills.JSONUtils;
import com.virrantech.utills.SaltUtils;
import com.virrantech.utills.SpringBeanUtils;

public class ShopHandler {

  
  
  public JsonObject insertNewShop(ShopInfo shopEntity,HttpServletRequest request){
    JsonObject result=null;
    try{
      shopEntity.setShopRegistrationDate(DateUtilities.getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS));
      ShopDAO  shopDAO=(ShopDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "shopDAOImpl",request);
      shopEntity.setShopUserPasswrd(convertAsEncryptionPwd(shopEntity.getShopUserPasswrd()));
      result=shopDAO.saveShop(shopEntity);
        
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }
public String convertAsEncryptionPwd(String passWrd){
    
    try{
     String encryptedPassword=  SaltUtils.encrypt(passWrd);
    
     return encryptedPassword;
    }catch(Exception e){
      e.printStackTrace();
    }
    return "";
  }
public JsonObject getShopInfoById(long shopId,HttpServletRequest request){
  JsonObject consumerObject=null;
  try{
    ShopDAO  shopDAO=(ShopDAOImpl) SpringBeanUtils.getInstance("/WEB-INF/dispatcher-servlet.xml", "shopDAOImpl",request);
     ShopInfo shopInfo= shopDAO.findShopInfoById(shopId);
     if(shopInfo!=null){
       JSONUtils jsonUtills=new JSONUtils();
        consumerObject= jsonUtills.getJSONObject(shopInfo); ;
        consumerObject.remove("shopUserPasswrd");
     }
   
  }catch(Exception e){
    e.printStackTrace();
  }
  return consumerObject;
}
}
