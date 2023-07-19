package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "courses")
public class courses {
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

	public courses(Long idCours, String titre, String auteur, String matiere, LocalDateTime dateAjout, String description, int nbHeures) {
		this.idCours = idCours;
		this.titre = titre;
		this.auteur = auteur;
		this.matiere = matiere;
		this.dateAjout = dateAjout;
		this.description = description;
		this.nbHeures = nbHeures;
	}

	public courses(Long idCours, String titre, String auteur, String matiere, LocalDateTime dateAjout, String description, int nbHeures, com.example.demo.model.student student, com.example.demo.model.instructor instructor) {
		this.idCours = idCours;
		this.titre = titre;
		this.auteur = auteur;
		this.matiere = matiere;
		this.dateAjout = dateAjout;
		this.description = description;
		this.nbHeures = nbHeures;
		this.student = student;
		this.instructor = instructor;
	}

	public student getStudent() {
		return student;
	}

	public void setStudent(student student) {
		this.student = student;
	}

	public instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(instructor instructor) {
		this.instructor = instructor;
	}

	public courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="student_id")
    student student;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="instructor_id")
    instructor instructor;

    /*@ManyToOne
    private Test test;*/

	public Long getIdCours() {
		return idCours;
	}

	public void setIdCours(Long idCours) {
		this.idCours = idCours;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public LocalDateTime getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(LocalDateTime dateAjout) {
		this.dateAjout = dateAjout;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbHeures() {
		return nbHeures;
	}

	public void setNbHeures(int nbHeures) {
		this.nbHeures = nbHeures;
	}

/*	public Apprenant getApprenant() {
		return apprenant;
	}

	public void setApprenant(Apprenant apprenant) {
		this.apprenant = apprenant;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}*/
    
    

}
