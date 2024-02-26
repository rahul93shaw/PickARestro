package com.pickarestro.service;

import com.pickarestro.dao.SessionRestaurantEntity;
import com.pickarestro.dto.RestaurantDto;
import com.pickarestro.dto.SessionRestaurantDto;
import com.pickarestro.exception.InvalidRequestException;
import com.pickarestro.exception.ResourceNotFoundException;
import com.pickarestro.mapper.RestaurantMapper;
import com.pickarestro.mapper.SessionRestaurantMapper;
import com.pickarestro.model.InviteStatus;
import com.pickarestro.repository.RestaurantRepository;
import com.pickarestro.repository.SessionRestaurantRepository;
import com.pickarestro.repository.SessionUserRepository;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
	
	private static Logger log = LoggerFactory.getLogger(RestaurantService.class);

    @Autowired
    private RestaurantRepository restaurantRepo;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Autowired
    private SessionUserRepository sessionUserRepo;

    @Autowired
    private SessionRestaurantRepository sessionRestaurantRepo;

    @Autowired
    private SessionRestaurantMapper sessionRestaurantMapper;

    public List<RestaurantDto> getAllRestaurants() {
        log.info("getAllRestaurants");
        return restaurantMapper.map(restaurantRepo.findAll());
    }

    public RestaurantDto getRestaurant(Long id) {
        log.info("getRestaurant : {}", id);
        return restaurantMapper.map(restaurantRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found")));
    }

    public SessionRestaurantDto addRestaurantToSession(Long sessionId, RestaurantDto restaurantDto, Long requesterId) {
        log.info("addRestaurantToSession: sessionId {}", sessionId);
        var invite = sessionUserRepo.findBySessionIdAndUserId(sessionId, requesterId).orElseThrow(() -> new ResourceNotFoundException("User not invited for the session"));
        if (!InviteStatus.joined.equals(invite.getStatus())) {
            throw new InvalidRequestException("User not joined for the session");
        }
        var restaurant = restaurantDto.getId() == null
                ? restaurantRepo.save(restaurantMapper.mapForCreate(restaurantDto))
                : restaurantRepo.findById(restaurantDto.getId()).get();

        var sessionRestaurant = sessionRestaurantRepo.save(new SessionRestaurantEntity(sessionId, restaurant.getId(), requesterId));

        log.info("Restaurant added : {}", restaurant.getId());
        return sessionRestaurantMapper.map(sessionRestaurant);
    }
}
