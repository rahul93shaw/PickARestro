package com.pickarestro.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * CREATE TABLE `pickarestro`.`TB_PICK_RESTRO_SESSION` (
  `ID_TB_PICK_RESTRO_SESSION` INT NOT NULL,
  `ID_TB_SESSION` INT NOT NULL,
  `ID_TB_USER` INT NOT NULL,
  `ID_TB_RESTAURANT` INT NOT NULL,
  `USER_STATUS` VARCHAR(10) NOT NULL,
  `IS_REST_SELECTED` VARCHAR(5) NOT NULL,
  `CREATED_BY` VARCHAR(20) NOT NULL,
  `CREATED_DATETIME` DATETIME NOT NULL,
  `UPDATED_BY` VARCHAR(20) NULL,
  `UPDATED_DATETIME` DATETIME NULL,
  PRIMARY KEY (`ID_TB_PICK_RESTRO_SESSION`));
  */

@Entity
@Table(name = "TB_PICK_RESTRO_SESSION")
public class PickrestroSession {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TB_PICK_RESTRO_SESSION")
    private Long pickrestroSessionId;
    
    @Column(name = "ID_TB_SESSION")
	private Long sessionId;
    
    @Column(name = "ID_TB_USER")
    private Long userId;
    
    @Column(name = "ID_TB_RESTAURANT")
    private Long restaurantId;
    
    @Column(name = "USER_STATUS")
	private String userStatus;
    
    @Column(name = "IS_REST_SELECTED")
    private String isRestSelected;
    
    @Column(name ="CREATED_DATETIME")
	private Date createdDatetime;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "UPDATED_DATETIME")
	private Date updatedDatetime;
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;

	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = new Date();
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDatetime() {
		return updatedDatetime;
	}

	public void setUpdatedDatetime(Date updatedDatetime) {
		this.updatedDatetime = new Date();
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Long getPickrestroSessionId() {
		return pickrestroSessionId;
	}

	public void setPickrestroSessionId(Long pickrestroSessionId) {
		this.pickrestroSessionId = pickrestroSessionId;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getIsRestSelected() {
		return isRestSelected;
	}

	public void setIsRestSelected(String isRestSelected) {
		this.isRestSelected = isRestSelected;
	}

	

}
