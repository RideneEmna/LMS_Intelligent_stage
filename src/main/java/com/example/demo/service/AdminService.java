package com.example.demo.service;

import com.example.demo.model.admin;
import com.example.demo.repository.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final adminRepository adminRepository;

    @Autowired
    public AdminService(com.example.demo.repository.adminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public admin addAdmin(admin admin) {
        return adminRepository.save(admin);
    }

    public admin updateAdmin(Long id, admin adminDetails) {
        Optional<admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            admin admin = optionalAdmin.get();
            admin.setEmail(adminDetails.getEmail());
            admin.setPassword(adminDetails.getPassword());
            admin.setName(adminDetails.getName());
            admin.setUsername(adminDetails.getUsername());
            return adminRepository.save(admin);
        }
        return null;
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
