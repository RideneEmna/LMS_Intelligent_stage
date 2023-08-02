package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.users;

import jakarta.servlet.http.HttpSession;

@RestController
public class AuthenticationController {

    @Autowired
    private HttpSession session; // Autowire HttpSession

    @GetMapping("/checkAuthentication")
    public ResponseEntity<Map<String, Object>> checkAuthenticationStatus() {
        Map<String, Object> response = new HashMap<>();
        
        // Check if the "authenticatedUser" attribute is set in the session, indicating the user is authenticated
        users authenticatedUser = (users) session.getAttribute("authenticatedUser");
        if (authenticatedUser != null) {
            response.put("authenticated", true);
            response.put("username", authenticatedUser.getUsername());
        } else {
            response.put("authenticated", false);
        }
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        // Invalidate the session to log out the user
        session.invalidate();
        return ResponseEntity.ok("Logout successful.");
    }
}

