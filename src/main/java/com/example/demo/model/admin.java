package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class admin {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idAdmin;

    //@Column(nullable = false, unique = true)
    private String username;

    //@Column(nullable = false, unique = true)
    private String email;

    //@Column(nullable = false)
    private String password;

    private String name;

    public admin() {
        super();
    }

    public admin(String username, String email, String password, String name) {
        this.username=username;
        this.email=email;
        this.password=password;
        this.name = name;
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
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
}
