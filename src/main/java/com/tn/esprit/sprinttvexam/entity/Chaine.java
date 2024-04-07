package com.tn.esprit.sprinttvexam.entity;

import com.tn.esprit.sprinttvexam.enums.Thematique;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chaine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chId;
    private String chNom;
    @Enumerated(EnumType.STRING)
    private Thematique chTheme;
}
