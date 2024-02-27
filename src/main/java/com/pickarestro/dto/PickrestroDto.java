package com.pickarestro.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PickrestroDto extends BaseDto {
	
    private Long pickrestroSessionId;
    
	private Long sessionId;
    
    private Long userId;
    
    private Long restaurantId;
    
	private String userStatus;
    
    private String isRestSelected;

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
