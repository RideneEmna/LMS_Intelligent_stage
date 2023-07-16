package com.example.LMS.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCours;
    private String titre;
    private String auteur;
    private String matiere;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateAjout;
    private String description;
    private int nbHeures;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="apprenant_id")
    Apprenant apprenant;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="enseignant_id")
    Enseignant enseignant;

    @ManyToOne
    private Test test;

}
