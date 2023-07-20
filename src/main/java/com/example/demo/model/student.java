package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idStudent;

    //@Column(nullable = false, unique = true)
    private String username;

    //@Column(nullable = false, unique = true)
    private String email;

    //@Column(nullable = false)
    private String password;
    private String name;
    private String surname;
    private String studyLevel;

    public student() {
        super();
    }

    public student(String username, String email, String password, String name, String surname, String studyLevel) {
        this.username=username;
        this.email=email;
        this.password=password;
        this.name = name;
        this.surname = surname;
        this.studyLevel = studyLevel;
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

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
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

    public String getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(String studyLevel) {
        this.studyLevel = studyLevel;
    }
}
