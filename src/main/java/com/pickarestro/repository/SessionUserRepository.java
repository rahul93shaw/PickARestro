package com.pickarestro.repository;

import com.pickarestro.dao.SessionUserEntity;
import com.pickarestro.dao.SessionUserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionUserRepository extends JpaRepository<SessionUserEntity, SessionUserId> {
    Optional<SessionUserEntity> findBySessionIdAndUserId(Long sessionId, Long userId);

    List<SessionUserEntity> findAllBySessionId(Long sessionId);
}
