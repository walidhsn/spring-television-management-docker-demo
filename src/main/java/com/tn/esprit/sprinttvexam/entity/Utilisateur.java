package com.tn.esprit.sprinttvexam.entity;

import com.tn.esprit.sprinttvexam.enums.Profession;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userNom;
    private Date userDateInscription;
    @Enumerated(EnumType.STRING)
    private Profession profession;
    @ManyToMany(cascade = CascadeType. ALL)
    private List<Programme> programmes = new ArrayList<>();
}
