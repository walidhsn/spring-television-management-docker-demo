package com.tn.esprit.sprinttvexam.serviceImpl;

import com.tn.esprit.sprinttvexam.dao.ProgrammeDao;
import com.tn.esprit.sprinttvexam.dao.UtilisateurDao;
import com.tn.esprit.sprinttvexam.entity.Programme;
import com.tn.esprit.sprinttvexam.entity.Utilisateur;
import com.tn.esprit.sprinttvexam.enums.Profession;
import com.tn.esprit.sprinttvexam.enums.Thematique;
import com.tn.esprit.sprinttvexam.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurDao utilisateurDao;
    @Autowired
    private ProgrammeDao programmeDao;
    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur u) {
        return utilisateurDao.save(u);
    }

    @Override
    public void affecterProgrammeAUtilisateur(String prNom, String userNom) {
        Optional<Programme> optionalProgramme = programmeDao.findByPrNom(prNom);
        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findByUserNom(userNom);
        if(optionalProgramme.isPresent() && optionalUtilisateur.isPresent()){
            Utilisateur user=optionalUtilisateur.get();
            Programme prog = optionalProgramme.get();
            user.getProgrammes().add(prog);
            utilisateurDao.save(user);
        }else {
            System.out.println("Programme ou Utilisateur n'existent pas");
        }
    }

    @Override
    public List<Utilisateur> recupererUtilisateurs(Profession p, Date d, Thematique t) {
        List<Utilisateur> result = utilisateurDao.findCutomQuery(p,d,t);
        return result;
    }

    @Override
    public void desaffecterProgrammeDeUtilisateur(String prNom, String usrNom) {
        Optional<Programme> optionalProgramme = programmeDao.findByPrNom(prNom);
        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findByUserNom(usrNom);
        if(optionalProgramme.isPresent() && optionalUtilisateur.isPresent()){
            Utilisateur user=optionalUtilisateur.get();
            Programme prog = optionalProgramme.get();
            if(user.getProgrammes().contains(prog)){
                user.getProgrammes().remove(prog);
                utilisateurDao.save(user);
            }else{
                System.out.println("Programme n'est pas affecter pour ce l'utilisateur.");
            }
        }else {
            System.out.println("Programme ou Utilisateur n'existent pas.");
        }
    }
}
