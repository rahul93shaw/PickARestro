package com.pickarestro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickarestro.model.PickrestroSession;

public interface PickrestroSessionRepository extends JpaRepository<PickrestroSession, Long> {

}
