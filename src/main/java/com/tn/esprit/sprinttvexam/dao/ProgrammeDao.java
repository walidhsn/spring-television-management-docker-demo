package com.tn.esprit.sprinttvexam.dao;

import com.tn.esprit.sprinttvexam.entity.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProgrammeDao extends JpaRepository<Programme,Long> {
    Optional<Programme> findByPrNom(String prNom);
}
