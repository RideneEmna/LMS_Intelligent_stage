package com.example.LMS.controller;

import com.example.LMS.entity.Admin;
import com.example.LMS.entity.Enseignant;
import com.example.LMS.entity.Test;
import com.example.LMS.repository.*;
import com.example.LMS.exception.RessourceNotFoundException;
import com.example.LMS.repository.testRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    private testRepository testRepository;

    @GetMapping("/test")
    public List<Test> getAllTests(){
        return testRepository.findAll();
    }

    @GetMapping("/test/{id}")
    public Test getTestById(@PathVariable(value="id") Long idTest) throws RessourceNotFoundException {
        return this.testRepository.findById(idTest).orElseThrow(() -> new RessourceNotFoundException("Test non trouvé par cet ID: " + idTest));
    }

    @PostMapping("/test")
    public Test addTest( @RequestBody Test t) {
        return this.testRepository.save(t);
    }


    @DeleteMapping("/test/{id}")
    public void deleteTest(@PathVariable(value = "id") Long idTest)throws RessourceNotFoundException {
        Test t = testRepository.findById(idTest).orElseThrow(() -> new RessourceNotFoundException("Test non trouvé par cet ID: " + idTest));
        testRepository.deleteById(idTest);
    }

    @PutMapping("/enseignant/{id}")
    public ResponseEntity<Test> updateTest(@PathVariable(value="id") Long idTest, @RequestBody Test TestDetails) throws RessourceNotFoundException{
        Test t = testRepository.findById(idTest).orElseThrow(() -> new RessourceNotFoundException("Enseignant non trouvé par cet ID:" + idTest));
        t.setDateAjout(TestDetails.getDateAjout());
        t.setMatiere(TestDetails.getMatiere());
        t.setDuree(TestDetails.getDuree());


        final Test updateTest=testRepository.save(t);
        return ResponseEntity.ok(updateTest);
    }


}
