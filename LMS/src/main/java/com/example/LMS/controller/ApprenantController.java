package com.example.LMS.controller;

import com.example.LMS.entity.Admin;
import com.example.LMS.entity.Apprenant;
import com.example.LMS.exception.RessourceNotFoundException;
import com.example.LMS.repository.apprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController()
@RequestMapping("/api")
public class ApprenantController {
    @Autowired
    private apprenantRepository apprenantRepository;

    @GetMapping("/apprenant")
    public List<Apprenant> getAllApprenants() {
        return this.apprenantRepository.findAll();
    }

    @GetMapping("/apprenant/{id}")
    public Apprenant getApprenantById(@PathVariable(value = "id") Long idEtudiant) throws RessourceNotFoundException {
        return this.apprenantRepository.findById(idEtudiant).orElseThrow(() -> new RessourceNotFoundException("Apprenant non trouvé par cet ID: " + idEtudiant));
    }

    @PostMapping("/apprenant")
    public Apprenant addApprenant(@RequestBody Apprenant a) {
        return this.apprenantRepository.save(a);
    }

    @DeleteMapping("/apprenant/{id}")
    public void deleteApprenant(@PathVariable(value = "id") Long idEtudiant) throws RessourceNotFoundException {
        Apprenant a = apprenantRepository.findById(idEtudiant).orElseThrow(() -> new RessourceNotFoundException("Apprenant non trouvé par cet ID: " + idEtudiant));
        apprenantRepository.deleteById(idEtudiant);
    }

    @PutMapping("/apprenant/{id}")
    public ResponseEntity<Apprenant> updateApprenant(@PathVariable(value="id") Long idEtudiant, @RequestBody Apprenant ApprenantDetails) throws RessourceNotFoundException{
        Apprenant a = apprenantRepository.findById(idEtudiant).orElseThrow(() -> new RessourceNotFoundException("apprenant non trouvé par cet ID:" + idEtudiant));
        a.setLogin(ApprenantDetails.getLogin());
        a.setEmail(ApprenantDetails.getEmail());
        a.setMdp(ApprenantDetails.getMdp());
        a.setTelephone(ApprenantDetails.getTelephone());

        final Apprenant updateApprenant=ApprenantDetails.save(a);
        return ResponseEntity.ok(updateApprenant);
    }
}