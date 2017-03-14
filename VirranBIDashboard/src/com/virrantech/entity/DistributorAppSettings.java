package com.virrantech.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;
import com.virrantech.utills.Constants;
import com.virrantech.utills.DateUtilities;
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
@Entity
public class DistributorAppSettings {
  
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key  id;
  @Persistent
  private long distributorId;
  @Persistent
  private String appshopLocation;
  @Persistent
  private String appshopLocationLat;
  @Persistent
  private String appshopLocationLang;
  @Persistent
  private String shopDistrict;
  @Persistent
  private String shopPostalCode;
  @Persistent
  private String shopState;
  @Persistent
  private String shopCountryCode;
  @Persistent
  private String shopSubArea;
  @Persistent
  private String shopPremises;
  @Persistent
  private String appServiceStatus=Constants.DISTRIBUTOR_SERCICE_RUNNING; // RUNNING or STOPPED
  @Persistent
  private String appServiceStartedDate=DateUtilities.getCurrentDateAsString(DateUtilities.YYYY_MM_DD_24HH_MM_SS);
  @Persistent
  private String appServiceStoppedDate;
  
  
  
  
  

}
