package com.pickarestro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickarestro.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
