package com.example.LMS.repository;

import com.example.LMS.entity.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface adminRepository extends JpaRepository<Admin,Long>{
    Boolean existsByLogin(String login);
    Boolean existsByEmail(String email);

    Optional<Admin> findById(Long idAdmin);

    void deleteById(Long idAdmin);
}
