package com.tn.esprit.sprinttvexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Programme implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prId;
    private String prNom;
    @ManyToMany( mappedBy = "programmes",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Utilisateur> utilisateurs = new ArrayList<>();
    @ManyToOne
    private Chaine chaine;
}
