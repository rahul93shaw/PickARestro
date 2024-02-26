package com.pickarestro.controller;

import com.pickarestro.dto.UserDto;
import com.pickarestro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserDto login(@RequestBody UserDto loginUser) {
        return userService.login(loginUser);
    }

    @PostMapping("/sign-up")
    public UserDto signUp(@RequestBody UserDto loginUser) {
        return userService.signUp(loginUser);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
