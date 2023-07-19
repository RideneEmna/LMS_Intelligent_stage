package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class admin extends users {
    private String name;

    public admin() {
        super();
    }

    public admin(String username, String email, String password, String name) {
        super(username, email, password);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
