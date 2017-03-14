package com.virrantech.entity;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")

@Entity
public class DistributorEntity {
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key  id;
  @Persistent
  private long distributorId;
  @Persistent
  private String distributorUserName;
  @Persistent
  private String distributorFullName;
  @Persistent
  private String distributorEmailId;
  @Persistent
  private String distributorPassword;
  @Persistent
  private String distributorPhoneNumber;
  @Persistent
  private String deviceApiLevel;
  @Persistent
  private String deviceName;
  @Persistent
  private String deviceModel;
  @Persistent
  private String deviceBrandName;
  @Persistent
  private String deviceId;
  @Persistent
  private String isDefaultDistributor;
  @Persistent
  private String diviceOSVersion;
  @Persistent(mappedBy = "distributorEntity",defaultFetchGroup="true",loadFetchGroup="true")
  @OneToMany(mappedBy = "distributorEntity", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
  @Element(dependent = "true")
  //private ConsumerAddress consumerAddress;
  private List<DistributorServiceLocation> distributorServiceLocationList = new ArrayList<DistributorServiceLocation>();
   
  
}
