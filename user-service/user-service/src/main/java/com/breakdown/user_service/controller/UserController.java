package com.breakdown.user_service.controller;

import com.breakdown.user_service.entity.UserEntity;
import com.breakdown.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserEntity user) {
        return userService.login(user.getEmail(), user.getPassword());
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllusers();
    }
}

