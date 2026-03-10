package com.breakdown.user_service.service;

import com.breakdown.user_service.entity.UserEntity;
import com.breakdown.user_service.exception.BadRequestException;
import com.breakdown.user_service.exception.ResourceNotFoundException;
import com.breakdown.user_service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity register(UserEntity user) {

        if (user == null) {
            throw new BadRequestException("User details cannot be empty");
        }

        return userRepo.save(user);
    }

    public String login(String email, String password) {

        UserEntity userEntity = userRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email " + email));

        if (!userEntity.getPassword().equals(password)) {
            throw new BadRequestException("Invalid password");
        }

        return "Login Successful";
    }

    public List<UserEntity> getAllusers() {

        List<UserEntity> users = userRepo.findAll();

        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users found");
        }

        return users;
    }
}