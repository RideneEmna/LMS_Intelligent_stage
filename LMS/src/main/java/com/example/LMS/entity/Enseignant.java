package com.example.LMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Enseignant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idEnseignant;
    private String login;
    private String mdp;
    private String email;
    private String telephone;
    private String specialite;
}
