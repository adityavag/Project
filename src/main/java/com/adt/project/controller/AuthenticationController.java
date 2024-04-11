package com.adt.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adt.project.model.User;
import com.adt.project.repository.UserRepository;
import com.adt.project.service.EmailService;

@RestController
public class AuthenticationController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmailService emailService;

    @PostMapping("/signup")
    public String register(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return "This username is already taken. Please choose a different username.";
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            return "This email is already registered. Please login or reset your password.";
        }
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        try {
            userRepository.save(newUser);
            emailService.sendEmail(user.getEmail(), user.getUsername());
            return "Registered !";
        } catch (Exception e) {
            return "We encountered an error processing your request. Please try again later or contact us for assistance.";
        }
    }

}
