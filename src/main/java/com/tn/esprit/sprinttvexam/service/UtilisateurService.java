package com.tn.esprit.sprinttvexam.service;

import com.tn.esprit.sprinttvexam.entity.Utilisateur;
import com.tn.esprit.sprinttvexam.enums.Profession;
import com.tn.esprit.sprinttvexam.enums.Thematique;

import java.util.Date;
import java.util.List;

public interface UtilisateurService {
    public Utilisateur ajouterUtilisateur (Utilisateur u);
    public void affecterProgrammeAUtilisateur (String prNom, String userNom);
    public List<Utilisateur> recupererUtilisateurs(Profession p, Date d, Thematique t);
    public void desaffecterProgrammeDeUtilisateur (String prNom, String usrNom);
}
