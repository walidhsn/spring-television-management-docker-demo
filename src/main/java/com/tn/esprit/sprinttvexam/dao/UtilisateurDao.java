package com.tn.esprit.sprinttvexam.dao;

import com.tn.esprit.sprinttvexam.entity.Utilisateur;
import com.tn.esprit.sprinttvexam.enums.Profession;
import com.tn.esprit.sprinttvexam.enums.Thematique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByUserNom(String userNom);
    @Query("SELECT DISTINCT u from Utilisateur u JOIN u.programmes p join p.chaine c WHERE " +
            "u.profession = :profession AND u.userDateInscription > :dateInsc AND c.chTheme = :theme")
    List<Utilisateur> findCutomQuery(@Param("profession")Profession profession, @Param("dateInsc")Date dateInsc, @Param("theme")Thematique theme);
}
