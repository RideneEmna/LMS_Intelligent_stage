package com.example.LMS.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idTest;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateAjout;
    private String matiere;
    @JsonFormat(pattern="HH:mm:ss")
    private Time duree ;
	public Long getIdTest() {
		return idTest;
	}
	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}
	public LocalDateTime getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(LocalDateTime dateAjout) {
		this.dateAjout = dateAjout;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public Time getDuree() {
		return duree;
	}
	public void setDuree(Time duree) {
		this.duree = duree;
	}
    
    

}
