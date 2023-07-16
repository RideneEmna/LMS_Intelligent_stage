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

}
