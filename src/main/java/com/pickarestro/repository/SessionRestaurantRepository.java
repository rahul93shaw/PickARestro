package com.pickarestro.repository;

import com.pickarestro.dao.SessionRestaurantEntity;
import com.pickarestro.dao.SessionRestaurantId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRestaurantRepository extends JpaRepository<SessionRestaurantEntity, SessionRestaurantId> {

    List<SessionRestaurantEntity> findAllBySessionId(Long sessionId);
}

