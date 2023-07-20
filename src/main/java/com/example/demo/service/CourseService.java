package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.instructor;
import com.example.demo.model.student;
import com.example.demo.repository.instructorRepository;
import com.example.demo.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.courses;
import com.example.demo.repository.courseRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final courseRepository courseRepository;
    private final instructorRepository instructorRepository;
    private final studentRepository studentRepository;
    @Autowired
    public CourseService(courseRepository courseRepository, instructorRepository instructorRepository, studentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.studentRepository = studentRepository;
    }

    public List<courses> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<courses> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public courses addCourse(Long studentId, Long instructorId, courses course) throws ResourceNotFoundException {
        student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found!"));
        instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new ResourceNotFoundException("Instructor not found!"));
        if (student!=null && instructor!=null)
        {
            course.setInstructor(instructor);
            course.setStudent(student);
        }
        return courseRepository.save(course);
    }

    public courses updateCourse(Long id, courses courseDetails) throws ResourceNotFoundException {
        courses course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + id));
        student student = studentRepository.findById(courseDetails.getStudent().getIdStudent()).orElseThrow( () -> new ResourceNotFoundException("Student not found!"));
        instructor instructor = instructorRepository.findById(courseDetails.getInstructor().getIdInstructor()).orElseThrow(() -> new ResourceNotFoundException("Instructor not found!"));


        //student= new student(courseDetails.getStudent().getUsername(), courseDetails.getStudent().getEmail(), courseDetails.getStudent().getPassword(), courseDetails.getStudent().getName(), courseDetails.getStudent().getSurname(), courseDetails.getStudent().getStudyLevel());
        //studentRepository.save(student);
        //instructor= new instructor(courseDetails.getInstructor().getUsername(), courseDetails.getInstructor().getEmail(), courseDetails.getInstructor().getPassword(), courseDetails.getInstructor().getName(), courseDetails.getInstructor().getSurname(), courseDetails.getInstructor().getSpeciality());
        //instructorRepository.save(instructor);
        course.setTitre(courseDetails.getTitre());
        course.setDescription(courseDetails.getDescription());
        course.setAuteur(courseDetails.getAuteur());
        course.setMatiere(courseDetails.getMatiere());
        course.setDateAjout(courseDetails.getDateAjout());
        course.setNbHeures(courseDetails.getNbHeures());
        course.setStudent(student);
        course.setInstructor(instructor);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
