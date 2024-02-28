package com.pickarestro.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionDto {
	
    private Long sessionId;
    
    private String sessionType;
    
    private String sessionDesc;
    
    private Date endDatetime;
    
    private Date startDatetime;
    
    private String host;

	public Date getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(Date startDatetime) {
		this.startDatetime = startDatetime;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
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

	@Override
	public String toString() {
		return "SessionDto [sessionId=" + sessionId + ", sessionType=" + sessionType + ", sessionDesc=" + sessionDesc
				+ ", endDatetime=" + endDatetime + ", startDatetime=" + startDatetime + ", host=" + host + "]";
	}
	
	

}
