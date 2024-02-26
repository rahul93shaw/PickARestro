package com.pickarestro.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class SessionRestaurantId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "session_id")
    private Long sessionId;

	@Column(name = "restaurant_id")
    private Long restaurantId;
	
	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

}