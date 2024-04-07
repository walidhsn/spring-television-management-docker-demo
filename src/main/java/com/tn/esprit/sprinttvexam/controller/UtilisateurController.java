package com.tn.esprit.sprinttvexam.controller;

import com.tn.esprit.sprinttvexam.entity.Utilisateur;
import com.tn.esprit.sprinttvexam.enums.Profession;
import com.tn.esprit.sprinttvexam.enums.Thematique;
import com.tn.esprit.sprinttvexam.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/utilisateur")
    public ResponseEntity<Utilisateur> addUser(@RequestBody Utilisateur utilisateur){
        Utilisateur result = utilisateurService.ajouterUtilisateur(utilisateur);
        return result!=null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }
    @PostMapping("/utilisateur/programme")
    public ResponseEntity<String> addProgrammeToUser(@RequestParam String userNom, @RequestParam String prNom){
        utilisateurService.affecterProgrammeAUtilisateur(prNom,userNom);
        return ResponseEntity.ok("> Programme "+prNom+" got affected to the user "+ userNom +".");
    }
    @GetMapping("/utilisateur/custom")
    public ResponseEntity<List<Utilisateur>> getUsers(@RequestParam Profession profession, @RequestParam Date dateInscription, @RequestParam Thematique thematique){
        List<Utilisateur> result = utilisateurService.recupererUtilisateurs(profession,dateInscription,thematique);
        return result!=null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }
    @PostMapping("/utilisateur/remove-programme")
    public ResponseEntity<String> removeProgrammeFromUser(@RequestParam String userNom, @RequestParam String prNom){
        utilisateurService.desaffecterProgrammeDeUtilisateur(prNom,userNom);
        return ResponseEntity.ok("> Programme "+prNom+" is not longer affected to the user "+ userNom +".");
    }
}
