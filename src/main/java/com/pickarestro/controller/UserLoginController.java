package com.pickarestro.controller;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickarestro.dto.LoginDto;
import com.pickarestro.model.User;
import com.pickarestro.service.UserService;
import com.pickarestro.util.ResponseBody;

@RestController
@RequestMapping("/login")
public class UserLoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
    private UserService userService;
	
	@PostMapping("/")
    public ResponseEntity<Object> login(@RequestBody LoginDto loginUser) {
		try {
			
		} catch(Exception e) {
			
		}
        User user = userService.login(loginUser);
        ResponseBody result = new ResponseBody();
        if(Objects.isNull(user)) {
        	result.setStatus("failure");
        	result.setMessage("Unable to process request. Please try again later.");
        	result.setBody(null);
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        	        .body(result);
        } else if(user.getUserId().compareTo(0L) == 0) {
        	result.setStatus("failure");
        	result.setMessage("Username already exists. Please try login with different username.");
        	result.setBody(null);
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        	        .body(result);
        } else {
        	result.setStatus("success");
        	result.setMessage("");
        	result.setBody(loginUser);
        	return ResponseEntity.status(HttpStatus.OK)
        			.body(result);
        }
    }

}
