package com.example.LMS.controller;

import com.example.LMS.exception.RessourceNotFoundException;
import com.example.LMS.repository.*;
import com.example.LMS.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins="*")
@RestController()
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private adminRepository adminRepository;

    @Autowired

    @GetMapping("/admin")
    public List<Admin> getAllAdmins(){
        return this.adminRepository.findAll();
    }

    @GetMapping("/admin/{id}")
    public Admin getAdminById(@PathVariable(value="id") Long idAdmin) throws RessourceNotFoundException {
        return this.adminRepository.findById(idAdmin).orElseThrow(() -> new RessourceNotFoundException("Admin non trouvé par cet ID: " + idAdmin));
    }

    @PostMapping("/admin")
    public Admin addAdmin (@RequestBody Admin a) {
        return this.adminRepository.save(a);
    }

    @DeleteMapping("/admin/{id}")
    public void deleteAdmin(@PathVariable(value = "id") Long idAdmin)throws RessourceNotFoundException {
        Admin a = adminRepository.findById(idAdmin).orElseThrow(() -> new RessourceNotFoundException("Admin non trouvé par cet ID: " + idAdmin));
        adminRepository.deleteById(idAdmin);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable(value="idAdmin") Long idAdmin, @RequestBody Admin AdminDetails) throws RessourceNotFoundException{
        Admin a = adminRepository.findById(idAdmin).orElseThrow(() -> new RessourceNotFoundException("Utilisateur non trouvé par cet ID:" + idAdmin));
        a.setLogin(AdminDetails.getLogin());
        a.setEmail(AdminDetails.getEmail());
        a.setMdp(AdminDetails.getMdp());
        a.setTelephone(AdminDetails.getTelephone());

        final Admin updateAdmin=adminRepository.save(a);
        return ResponseEntity.ok(updateAdmin);
    }



}
