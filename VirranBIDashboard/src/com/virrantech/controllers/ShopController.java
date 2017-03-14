package com.virrantech.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonObject;
import com.virrantech.handler.ProductHandler;
import com.virrantech.handler.ShopHandler;
import com.virrantech.utills.Constants;
import com.virrantech.utills.SaltUtils;

@Controller
public class ShopController {

  @RequestMapping(value="/launch-shop-main",method=RequestMethod.GET)
  public String lauchLoginPage(){
    System.out.println("calling here");
    
    return "shopmain";
    
  }
  @RequestMapping(value="/launch-shop-register",method=RequestMethod.GET)
  public String launchShopRegister(@CookieValue(value="shopvalidateus",required=false) String cookieValue,@CookieValue(value="shopmain_u",required=false) String shopInfo,HttpServletRequest request,HttpServletResponse response){
    System.out.println("calling here");
    if(cookieValue==null && shopInfo==null){
      return "shopregister";
    }
    
    return "shopindex";
    
  }
 /* @RequestMapping(value="/launch-shop-index",method=RequestMethod.GET)
  public String launchShopIndex(HttpServletRequest httpServletRequest){
    System.out.println("calling here");
  //  ProductHandler handler=new ProductHandler();
   // handler.resetProductCategory(httpServletRequest);
    return "shopindex";
    
  }*/
  @RequestMapping(value="/launch-products",method=RequestMethod.GET)
  public String getFruits(@CookieValue(value="shopmain_u",required=false) String shopId,HttpServletRequest httpServletRequest,HttpServletResponse response){
    System.out.println("calling here");
   String category=  httpServletRequest.getParameter("category");
   ProductHandler handler=new ProductHandler();
  httpServletRequest.setAttribute("shopId", Long.parseLong(shopId));
   //getBlobKey();
   //httpServletRequest.setAttribute("categorylist", handler.getProducts(category,httpServletRequest,response).toString());
   httpServletRequest.setAttribute("categorylist", handler.getGroceryInfoByCategoryName(category, httpServletRequest).toString());
  // httpServletRequest.setAttribute("categorylist", handler.getBlobKey("beverages","100012278_3-red-bull-energy-drink.jpg"));
   httpServletRequest.setAttribute("categoryname", category);
    return "fruitsvegcategory";
    
  } @RequestMapping(value="/upload-product-master-data",method=RequestMethod.GET)
  public String upLoadMasterData(HttpServletRequest httpServletRequest,HttpServletResponse response){
    System.out.println("calling here");
    String category=  httpServletRequest.getParameter("category");
   ProductHandler handler=new ProductHandler();
    //handler.readJsonFile("http://localhost:8888/js/grocery_info.json",httpServletRequest);
    return "fruitsvegcategory";
    
  }@RequestMapping(value="/launch-recent-order",method=RequestMethod.GET)
  public String lauchRecentOrder(@CookieValue(value="shopmain_u",required=false) String shopId,HttpServletRequest httpServletRequest,HttpServletResponse response){
    httpServletRequest.setAttribute("shopId", Long.parseLong(shopId));
    return "recentorders";
    
  }
  
