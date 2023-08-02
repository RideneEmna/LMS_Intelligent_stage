package com.example.demo.controller;


import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.users;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private HttpSession session; // Autowire HttpSession
    
    private final ResourceLoader resourceLoader;

    public LoginController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    
    @GetMapping("/login")
    public void login(HttpServletResponse response) throws IOException {
        // Set the content type of the response to "text/html"
        response.setContentType("text/html");

        // Load the HTML file from the static folder
        Resource resource = resourceLoader.getResource("classpath:static/login.html");
        try (InputStream inputStream = resource.getInputStream()) {
            // Write the contents of the HTML file to the response
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                response.getOutputStream().write(buffer, 0, bytesRead);
            }
        }
    }
    
    

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody users loginUser, HttpServletResponse response) throws IOException {
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
        
     // Set the authenticated user in the session
        session.setAttribute("authenticatedUser", user);

       
        return new ResponseEntity<>("Login successful.", HttpStatus.OK);
       
    }
    
    @GetMapping("/home")
    public void home(HttpServletResponse response) throws IOException {
        // Set the content type of the response to "text/html"
        response.setContentType("text/html");

        // Load the HTML file from the static folder
        Resource resource = resourceLoader.getResource("classpath:static/index.html");
        try (InputStream inputStream = resource.getInputStream()) {
            // Write the contents of the HTML file to the response
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                response.getOutputStream().write(buffer, 0, bytesRead);
            }
        }
    }
}

