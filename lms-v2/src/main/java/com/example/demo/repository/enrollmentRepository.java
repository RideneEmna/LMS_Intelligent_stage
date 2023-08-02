package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Enrollment;
import com.example.demo.model.courses;
import com.example.demo.model.users;

@Repository
public interface enrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByUserAndCourse(users user, courses course);
    List<Enrollment> findByUserId(long userId);
}
