package com.example.LMS.repository;

import com.example.LMS.entity.Apprenant;
import com.example.LMS.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface coursRepository extends JpaRepository<Cours,Long> {
    List<Cours> findByApprenantId(Long apprenantId);
    List<Cours> findByEnseignantId(Long enseignantId);
    List<Cours> findByTestId(Long testId);
    Optional<Cours> findById(Long idCours);

    void deleteById(Long idCours);

}
