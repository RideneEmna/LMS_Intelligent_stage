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
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody users loginUser) {
        // Find the user by username or email
       users user = userRepository.findByUsernameOrEmail(loginUser.getUsername(), loginUser.getUsername());

        // Check if the user exists
        if (user == null) {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }

        // Validate the password (without encryption, in this example)
        if (!user.getPassword().equals(loginUser.getPassword())) {
            return new ResponseEntity<>("Invalid password.", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>("Login successful.", HttpStatus.OK);
    }
}

