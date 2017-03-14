package com.virrantech.utills;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.virrantech.entity.OrderInfoEntity;

public class GDataStoreUtills {
  
  public static DatastoreService datastoreService = null;
  private static GDataStoreUtills instance = null;

  public static DatastoreService getDataStoreService(){
    if(datastoreService==null)
      datastoreService= DatastoreServiceFactory.getDatastoreService();
    
    return datastoreService;
  }
  public static int getCount(String entityName){
    int count = 0;   
    try{
      Query qry=new Query(entityName);
      
      qry.setKeysOnly();
      count=getDataStoreService().prepare(qry).countEntities(FetchOptions.Builder.withDefaults());
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return count;
  }
  public static int getCountByFilter(String entityName,String filterName,long filterValue){
    int count = 0;   
    try{
      Query qry=new Query(entityName);
      qry.setFilter(new Query.FilterPredicate(filterName, FilterOperator.EQUAL, filterValue));
      //qry.setKeysOnly();
      count=getDataStoreService().prepare(qry).countEntities(FetchOptions.Builder.withDefaults());
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return count;
  }
  public static int getCountByFilter(String entityName,String filterName,String filterValue){
    int count = 0;   
    try{
      Query qry=new Query(entityName );
      qry.setFilter(new Query.FilterPredicate(filterName, FilterOperator.EQUAL, filterValue));
      qry.setKeysOnly();
      count=getDataStoreService().prepare(qry).countEntities(FetchOptions.Builder.withDefaults());
    }catch(Exception e){
      e.printStackTrace();
    }
    
    return count;
  }
  public static GDataStoreUtills getInstance() {
    if(instance == null) {
       instance = new GDataStoreUtills();
    }
    return instance;
 }
}
