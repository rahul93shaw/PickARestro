package com.pickarestro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickarestro.dto.RestaurantDto;
import com.pickarestro.model.Restaurant;
import com.pickarestro.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public List<RestaurantDto> retrieveRestaurantList() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		if(!Objects.isNull(restaurants) && !restaurants.isEmpty()) {
			List<RestaurantDto> restaurantDtos = new ArrayList<>();
			restaurants.forEach(res -> {
				RestaurantDto dto = new RestaurantDto();
				dto.setAddress(res.getAddress());
				dto.setName(res.getName());
				dto.setRestaurantId(res.getRestaurantId());
				restaurantDtos.add(dto);
			});
			return restaurantDtos;
		} else {
			return null;
		}
		
	}
	

}
