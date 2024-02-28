package com.pickarestro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickarestro.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

	List<Session> findByCreatedBy(String username);

}
