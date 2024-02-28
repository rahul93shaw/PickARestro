package com.pickarestro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickarestro.dto.RestaurantDto;
import com.pickarestro.dto.SessionDto;
import com.pickarestro.dto.UserDto;
import com.pickarestro.service.PickARestroMainService;
import com.pickarestro.service.RestaurantService;
import com.pickarestro.service.SessionService;
import com.pickarestro.service.UserService;
import com.pickarestro.util.ResponseBody;

@RestController
@RequestMapping("/main")
public class PickARestroMainController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PickARestroMainController.class);
	
	@Autowired
    private RestaurantService restaurantService;
	
	@Autowired
    private SessionService sessionService;
	
	@Autowired
	private PickARestroMainService pickARestroMainService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createSession")
	public ResponseEntity<Object> createSession(@RequestBody SessionDto sessionDto) {
		//Long sessionId = pickARestroMainService.
		ResponseBody result = new ResponseBody();
		try {
			
			sessionDto = sessionService.createSession(sessionDto);
			result.setMessage("");
			result.setStatus("success");
			result.setBody(sessionDto);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch(Exception e) {
			result.setMessage("");
			result.setStatus("failure");
			result.setBody(null);
			LOGGER.error("error at PickARestroMainController | createSession :" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
	}
	
	
	@GetMapping("/restaurants")
	public ResponseEntity<Object> retrieveRestaurantList() {
		ResponseBody result = new ResponseBody();
		try {
			List<RestaurantDto> restaurantDtos = restaurantService.retrieveRestaurantList();
			result.setMessage("");
			result.setStatus("success");
			result.setBody(restaurantDtos);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch(Exception e) {
			result.setMessage("");
			result.setStatus("failure");
			result.setBody(null);
			LOGGER.error("error at PickARestroMainController | retrieveRestaurantList :" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
	}
	
	@GetMapping("/users")
	public ResponseEntity<Object> retrieveUsersList(@RequestParam("username") String username) {
		ResponseBody result = new ResponseBody();
		try {
			List<UserDto> userDtos = userService.retrieveUsersList(username);
			result.setMessage("");
			result.setStatus("success");
			result.setBody(userDtos);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch(Exception e) {
			result.setMessage("");
			result.setStatus("failure");
			result.setBody(null);
			LOGGER.error("error at PickARestroMainController | retrieveUsersList :" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
	}
	
	@GetMapping("/activeSessionByUser")
	public ResponseEntity<Object> activeSessionByUser(@RequestParam("username") String username) {
		ResponseBody result = new ResponseBody();
		try {
			
			List<SessionDto> sessionDtos = sessionService.allActiveSessionsByUser(username);
			result.setMessage("");
			result.setStatus("success");
			result.setBody(sessionDtos);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch(Exception e) {
			result.setMessage("");
			result.setStatus("failure");
			result.setBody(null);
			LOGGER.error("error at PickARestroMainController | sessionDtos :" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
	}


}
