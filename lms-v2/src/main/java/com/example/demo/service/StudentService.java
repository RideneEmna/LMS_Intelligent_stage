package com.example.demo.service;

import com.example.demo.model.student;
import com.example.demo.repository.studentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final studentRepository studentRepository;

    public StudentService(com.example.demo.repository.studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public student addStudent(student student) {
        return studentRepository.save(student);
    }

    public student updateStudent(Long id, student studentDetails) {
        Optional<student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            student student = optionalStudent.get();
            student.setFirstname(studentDetails.getFirstname());
            student.setLastname(studentDetails.getLastname());
            student.setStudyLevel(studentDetails.getStudyLevel());
            student.setEmail(studentDetails.getEmail());
            student.setPassword(studentDetails.getPassword());
            student.setUsername(studentDetails.getUsername());
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
