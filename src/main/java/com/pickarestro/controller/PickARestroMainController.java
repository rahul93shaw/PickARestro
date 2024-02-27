package com.pickarestro.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickarestro.dto.RestaurantDto;
import com.pickarestro.dto.SessionDto;
import com.pickarestro.service.RestaurantService;
import com.pickarestro.service.SessionService;
import com.pickarestro.service.UserService;

@RestController
@RequestMapping("/main")
public class PickARestroMainController {
	
	@Autowired
    private RestaurantService restaurantService;
	
	@Autowired
    private SessionService sessionService;
	
//	@Autowired
//    private UserService userService;
	
	
//	@GetMapping("/all/restaurants")
//    public List<RestaurantDto> getAllRestaurants() {
//        return restaurantService.getAllRestaurants();
//    }
//
//    @GetMapping("/{id}")
//    public RestaurantDto getRestaurant(@PathVariable Long id) {
//        return restaurantService.getRestaurant(id);
//    }
//
//    @PutMapping("/submit/{sessionId}")
//    public SessionRestaurantDto addRestaurantToSession(@PathVariable Long sessionId, @RequestBody RestaurantDto restaurantDto, @RequestParam Long requesterId) {
//        return restaurantService.addRestaurantToSession(sessionId, restaurantDto, requesterId);
//    }
//    
//    @GetMapping("/all")
//    public List<SessionDto> getAllSessions() {
//        return sessionService.getAllSessions();
//    }
//
//    @GetMapping("/active")
//    public Collection<SessionDto> getActiveSessions() {
//        return sessionService.getActiveSessions();
//    }
//
//    @GetMapping("/{id}")
//    public SessionDto getSession(@PathVariable Long id) {
//        return sessionService.getSession(id);
//    }
//
//    @PostMapping
//    public SessionDto createSession(@RequestBody SessionDto req) {
//        return sessionService.createSession(req);
//    }
//
//    @PutMapping
//    public SessionDto updateSession(@RequestBody SessionDto req) {
//        return sessionService.updateSession(req);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteSession(@PathVariable Long id) {
//        sessionService.deleteSession(id);
//    }
//
//    @PutMapping("/{id}/invite")
//    public SessionDto invite(@PathVariable Long id, @RequestBody List<Long> userIds) {
//        return sessionService.invite(id, userIds);
//    }
//
//    @PutMapping("/{id}/join")
//    public SessionDto join(@PathVariable Long id, @RequestParam Long requesterId) {
//        return sessionService.join(id, requesterId);
//    }
//
//    @PutMapping("/{id}/end")
//    public SessionDto endSession(@PathVariable Long id, @RequestParam Long requesterId) {
//        return sessionService.endSession(id, requesterId);
//    }

}
