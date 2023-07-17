package com.example.LMS.repository;

import com.example.LMS.entity.Apprenant;
import com.example.LMS.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface enseignantRepository extends JpaRepository<Enseignant,Long> {
    Boolean existsByLogin(String login);
    Boolean existsByEmail(String email);

    Optional<Enseignant> findById(Long idEnseignant);

    void deleteById(Long idEnseignant);
}
