package com.example.LMS.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Utilisateur {
    private String login;
    private String mdp;
    private String email;
    private String telephone;
}
