package com.virrantech.utills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtills {

  
  public static boolean isConnectionAvailable(String DB_URL,String USER,String PASS,String driver) {
    Connection conn = null; 
    boolean isConnectionLive=false;
    try {    
      Class.forName(driver);    
      System.out.println("Connecting to database...");    
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      System.out.println(conn.getMetaData().getDatabaseProductName());
     // conn.getMetaData().get
      isConnectionLive= conn.isValid(0);
    } catch (SQLException  e) {
    
      e.printStackTrace();    
    } catch (Exception e) {
    
      e.printStackTrace();    
    }
    
    finally {    
      if (conn != null) {    
        try {    
          conn.close();    
        } catch (SQLException e) {    
          // ignore    
        }  
  }
      
}
   return isConnectionLive;
  }
  }
