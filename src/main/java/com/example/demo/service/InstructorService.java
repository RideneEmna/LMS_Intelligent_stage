package com.example.demo.service;

import com.example.demo.model.instructor;
import com.example.demo.repository.instructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private final instructorRepository instructorRepository;

    @Autowired
    public InstructorService(instructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<instructor> getInstructorById(Long id) {
        return instructorRepository.findById(id);
    }

    public instructor addInstructor(instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public instructor updateInstructor(Long id, instructor instructorDetails) {
        Optional<instructor> optionalInstructor = instructorRepository.findById(id);
        if (optionalInstructor.isPresent()) {
            instructor instructor = optionalInstructor.get();
            instructor.setName(instructorDetails.getName());
            instructor.setSurname(instructorDetails.getSurname());
            instructor.setSpeciality(instructorDetails.getSpeciality());
            instructor.setEmail(instructorDetails.getEmail());
            instructor.setPassword(instructorDetails.getPassword());
            instructor.setUsername(instructorDetails.getUsername());
            return instructorRepository.save(instructor);
        }
        return null;
    }

    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }


}
