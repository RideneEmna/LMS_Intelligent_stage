package com.example.LMS.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Admin {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idAdmin;
    private String login;
    private String mdp;
    private String email;
    private String telephone;



}
