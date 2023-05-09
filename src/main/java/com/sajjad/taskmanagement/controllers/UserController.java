package com.sajjad.taskmanagement.controllers;

import com.sajjad.taskmanagement.DTOs.UserDto;
import com.sajjad.taskmanagement.entities.User;
import com.sajjad.taskmanagement.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }
}
