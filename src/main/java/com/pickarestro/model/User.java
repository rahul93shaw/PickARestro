package com.pickarestro.model;

import java.util.Date;

import jakarta.persistence.*;

/*
 * CREATE TABLE `pickarestro`.`TB_USER` (
  `ID_TB_USER` INT NOT NULL,
  `USERNAME` VARCHAR(20) NOT NULL,
  `PASSWORD` VARCHAR(20) NOT NULL,
  `NAME` VARCHAR(100) NOT NULL,
  `CREATED_BY` VARCHAR(20) NOT NULL,
  `CREATED_DATETIME` DATETIME NOT NULL,
  `UPDATED_BY` VARCHAR(20) NULL,
  `UPDATED_DATETIME` DATETIME NULL,
  PRIMARY KEY (`ID_TB_USER`));
  *
  */

@Entity
@Table(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TB_USER")
    private Long userId;
    
    @Column(name = "NAME")
	private String name;
    
    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "PASSWORD")
    private String password;
    
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", createdDatetime=" + createdDatetime + ", createdBy=" + createdBy + ", updatedDatetime="
				+ updatedDatetime + ", updatedBy=" + updatedBy + "]";
	}

	
    
    
	
}
