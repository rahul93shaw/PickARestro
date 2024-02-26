package com.pickarestro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionDto {
    private Long id;
    private String name;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime startsAt;
    private Long initiatedByUserId;
    private UserDto initiatedBy;
    private Long pickedRestaurantId;
    private boolean active;
    private List<SessionUserDto> sessionUsers;
    private List<SessionRestaurantDto> sessionRestaurant;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getStartsAt() {
		return startsAt;
	}
	public void setStartsAt(LocalDateTime startsAt) {
		this.startsAt = startsAt;
	}
	public Long getInitiatedByUserId() {
		return initiatedByUserId;
	}
	public void setInitiatedByUserId(Long initiatedByUserId) {
		this.initiatedByUserId = initiatedByUserId;
	}
	public UserDto getInitiatedBy() {
		return initiatedBy;
	}
	public void setInitiatedBy(UserDto initiatedBy) {
		this.initiatedBy = initiatedBy;
	}
	public Long getPickedRestaurantId() {
		return pickedRestaurantId;
	}
	public void setPickedRestaurantId(Long pickedRestaurantId) {
		this.pickedRestaurantId = pickedRestaurantId;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<SessionUserDto> getSessionUsers() {
		return sessionUsers;
	}
	public void setSessionUsers(List<SessionUserDto> sessionUsers) {
		this.sessionUsers = sessionUsers;
	}
	public List<SessionRestaurantDto> getSessionRestaurant() {
		return sessionRestaurant;
	}
	public void setSessionRestaurant(List<SessionRestaurantDto> sessionRestaurant) {
		this.sessionRestaurant = sessionRestaurant;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
