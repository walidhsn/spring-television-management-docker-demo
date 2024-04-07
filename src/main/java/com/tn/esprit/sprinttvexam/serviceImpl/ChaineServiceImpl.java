package com.tn.esprit.sprinttvexam.serviceImpl;

import com.tn.esprit.sprinttvexam.dao.ChaineDao;
import com.tn.esprit.sprinttvexam.service.ChaineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChaineServiceImpl implements ChaineService {
    @Autowired
    private ChaineDao chaineDao;

    @Scheduled(fixedRate = 20000)
    public void ordonnerChaines(){
        List<Object[]> results = chaineDao.countFavoriteProgramsByChaine();
        for (Object[] result : results) {
            String chaineNom = (String) result[0];
            Long count = (Long) result[1];
            System.out.println("Chaine : " + chaineNom + ". Nombre de fois où les programmes de cette Chaine sont marqués comme favoris : " + count);
        }
    }
}
