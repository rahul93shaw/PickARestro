package com.pickarestro.util;

public class ResponseBody {
	
	private String status;
	private String message;
	private Object body;
	public ResponseBody() {
		super();
		
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
	

}
