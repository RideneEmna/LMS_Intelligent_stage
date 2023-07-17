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
	public Long getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(Long idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
    
    
}
