package com.pickarestro.service;

import java.util.List;

import com.pickarestro.dto.LoginDto;
import com.pickarestro.dto.UserDto;
import com.pickarestro.model.User;

public interface UserService {

	public User login(LoginDto loginUser);

	public List<UserDto> retrieveUsersList(String excUsername);


	
	
}
