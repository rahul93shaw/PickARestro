package com.pickarestro.dao;

import com.pickarestro.model.InviteStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "session_users")
public class SessionUserEntity {

    @EmbeddedId
    private SessionUserId id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false, insertable = false, updatable = false)
    private SessionEntity session;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private UserEntity user;
    @Enumerated(EnumType.STRING)
    private InviteStatus status;
    private LocalDateTime invitedAt;
    private LocalDateTime joinedAt;

    public SessionUserEntity(Long sessionId, Long userId, InviteStatus status) {
        this.id = new SessionUserId();
        this.id.setSessionId(sessionId);
        this.id.setUserId(userId);
        this.status = status;
    }

    @PrePersist
    protected void onCreate() {
        if (InviteStatus.joined.equals(status)) {
            joinedAt = LocalDateTime.now();
        } else {
            invitedAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        if (InviteStatus.joined.equals(status)) {
            joinedAt = LocalDateTime.now();
        }
    }

	public SessionUserId getId() {
		return id;
	}

	public void setId(SessionUserId id) {
		this.id = id;
	}

	public SessionEntity getSession() {
		return session;
	}

	public void setSession(SessionEntity session) {
		this.session = session;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public InviteStatus getStatus() {
		return status;
	}

	public void setStatus(InviteStatus status) {
		this.status = status;
	}

	public LocalDateTime getInvitedAt() {
		return invitedAt;
	}

	public void setInvitedAt(LocalDateTime invitedAt) {
		this.invitedAt = invitedAt;
	}

	public LocalDateTime getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(LocalDateTime joinedAt) {
		this.joinedAt = joinedAt;
	}
}
