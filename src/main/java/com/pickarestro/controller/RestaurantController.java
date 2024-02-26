package com.pickarestro.controller;

import com.pickarestro.dto.RestaurantDto;
import com.pickarestro.dto.SessionRestaurantDto;
import com.pickarestro.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/all")
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public RestaurantDto getRestaurant(@PathVariable Long id) {
        return restaurantService.getRestaurant(id);
    }

    @PutMapping("/submit/{sessionId}")
    public SessionRestaurantDto addRestaurantToSession(@PathVariable Long sessionId, @RequestBody RestaurantDto restaurantDto, @RequestParam Long requesterId) {
        return restaurantService.addRestaurantToSession(sessionId, restaurantDto, requesterId);
    }
}
