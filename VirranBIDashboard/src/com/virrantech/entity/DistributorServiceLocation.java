package com.virrantech.entity;

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
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
@Entity
public class DistributorServiceLocation {
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Key id;
  @Persistent
  private long distributorId;
  @Persistent
  private String serviceLocationName;
  @Persistent
  private String serviceLocationLat;
  @Persistent
  private String serviceLocationLang;
  @Persistent
  private String  serviceDistrict;
  @Persistent
  private String servicePostalCode;
  @Persistent
  private String serviceState;
  @Persistent
  private String serviceCountryCode;
  @Persistent
  private String serviceSubArea;
  @Persistent
  private String servicePremises;
  @Persistent
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private DistributorEntity distributorEntity;
  
}
