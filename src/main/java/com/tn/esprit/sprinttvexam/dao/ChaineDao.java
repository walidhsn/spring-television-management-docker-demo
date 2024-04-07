package com.tn.esprit.sprinttvexam.dao;

import com.tn.esprit.sprinttvexam.entity.Chaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChaineDao extends JpaRepository<Chaine,Long> {
    @Query("SELECT c.chNom, COUNT(DISTINCT p) FROM Programme p " +
            "JOIN p.chaine c " +
            "JOIN p.utilisateurs u " +
            "GROUP BY c.chNom " +
            "ORDER BY COUNT(DISTINCT p) DESC")
    List<Object[]> countFavoriteProgramsByChaine();
}
