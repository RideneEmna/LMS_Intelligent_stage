package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.users;

@Repository
public interface UserRepository extends JpaRepository<users, Long> {
    users findByUsernameOrEmail(String username, String email);
    users findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}