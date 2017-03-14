package com.virrantech.restcontrollers;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.JsonObject;
import com.virrantech.entity.ConsumerProfile;
import com.virrantech.entity.ShopInfo;
import com.virrantech.handler.ConsumerHandler;
import com.virrantech.handler.OrderHandler;
import com.virrantech.handler.ProductHandler;
import com.virrantech.handler.ShopHandler;

@RestController
@ContextConfiguration("classpath:dispatcher-servlet.xml")
@RequestMapping("/shop-wser")
public class ShopRestController {

  
  @RequestMapping(value="/shop-register", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String byConsumes(@RequestBody ShopInfo shopEntity, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
    System.out.println("=================>>>"+shopEntity.getShopName());
   ShopHandler shopHandler=new ShopHandler();
  
  JsonObject result= shopHandler.insertNewShop(shopEntity, request);
 
   //consumerHandler.saveConsumerObject(consumerProfile, request);
  return result.toString();
  }
  
  @RequestMapping(value="/add-product-to-shop", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String consumerPwdAuthenticate(@RequestBody String  inputJsonObject, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
   ProductHandler productHandler=new ProductHandler();
      JsonObject result=null;
      try{
        if(inputJsonObject!=null){
          result=  new JsonObject();
          String itemFullName= new JSONObject(inputJsonObject).getString("itemFullName");
          String itemAvailable= new JSONObject(inputJsonObject).getString("itemAvailable");
          long shopId= new JSONObject(inputJsonObject).getLong("shopId");
          result= productHandler.addProductToMaster(itemFullName,itemAvailable,shopId, request);
        }
      }catch(Exception e){
        e.printStackTrace();
      }
      
    return result.toString();
  }
  @RequestMapping(value="/get-recent-orders", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
  public @ResponseBody String getRecentOrder(@RequestBody String  inputJsonObject, HttpServletResponse response,HttpServletRequest request) throws PropertyVetoException, SQLException {
   OrderHandler orderHandler=new OrderHandler();
      String result="";
      JsonObject jsonObj=new JsonObject();
      try{
        if(inputJsonObject!=null){
         
         long shopId= new JSONObject(inputJsonObject).getLong("shopId");
         
          result= orderHandler.getOrderForDistributors(shopId, request);
          if(result==null){
            jsonObj.addProperty("status", "faillure");
            result= jsonObj.toString();
          }
        }
      }catch(Exception e){
        e.printStackTrace();
      }
      
    return result;
  }
}
