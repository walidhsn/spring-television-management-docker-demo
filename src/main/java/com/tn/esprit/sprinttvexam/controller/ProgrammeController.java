package com.tn.esprit.sprinttvexam.controller;

import com.tn.esprit.sprinttvexam.entity.Programme;
import com.tn.esprit.sprinttvexam.entity.Utilisateur;
import com.tn.esprit.sprinttvexam.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProgrammeController {
    @Autowired
    private ProgrammeService programmeService;

    @PostMapping("/programme")
    public ResponseEntity<Programme> addProgramme(@RequestBody Programme programme){
        Programme result = programmeService.ajouterProgrammeEtChaine(programme);
        return result!=null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }
    @PostMapping("/programme/{id}")
    public ResponseEntity<Programme> addProgramme(@PathVariable("id") Long chId, @RequestBody Programme programme){
        Programme result = programmeService.ajouterProgrammeEtAffecterChaine(programme,chId);
        return result!=null ? ResponseEntity.ok(result) : ResponseEntity.badRequest().build();
    }
}
