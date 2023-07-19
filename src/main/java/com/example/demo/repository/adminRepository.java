package com.example.demo.repository;

import com.example.demo.model.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface adminRepository extends JpaRepository<admin, Long> {
}
