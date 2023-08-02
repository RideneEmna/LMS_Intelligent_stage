package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.users;
import com.example.demo.repository.UserRepository;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody users user) {
        // Check if username or email already exists in the database
        if (userRepository.existsByUsername(user.getUsername()) ||
            userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>("Username or email already exists.", HttpStatus.BAD_REQUEST);
        }

        // Encrypt the user's password before saving
        // Use a secure encryption library like bcrypt
        // For demonstration purposes, let's assume we have an encryption utility
        String encryptedPassword = encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);

        // Save the user to the database
        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully.", HttpStatus.OK);
    }

    private String encryptPassword(String password) {
        // Implement a secure encryption method, e.g., using bcrypt or Argon2
        // For demonstration purposes, this method is not implemented.
        return password;
    }
}
