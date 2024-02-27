package com.pickarestro.service;

import com.pickarestro.dto.LoginDto;
import com.pickarestro.model.User;

public interface UserService {

	public User login(LoginDto loginUser);
	
	
}
