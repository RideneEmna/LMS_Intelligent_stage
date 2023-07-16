package com.example.LMS.repository;

import com.example.LMS.entity.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface apprenantRepository extends JpaRepository<Apprenant,Long> {
    Boolean existsByLogin(String login);
    Boolean existsByEmail(String email);

    Optional<Apprenant> findById(Long idEtudiant);

    void deleteById(Long idEtudiant);
}