  @RequestMapping(value="/launch-shop-index",method=RequestMethod.GET)
  public String lauchShopGetPage(@CookieValue(value="shopvalidateus",required=false) String cookieValue,@CookieValue(value="shopmain_u",required=false) String shopInfo,HttpServletRequest request,HttpServletResponse response){
    String mainPage="";
    /*Cookie resultCook=null;
     Cookie[] cookies = request.getCookies();
     if (cookies != null) {
       for (Cookie cookie : cookies) {
         if (cookie.getName().equals("validateus") || cookie.getName().equals("main_u") ) {
           resultCook=cookie;
           resultCook.setMaxAge(0);
           response.addCookie(resultCook);
           //resultCook
          // resultCook=null;
           //do something
           //value can be retrieved using #cookie.getValue()
          }
        }
      }*/
     ProductHandler productHandler=new ProductHandler();
     ShopHandler shopHandler =new ShopHandler();
     if(cookieValue!=null && SaltUtils.authenticate( Constants.WEB_USER_VALIDATION , cookieValue)){
       request.setAttribute("productlist", productHandler.getAllDistributorProducts(0L, request));
       request.setAttribute("isguestuser", false);
       JsonObject consumerObj=  shopHandler.getShopInfoById(Long.parseLong(shopInfo),request);
       request.setAttribute("shopinfoobject", consumerObj);
       return "shopindex";
       
     }else{
      request.setAttribute("productlist", productHandler.getAllDistributorProducts(0L, request));
       String shopId= request.getParameter("shopId");
     
       if(shopId!=null){
         JsonObject shopInfoJsonObj=  shopHandler.getShopInfoById(Long.parseLong(shopInfo),request);
         // String consumerObj= (String) request.getSession().getAttribute("consumerObject");
           System.out.println("================"+shopId);
         request.setAttribute("shopinfoobject", shopInfoJsonObj);
         request.setAttribute("isguestuser", false);
         
         Cookie cityCookie = new Cookie("shopvalidateus",SaltUtils.encrypt(Constants.WEB_USER_VALIDATION));
         cityCookie.setMaxAge(3000000);
         response.addCookie(cityCookie);
         
         Cookie consumerCookie = new Cookie("shopmain_u",shopId);
         consumerCookie.setMaxAge(3000000);
         response.addCookie(consumerCookie);
       }else{
         JsonObject dummyObject=new JsonObject();
         request.setAttribute("shopinfoobject", dummyObject);
         request.setAttribute("isguestuser", true);
         return "shopregister";
         //request.setAttribute("consumerobject", dummyObject);
       }
     }
     return "shopindex";
   }
  @RequestMapping(value="/launch-shop-index",method=RequestMethod.POST)
  public String lauchShopPostPage(@CookieValue(value="shopvalidateus",required=false) String cookieValue,@CookieValue(value="shopmain_u",required=false) String shopInfo,HttpServletRequest request,HttpServletResponse response){
    String mainPage="";
    /*Cookie resultCook=null;
     Cookie[] cookies = request.getCookies();
     if (cookies != null) {
       for (Cookie cookie : cookies) {
         if (cookie.getName().equals("validateus") || cookie.getName().equals("main_u") ) {
           resultCook=cookie;
           resultCook.setMaxAge(0);
           response.addCookie(resultCook);
           //resultCook
          // resultCook=null;
           //do something
           //value can be retrieved using #cookie.getValue()
          }
        }
      }*/
     ProductHandler productHandler=new ProductHandler();
     ShopHandler shopHandler =new ShopHandler();
     if(cookieValue!=null && SaltUtils.authenticate( Constants.WEB_USER_VALIDATION , cookieValue)){
       request.setAttribute("productlist", productHandler.getAllDistributorProducts(0L, request));
       request.setAttribute("isguestuser", false);
       JsonObject consumerObj=  shopHandler.getShopInfoById(Long.parseLong(shopInfo),request);
       request.setAttribute("shopinfoobject", consumerObj);
       return "shopindex";
       
     }else{
      request.setAttribute("productlist", productHandler.getAllDistributorProducts(0L, request));
       String shopId= request.getParameter("shopId");
     
       if(shopId!=null){
         JsonObject shopInfoJsonObj=  shopHandler.getShopInfoById(Long.parseLong(shopId),request);
         // String consumerObj= (String) request.getSession().getAttribute("consumerObject");
           System.out.println("================"+shopId);
         request.setAttribute("shopinfoobject", shopInfoJsonObj);
         request.setAttribute("isguestuser", false);
         
         Cookie cityCookie = new Cookie("shopvalidateus",SaltUtils.encrypt(Constants.WEB_USER_VALIDATION));
         cityCookie.setMaxAge(3000000);
         response.addCookie(cityCookie);
         
         Cookie consumerCookie = new Cookie("shopmain_u",shopId);
         consumerCookie.setMaxAge(3000000);
         response.addCookie(consumerCookie);
       }else{
         JsonObject dummyObject=new JsonObject();
         request.setAttribute("shopinfoobject", dummyObject);
         request.setAttribute("isguestuser", true);
         return "shopregister";
         //request.setAttribute("consumerobject", dummyObject);
       }
     }
     
   
     return "shopindex";
    
  }
  @RequestMapping(value="/launch-shop-signout",method=RequestMethod.GET)
  public String dispatchShopSignOut(HttpServletRequest request,HttpServletResponse response){
    try{
      Cookie resultCook=null;
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (Cookie cookie : cookies) {
          if (cookie.getName().equals("shopvalidateus") || cookie.getName().equals("shopmain_u") ) {
            resultCook=cookie;
            resultCook.setMaxAge(0);
            response.addCookie(resultCook);
          
           }
         }
      }
      request.getSession().invalidate();
      ProductHandler productHandler=new ProductHandler();
      request.setAttribute("productlist", productHandler.getAllDistributorProducts(0L, request));
      request.setAttribute("isguestuser", true);
      JsonObject dummyObject=new JsonObject();
      request.setAttribute("consumerobject", dummyObject.toString());
    }catch(Exception e){
      e.printStackTrace();
    }
    return "shopregister";
  }
 
}
