package com.example.demo.controller;

import com.example.demo.model.instructor;
import com.example.demo.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<List<instructor>> getAllInstructors() {
        List<instructor> instructors = instructorService.getAllInstructors();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<instructor> getInstructorById(@PathVariable Long id) {
        Optional<instructor> instructor = instructorService.getInstructorById(id);
        return instructor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<instructor> createInstructor(@RequestBody instructor instructor) {
        instructor createdInstructor = instructorService.addInstructor(instructor);
        return new ResponseEntity<>(createdInstructor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<instructor> updateInstructor(@PathVariable Long id, @RequestBody instructor instructor) {
        instructor updatedInstructor = instructorService.updateInstructor(id, instructor);
        if (updatedInstructor != null) {
            return new ResponseEntity<>(updatedInstructor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
