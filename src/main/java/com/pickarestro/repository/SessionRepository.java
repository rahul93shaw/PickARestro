package com.pickarestro.repository;

import com.pickarestro.dao.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<SessionEntity, Long> {

    List<SessionEntity> findByActive(boolean isActive);
}
