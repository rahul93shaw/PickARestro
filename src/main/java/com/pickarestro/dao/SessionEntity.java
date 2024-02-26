package com.pickarestro.dao;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sessions")
@SQLDelete(sql = "UPDATE sessions SET deleted = true WHERE id = ?")
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    private String description;
    private LocalDateTime startsAt;
    @Column(name = "initiated_by")
    private Long initiatedByUserId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "initiated_by", nullable = false, insertable = false, updatable = false)
    private UserEntity initiatedBy;
    private Long pickedRestaurantId;
    private boolean active;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

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

	public UserEntity getInitiatedBy() {
		return initiatedBy;
	}

	public void setInitiatedBy(UserEntity initiatedBy) {
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
