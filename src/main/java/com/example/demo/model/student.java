package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class student extends users {
    private String name;
    private String surname;
    private String studyLevel;

    public student() {
        super();
    }

    public student(String username, String email, String password, String name, String surname, String studyLevel) {
        super(username, email, password);
        this.name = name;
        this.surname = surname;
        this.studyLevel = studyLevel;
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
