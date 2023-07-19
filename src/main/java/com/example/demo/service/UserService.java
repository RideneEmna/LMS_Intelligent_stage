package com.example.demo.service;

import com.example.demo.model.admin;
import com.example.demo.model.users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<users> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public users addUser(users user) {
        return userRepository.save(user);
    }

    public users updateUser(Long id, users userDetails) {
        Optional<users> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            users user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
