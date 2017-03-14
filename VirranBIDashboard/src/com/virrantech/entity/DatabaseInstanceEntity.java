package com.virrantech.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.virrantech.utills.RandomNumStringGenerator;

@Entity
public class DatabaseInstanceEntity implements Serializable {

  /**
   * 
   */
  public DatabaseInstanceEntity(){
    this.instanceId=RandomNumStringGenerator.getRandomNumer();
  }
  private static final long serialVersionUID = 1L;
  
  @Id
  private Integer instanceId;
  private Integer instanceCrationUserId;
  private String instanceName;
  private String instanceConnectionType;
  private String instanceDbName;
  private String instanceHost;
  private Integer instancePort;
  private String instanceDbUserName;
  private String instanceDbPassword;
  private Date instanceCreateDateTime;
  /**
   * @return the instanceId
   */
  public Integer getInstanceId() {
    return instanceId;
  }
  /**
   * @param instanceId the instanceId to set
   */
  public void setInstanceId(Integer instanceId) {
    this.instanceId = instanceId;
  }
  /**
   * @return the instanceCrationUserId
   */
  public Integer getInstanceCrationUserId() {
    return instanceCrationUserId;
  }
  /**
   * @param instanceCrationUserId the instanceCrationUserId to set
   */
  public void setInstanceCrationUserId(Integer instanceCrationUserId) {
    this.instanceCrationUserId = instanceCrationUserId;
  }
  /**
   * @return the instanceName
   */
  public String getInstanceName() {
    return instanceName;
  }
  /**
   * @param instanceName the instanceName to set
   */
  public void setInstanceName(String instanceName) {
    this.instanceName = instanceName;
  }
  /**
   * @return the instanceConnectionType
   */
  public String getInstanceConnectionType() {
    return instanceConnectionType;
  }
  /**
   * @param instanceConnectionType the instanceConnectionType to set
   */
  public void setInstanceConnectionType(String instanceConnectionType) {
    this.instanceConnectionType = instanceConnectionType;
  }
  /**
   * @return the instanceDbName
   */
  public String getInstanceDbName() {
    return instanceDbName;
  }
  /**
   * @param instanceDbName the instanceDbName to set
   */
  public void setInstanceDbName(String instanceDbName) {
    this.instanceDbName = instanceDbName;
  }
  /**
   * @return the instanceHost
   */
  public String getInstanceHost() {
    return instanceHost;
  }
  /**
   * @param instanceHost the instanceHost to set
   */
  public void setInstanceHost(String instanceHost) {
    this.instanceHost = instanceHost;
  }
  /**
   * @return the instancePort
   */
  public Integer getInstancePort() {
    return instancePort;
  }
  /**
   * @param instancePort the instancePort to set
   */
  public void setInstancePort(Integer instancePort) {
    this.instancePort = instancePort;
  }
  /**
   * @return the instanceDbUserName
   */
  public String getInstanceDbUserName() {
    return instanceDbUserName;
  }
  /**
   * @param instanceDbUserName the instanceDbUserName to set
   */
  public void setInstanceDbUserName(String instanceDbUserName) {
    this.instanceDbUserName = instanceDbUserName;
  }
  /**
   * @return the instanceDbPassword
   */
  public String getInstanceDbPassword() {
    return instanceDbPassword;
  }
  /**
   * @param instanceDbPassword the instanceDbPassword to set
   */
  public void setInstanceDbPassword(String instanceDbPassword) {
    this.instanceDbPassword = instanceDbPassword;
  }
  /**
   * @return the instanceCreateDateTime
   */
  public Date getInstanceCreateDateTime() {
    return instanceCreateDateTime;
  }
  /**
   * @param instanceCreateDateTime the instanceCreateDateTime to set
   */
  public void setInstanceCreateDateTime(Date instanceCreateDateTime) {
    this.instanceCreateDateTime = instanceCreateDateTime;
  }

}
