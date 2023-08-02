package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class courses {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCourse;
    private String title;
    private String instructor;
    private String subject;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //private LocalDateTime dateAjout;
    private String description;
    private int duration;
    
    

    public courses() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getIdCourse() {
		return idCourse;
	}



	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getInstructor() {
		return instructor;
	}



	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getDuration() {
		return duration;
	}



	public void setDuration(int duration) {
		this.duration = duration;
	}
}
	/*@ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="apprenant_id")
    Apprenant apprenant;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="enseignant_id")
    Enseignant enseignant;

    @ManyToOne
    private Test test;*/

	