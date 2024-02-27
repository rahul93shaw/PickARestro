package com.pickarestro.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*CREATE TABLE `pickarestro`.`TB_SESSION` (
		  `ID_TB_SESSION` INT NOT NULL,
		  `SESSION_TYPE` VARCHAR(50) NOT NULL,
		  `SESSION_DESC` VARCHAR(1000) NULL,
		  `CREATED_DATETIME` DATETIME NULL,
		  `CREATED_BY` VARCHAR(20) NULL,
		  `END_DATETIME` DATETIME NULL,
		  `UPDATED_DATETIME` DATETIME NULL,
		  `UPDATED_BY` DATETIME NULL,
		  PRIMARY KEY (`ID_TB_SESSION`));
*/

@Entity
@Table(name = "TB_SESSION")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TB_SESSION")
    private Long sessionId;
    
    @Column(name = "SESSION_TYPE")
    private String sessionType;
    
    @Column(name = "SESSION_DESC")
    private String sessionDesc;
    
    @Column(name = "END_DATETIME")
    private Date endDatetime;
    
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

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionType() {
		return sessionType;
	}

	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}

	public String getSessionDesc() {
		return sessionDesc;
	}

	public void setSessionDesc(String sessionDesc) {
		this.sessionDesc = sessionDesc;
	}

	public Date getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(Date endDatetime) {
		this.endDatetime = endDatetime;
	}
    
    
}
