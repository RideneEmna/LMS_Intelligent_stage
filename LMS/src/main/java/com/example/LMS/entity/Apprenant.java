package com.example.LMS.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Apprenant {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEtudiant;
    private String login;
    private String mdp;
    private String email;
    private String telephone;
    private String nom;
    private String prenom;
    private String niveauEtudes;
}
