package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.courses;
import com.example.demo.service.CourseService;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	private final ResourceLoader resourceLoader;
    private final CourseService courseService;
    
    
    @Autowired
    public CourseController(CourseService courseService,ResourceLoader resourceLoader) {
        this.courseService = courseService;
        this.resourceLoader = resourceLoader;
    }
   

    @GetMapping()
    public void getCoursesPage(HttpServletResponse response) throws IOException {
        // Set the content type of the response to "text/html"
        response.setContentType("text/html");

        // Load the HTML file from the static folder
        Resource resource = resourceLoader.getResource("classpath:static/courses.html");
        try (InputStream inputStream = resource.getInputStream()) {
            // Write the contents of the HTML file to the response
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                response.getOutputStream().write(buffer, 0, bytesRead);
            }
        }
    }

    @GetMapping("/all")
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
    
    

    @PostMapping
    public ResponseEntity<courses> createCourse(@RequestBody courses course) {
        courses createdCourse = courseService.addCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<courses> updateCourse(@PathVariable Long id, @RequestBody courses course) {
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
