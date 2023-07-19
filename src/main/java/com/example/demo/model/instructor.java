package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "instructors")
public class instructor extends users {
    private String name;
    private String surname;
    private String speciality;

    public instructor() {
        super();
    }

    public instructor(String username, String email, String password, String name, String surname, String speciality) {
        super(username, email, password);
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
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
