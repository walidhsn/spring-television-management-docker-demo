package com.tn.esprit.sprinttvexam.service;

import com.tn.esprit.sprinttvexam.entity.Programme;

public interface ProgrammeService {
    public Programme ajouterProgrammeEtChaine (Programme p);
    public Programme ajouterProgrammeEtAffecterChaine (Programme p, Long chId);
}
