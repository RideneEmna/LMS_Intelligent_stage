package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Enrollment;
import com.example.demo.repository.enrollmentRepository;
@Service
public class EnrollmentService {

    private final enrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(enrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

 /*   public void enrollUserInCourse(users user, courses course) {
        // Check if the user is already enrolled in the course
        List<Enrollment> existingEnrollments = enrollmentRepository.findByUserAndCourse(user, course);
        if (existingEnrollments.isEmpty()) {
            // If not enrolled, create a new enrollment
            Enrollment enrollment = new Enrollment();
            enrollment.setUser(user);
            enrollment.setCourse(course);
            // Set additional fields as needed
            // Save the enrollment
            enrollmentRepository.save(enrollment);
        }
    }*/
    
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id);
    }

    public Enrollment addEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollmentDetails) {
        Optional<Enrollment> optionalEnrollment = enrollmentRepository.findById(id);
        if (optionalEnrollment.isPresent()) {
            Enrollment enrollment = optionalEnrollment.get();
            // Update the enrollment details with the new values from enrollmentDetails
           // enrollment.setUser(enrollmentDetails.getUser());
           // enrollment.setCourse(enrollmentDetails.getCourse());
            enrollment.setEnrollmentDate(enrollmentDetails.getEnrollmentDate());
            enrollment.setCompleted(enrollmentDetails.isCompleted());
            enrollment.setProgress(enrollmentDetails.getProgress());
            return enrollmentRepository.save(enrollment);
        }
        return null;
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

}
