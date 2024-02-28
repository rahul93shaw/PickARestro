package com.pickarestro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pickarestro.dto.LoginDto;
import com.pickarestro.dto.UserDto;
import com.pickarestro.model.User;
import com.pickarestro.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(LoginDto loginUser) {
		try {
			User user = userRepository.findByUsername(loginUser.getUsername());
			
			if(!Objects.isNull(user)) {
				LOGGER.info("UserServiceImpl | user:: " + user.toString());
				if(!user.getName().equalsIgnoreCase(loginUser.getName())) {
					user.setUserId(0L);
				}
				return user;
			} else {
				user = new User();
				user.setName(loginUser.getName());
				user.setUsername(loginUser.getUsername());
				user.setPassword(loginUser.getPassword());
				user.setCreatedBy(loginUser.getUsername());
				user.setCreatedDatetime(new Date());
				LOGGER.info("UserServiceImpl | user:: " + user.toString());
				return userRepository.save(user);
			}
		} catch(Exception e) {
			LOGGER.error("UserServiceImpl | login | error: " + e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<UserDto> retrieveUsersList(String excUsername) {
		List<User> users = userRepository.findAll();
		if(!Objects.isNull(users)) {
			List<UserDto> userDtos = new ArrayList<>();
			users.forEach(us -> {
				if(!us.getUsername().equalsIgnoreCase(excUsername)) {
					UserDto userDto = new UserDto();
					userDto.setName(us.getName());
					userDto.setUsername(us.getUsername());
					userDtos.add(userDto);
				}
			});
			return userDtos;
		} else {
			return null;
		}
	}

}
