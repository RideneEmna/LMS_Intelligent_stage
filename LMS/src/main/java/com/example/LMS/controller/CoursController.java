package com.example.LMS.controller;

import com.example.LMS.entity.Admin;
import com.example.LMS.entity.Apprenant;
import com.example.LMS.entity.Cours;
import com.example.LMS.entity.Enseignant;
import com.example.LMS.exception.RessourceNotFoundException;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.LMS.repository.coursRepository;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CoursController {

    @Autowired
    private coursRepository coursRepository;

    @GetMapping("/cours")
    public List<Cours> getAllCours(){
        return coursRepository.findAll();
    }

    @GetMapping("/cours/{id}")
    public Cours getCoursById(@PathVariable(value="id") Long idCours) throws RessourceNotFoundException {
        return this.coursRepository.findById(idCours).orElseThrow(() -> new RessourceNotFoundException("Cours non trouvé par cet ID: " + idCours));
    }
    @PostMapping("/cours")
    public Cours addCours( @RequestBody Cours c) {
        return this.coursRepository.save(c);
    }


    @DeleteMapping("/cours/{id}")
    public void deleteCours(@PathVariable(value = "id") Long idCours)throws RessourceNotFoundException {
        Cours c = coursRepository.findById(idCours).orElseThrow(() -> new RessourceNotFoundException("Cours non trouvé par cet ID: " + idCours));
        coursRepository.deleteById(idCours);
    }

    @PutMapping("/apprenant/{id}")
    public ResponseEntity<Cours> updateCours(@PathVariable(value="id") Long idCours, @RequestBody Cours CoursDetails) throws RessourceNotFoundException{
        Cours c = coursRepository.findById(idCours).orElseThrow(() -> new RessourceNotFoundException("cours non trouvé par cet ID:" + idCours));
        c.setTitre(CoursDetails.getTitre());
        c.setAuteur(CoursDetails.getAuteur());
        c.setMatiere(CoursDetails.getMatiere());
        c.setDateAjout(CoursDetails.getDateAjout());
        c.setDescription(CoursDetails.getDescription());
        c.setNbHeures(CoursDetails.getNbHeures());

        final Cours updateCours=coursRepository.save(c);
        return ResponseEntity.ok(updateCours);
    }
}
