package com.virrantech.dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.virrantech.entity.DistributorAppSettings;
import com.virrantech.entity.DistributorEntity;
import com.virrantech.entity.DistributorServiceLocation;
import com.virrantech.entity.OrderInfoEntity;

public interface DistributorDAO {
  public JsonObject saveDistributor(DistributorEntity distributorEntity);

  public DistributorEntity findDistributorById(Long distributorId);

  public DistributorEntity findDistributorByUserName(Long userName);

  public JsonObject saveDistributorServiceLocations(DistributorServiceLocation serviceLocation);

  public JsonObject saveAppSettings(DistributorAppSettings disAppSettings);

  public JsonObject saveDistributorOrder(OrderInfoEntity orderInfoEntity);

  public JsonObject updateDistributorProfile(DistributorEntity distributorEntity);
  
  public JsonArray findOrdersByStatus(Long distributorId,String status);
  
  
 /* --> find subarea

  -->locate subarea distributotors who service is Running
  -->compare the distributors lat,lang with user lat,lang
  -->Sort the distributors by distance,forward orders who close to customers

  Don't ask user to enter default distributor,Instead set the distributor based on Delivery
  Address Location*/
 
  
  
}
