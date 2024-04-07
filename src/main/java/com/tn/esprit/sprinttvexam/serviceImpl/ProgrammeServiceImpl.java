package com.tn.esprit.sprinttvexam.serviceImpl;

import com.tn.esprit.sprinttvexam.dao.ChaineDao;
import com.tn.esprit.sprinttvexam.dao.ProgrammeDao;
import com.tn.esprit.sprinttvexam.entity.Chaine;
import com.tn.esprit.sprinttvexam.entity.Programme;
import com.tn.esprit.sprinttvexam.service.ProgrammeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgrammeServiceImpl implements ProgrammeService {
    @Autowired
    private ProgrammeDao programmeDao;
    @Autowired
    private ChaineDao chaineDao;
    @Transactional
    @Override
    public Programme ajouterProgrammeEtChaine(Programme p) {
        Chaine chaine = p.getChaine();
        if (chaine != null && chaine.getChId() == null) {
            chaine = chaineDao.save(chaine);
        }
        p.setChaine(chaine);
        return programmeDao.save(p);
    }

    @Override
    public Programme ajouterProgrammeEtAffecterChaine(Programme p, Long chId) {
        Optional<Chaine> optionalChaine = chaineDao.findById(chId);
        if(optionalChaine.isPresent()){
            p.setChaine(optionalChaine.get());
            Programme result = programmeDao.save(p);
        }
        return null;
    }
}
