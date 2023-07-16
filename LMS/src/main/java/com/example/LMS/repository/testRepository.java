package com.example.LMS.repository;

import com.example.LMS.entity.Admin;
import com.example.LMS.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface testRepository extends JpaRepository<Test,Long> {
    Optional<Test> findById(Long idTest);

    void deleteById(Long idTest);
}
