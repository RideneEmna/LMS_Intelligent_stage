package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "instructors")
public class instructor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idInstructor;

    //@Column(nullable = false, unique = true)
    private String username;

    //@Column(nullable = false, unique = true)
    private String email;

    //@Column(nullable = false)
    private String password;
    private String name;
    private String surname;
    private String speciality;

    public instructor() {
        super();
    }

    public instructor(String username, String email, String password, String name, String surname, String speciality) {
        this.username=username;
        this.email=email;
        this.password=password;
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
    }

    public Long getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Long idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
