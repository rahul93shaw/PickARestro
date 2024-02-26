package com.pickarestro.service;

import com.pickarestro.dao.UserEntity;
import com.pickarestro.dto.UserDto;
import com.pickarestro.exception.ResourceNotFoundException;
import com.pickarestro.exception.UserAuthenticationException;
import com.pickarestro.mapper.UserMapper;
import com.pickarestro.repository.UserRepository;
import com.pickarestro.util.Cypher;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	
	private static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDto login(UserDto loginUser) {
        log.info("login - {}", loginUser.getUsername());
        return userMapper.map(userRepository.findByUsernameAndPasswordHash(loginUser.getUsername(), Cypher.encrypt(loginUser.getPassword()))
                .orElseThrow(() -> new UserAuthenticationException("Username or password is incorrect")));
    }


    public UserDto signUp(UserDto signUpUser) {
        var user = new UserEntity();
        user.setName(signUpUser.getName());
        user.setUsername(signUpUser.getUsername());
        user.setPasswordHash(Cypher.encrypt(signUpUser.getPassword()));
        return userMapper.map(userRepository.save(user));
    }

    public UserDto getById(Long userId) {
        return userMapper.map(userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found")));
    }

    public List<UserDto> getAllUsers() {
        return userMapper.map(userRepository.findAll());
    }

    public List<UserDto> getAllUsers(List<Long> ids) {
        return userMapper.map(userRepository.findByIdIn(ids));
    }
}
