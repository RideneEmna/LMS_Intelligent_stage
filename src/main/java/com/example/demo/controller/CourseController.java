package com.example.demo.controller;



import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.courses;
import com.example.demo.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<courses>> getAllCourses() {
        List<courses> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<courses> getCourseById(@PathVariable Long id) {
        Optional<courses> course = courseService.getCourseById(id);
        return course.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{idStudent}/{idInstructor}")
    public ResponseEntity<courses> createCourse(@PathVariable Long idStudent,@PathVariable Long idInstructor,@RequestBody courses course) throws ResourceNotFoundException {
        courses createdCourse = courseService.addCourse(idStudent, idInstructor, course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<courses> updateCourse(@PathVariable Long id, @RequestBody courses course) throws ResourceNotFoundException {
    	courses updatedCourse = courseService.updateCourse(id, course);
        if (updatedCourse != null) {
            return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
