package com.virrantech.controllers;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.types.resources.selectors.Date;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.virrantech.entity.DatabaseInstanceEntity;
import com.virrantech.handler.ConsumerHandler;
import com.virrantech.handler.ProductHandler;
import com.virrantech.utills.Constants;
import com.virrantech.utills.DbUtills;
import com.virrantech.utills.SaltUtils;

@Controller
public class DispatchPage {
  
  @RequestMapping(value="/virranbi",method=RequestMethod.GET)
  public String lauchLoginPage(){
    System.out.println("calling here");
    
    return "template";
    
  }
  @RequestMapping(value="/virranbi-login",method=RequestMethod.GET)
  public String dummyPage(){
    System.out.println("calling herettt");
    return "test";
    
  }
  @RequestMapping(value="/",method=RequestMethod.GET)
  public String lauch(){
    System.out.println("calling herettt");
    return "template";
    
  }
  @RequestMapping(value="/lauchblanckpage",method=RequestMethod.GET)
  public String lauchBlankPage(){
    System.out.println("calling herettt");
    return "blankpage";
    
  }
  @RequestMapping(value="/launch-notification-form",method=RequestMethod.GET)
  public String launchNotificationPage(HttpServletRequest request){
    ConsumerHandler consumerHandler=new ConsumerHandler();
    request.setAttribute("consumerList",  consumerHandler.getConsumerArray(request));
    System.out.println("calling notification form");
    return "notificationsenderform";
    
  }
  @RequestMapping(value="/launch-product-def-form",method=RequestMethod.GET)
  public String lauchProductDef(HttpServletRequest request){
    ConsumerHandler consumerHandler=new ConsumerHandler();
    request.setAttribute("consumerList",  consumerHandler.getConsumerArray(request));
    System.out.println("calling notification form");
    return "productdef";
    
  }
  @RequestMapping(value="/launch-d3",method=RequestMethod.GET)
  public String lauchD3(HttpServletRequest request){
   
    return "gaugeexample";
    
  }
  /*@RequestMapping(value="/launch-main",method=RequestMethod.POST)
  public String lauchMainPage(HttpServletRequest request,HttpServletResponse response){
   
  
    return "productmain";
    
  }*/
  @RequestMapping(value="/launch-main",method=RequestMethod.GET)
  public String lauchMainGetPage(@CookieValue(value="validateus",required=false) String cookieValue,@CookieValue(value="main_u",required=false) String userInfo,HttpServletRequest request,HttpServletResponse response){
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
    ConsumerHandler consumerHandler =new ConsumerHandler();
    if(cookieValue!=null && SaltUtils.authenticate( Constants.WEB_USER_VALIDATION , cookieValue)){
      request.setAttribute("productlist", productHandler.getAllDistributorProducts(123456L, request));
      request.setAttribute("isguestuser", false);
      JsonObject consumerObj=  consumerHandler.getConsumerById(Long.parseLong(userInfo),request);
      request.setAttribute("consumerobject", consumerObj);
      return "productmain";
      
    }else{
     request.setAttribute("productlist", productHandler.getAllDistributorProducts(123456L, request));
      String consumerId= request.getParameter("consumerid");
     
     
    
     // String consumerObj= (String) request.getSession().getAttribute("consumerObject");
       System.out.println("================"+consumerId);
      if(consumerId!=null){
        JsonObject consumerObj=  consumerHandler.getConsumerById(Long.parseLong(consumerId),request);
        request.setAttribute("consumerobject", consumerObj.toString());
        request.setAttribute("isguestuser", false);
        
        Cookie cityCookie = new Cookie("validateus",SaltUtils.encrypt(Constants.WEB_USER_VALIDATION));
        cityCookie.setMaxAge(3000000);
        response.addCookie(cityCookie);
        
        Cookie consumerCookie = new Cookie("main_u",consumerId);
        consumerCookie.setMaxAge(3000000);
        response.addCookie(consumerCookie);
      }else{
        JsonObject dummyObject=new JsonObject();
        request.setAttribute("consumerobject", dummyObject);
        request.setAttribute("isguestuser", true);
      }
    }
    
  
    return "productmain";
    
  }
  @RequestMapping(value="/launch-main",method=RequestMethod.POST)
  public String lauchMainPostPage(@CookieValue(value="validateus",required=false) String cookieValue,@CookieValue(value="main_u",required=false) String userInfo,HttpServletRequest request,HttpServletResponse response){
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
     ConsumerHandler consumerHandler =new ConsumerHandler();
     if(cookieValue!=null && SaltUtils.authenticate( Constants.WEB_USER_VALIDATION , cookieValue)){
       request.setAttribute("productlist", productHandler.getAllDistributorProducts(0L, request));
       request.setAttribute("isguestuser", false);
       JsonObject consumerObj=  consumerHandler.getConsumerById(Long.parseLong(userInfo),request);
       request.setAttribute("consumerobject", consumerObj);
       return "productmain";
       
     }else{
      request.setAttribute("productlist", productHandler.getAllDistributorProducts(0L, request));
       String consumerId= request.getParameter("consumerid");
     
       if(consumerId!=null){
         JsonObject consumerObj=  consumerHandler.getConsumerById(Long.parseLong(consumerId),request);
         // String consumerObj= (String) request.getSession().getAttribute("consumerObject");
           System.out.println("================"+consumerId);
         request.setAttribute("consumerobject", consumerObj);
         request.setAttribute("isguestuser", false);
         
         Cookie cityCookie = new Cookie("validateus",SaltUtils.encrypt(Constants.WEB_USER_VALIDATION));
         cityCookie.setMaxAge(3000000);
         response.addCookie(cityCookie);
         
         Cookie consumerCookie = new Cookie("main_u",consumerId);
         consumerCookie.setMaxAge(3000000);
         response.addCookie(consumerCookie);
       }else{
         JsonObject dummyObject=new JsonObject();
         request.setAttribute("consumerobject", dummyObject);
         request.setAttribute("isguestuser", true);
         //request.setAttribute("consumerobject", dummyObject);
       }
     }
     
   
     return "productmain";
    
  }
  @RequestMapping(value="/launch-signin",method=RequestMethod.GET)
  public String lauchsignin(HttpServletRequest request,HttpServletResponse response){
   
    return "emptycansignin";
    
  }
  @RequestMapping(value="/dispatch-db-conn",method=RequestMethod.GET)
  public ModelAndView dispatchDbConnection(HttpServletRequest request,HttpServletResponse response){
    ModelAndView modelandView=new ModelAndView("dbconnection");
    modelandView.addObject(new DatabaseInstanceEntity());
    System.out.println("calling herettt");
    return modelandView;
  }
  @RequestMapping(value="/launch-signout",method=RequestMethod.GET)
  public String dispatchSignOut(HttpServletRequest request,HttpServletResponse response){
    try{
      Cookie resultCook=null;
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (Cookie cookie : cookies) {
          if (cookie.getName().equals("validateus") || cookie.getName().equals("main_u") ) {
            resultCook=cookie;
            resultCook.setMaxAge(0);
            response.addCookie(resultCook);
          
           }
         }
      }
      request.getSession().invalidate();
      ProductHandler productHandler=new ProductHandler();
      request.setAttribute("productlist", productHandler.getAllDistributorProducts(123456L, request));
      request.setAttribute("isguestuser", true);
      JsonObject dummyObject=new JsonObject();
      request.setAttribute("consumerobject", dummyObject.toString());
    }catch(Exception e){
      e.printStackTrace();
    }
    return "productmain";
  }
 
  @RequestMapping(value="/testdbconnection", method=RequestMethod.POST )
  public @ResponseBody String byConsumes(@RequestBody DatabaseInstanceEntity databaseInstanceEntity, HttpServletResponse response) throws PropertyVetoException, SQLException {
    System.out.println("=================>>>"+databaseInstanceEntity.getInstanceDbName());
    //databaseInstanceEntity.getInstanceConnectionType Cons
    JsonObject jsonObject=null;
    boolean result=false;
    if(databaseInstanceEntity.getInstanceConnectionType().equals(Constants.oracleDriver)){
      String dbUrl=Constants.oracleJDBCUrl+
          databaseInstanceEntity.getInstanceHost()+":"+
          databaseInstanceEntity.getInstancePort()+":"+
          databaseInstanceEntity.getInstanceDbName();
      ComboPooledDataSource dataSource=new ComboPooledDataSource();
      dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
      dataSource.setJdbcUrl("jdbc\\:oracle\\:thin\\:@127.0.0.1\\:1521\\:XE");
      dataSource.setUser("virran");
      dataSource.setPassword("virran");
      dataSource.setMaxPoolSize(2);
      dataSource.setMinPoolSize(1);
      dataSource.setInitialPoolSize(1);
      Connection con= dataSource.getConnection();
      System.out.println(con);
     // result=   DbUtills.isConnectionAvailable(dbUrl, databaseInstanceEntity.getInstanceDbUserName(), databaseInstanceEntity.getInstanceDbPassword(),Constants.oracleDriver);
    }else if(databaseInstanceEntity.getInstanceConnectionType().equals(Constants.postgresSQLDriver)){
      String dbUrl=Constants.postgresSQLJDBCUrl+
          databaseInstanceEntity.getInstanceHost()+":"+
          databaseInstanceEntity.getInstancePort()+"/"+
          databaseInstanceEntity.getInstanceDbName();
      result=DbUtills.isConnectionAvailable(dbUrl, databaseInstanceEntity.getInstanceDbUserName(), databaseInstanceEntity.getInstanceDbPassword(),Constants.postgresSQLDriver);
    }else if(databaseInstanceEntity.getInstanceConnectionType().equals(Constants.mySqlDriver)){
      String dbUrl=Constants.mySQLJDBCUrl+
          databaseInstanceEntity.getInstanceHost()+":"+
          databaseInstanceEntity.getInstancePort()+":"+
          databaseInstanceEntity.getInstanceDbName();
      result= DbUtills.isConnectionAvailable(dbUrl, databaseInstanceEntity.getInstanceDbUserName(), databaseInstanceEntity.getInstanceDbPassword(),Constants.mySqlDriver);
    }
    if(result){
      jsonObject=new JsonObject();
      jsonObject.addProperty("connection", "success");
    }else{
      jsonObject=new JsonObject();
      jsonObject.addProperty("connection", "failled");
    }
      return jsonObject.toString();
  }
}
