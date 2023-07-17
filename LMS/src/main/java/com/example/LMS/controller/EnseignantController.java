package com.example.LMS.controller;

import com.example.LMS.entity.Cours;
import com.example.LMS.entity.Enseignant;
import com.example.LMS.exception.RessourceNotFoundException;
import com.example.LMS.repository.enseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController()
@RequestMapping("/api")
public class EnseignantController {
    @Autowired
    private enseignantRepository enseignantRepository;

    @GetMapping("/enseignant")
    public List<Enseignant> getAllEnseignants() {
        return this.enseignantRepository.findAll();
    }

    @GetMapping("/enseignant/{id}")
    public Enseignant getEnseignantById(@PathVariable(value = "id") Long idEnseignant) throws RessourceNotFoundException {
        return this.enseignantRepository.findById(idEnseignant).orElseThrow(() -> new RessourceNotFoundException("Enseignant non trouvé par cet ID: " + idEnseignant));
    }

    @PostMapping("/enseignant")
    public Enseignant addEnseignant(@RequestBody Enseignant e) {
        return this.enseignantRepository.save(e);
    }

    @DeleteMapping("/enseignant/{id}")
    public void deleteEnseignant(@PathVariable(value = "id") Long idEnseignant) throws RessourceNotFoundException {
        Enseignant e = enseignantRepository.findById(idEnseignant).orElseThrow(() -> new RessourceNotFoundException("Enseignant non trouvé par cet ID: " + idEnseignant));
        enseignantRepository.deleteById(idEnseignant);
    }

    @PutMapping("/enseignant/{id}")
    public ResponseEntity<Enseignant> updateEnseignant(@PathVariable(value="id") Long idEnseignant, @RequestBody Enseignant EnseignantDetails) throws RessourceNotFoundException{
        Enseignant e = enseignantRepository.findById(idEnseignant).orElseThrow(() -> new RessourceNotFoundException("Enseignant non trouvé par cet ID:" + idEnseignant));
        e.setLogin(EnseignantDetails.getLogin());
        e.setMdp(EnseignantDetails.getMdp());
        e.setEmail(EnseignantDetails.getEmail());
        e.setTelephone(EnseignantDetails.getTelephone());
        e.setSpecialite(EnseignantDetails.getSpecialite());

        final Enseignant updateEnseignant=enseignantRepository.save(e);
        return ResponseEntity.ok(updateEnseignant);
    }

}
