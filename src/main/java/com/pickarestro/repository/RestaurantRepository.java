package com.pickarestro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pickarestro.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
