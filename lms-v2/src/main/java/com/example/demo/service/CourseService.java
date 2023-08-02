package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.courses;
import com.example.demo.repository.courseRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
	
	
    private final courseRepository courseRepository;

    @Autowired
    public CourseService(courseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<courses> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<courses> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public courses addCourse(courses course) {
        return courseRepository.save(course);
    }

    public courses updateCourse(Long id, courses courseDetails) {
        Optional<courses> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
        	courses course = optionalCourse.get();
            course.setTitle(courseDetails.getTitle());
            course.setDescription(courseDetails.getDescription());
            course.setInstructor(courseDetails.getInstructor());
            return courseRepository.save(course);
        }
        return null;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
