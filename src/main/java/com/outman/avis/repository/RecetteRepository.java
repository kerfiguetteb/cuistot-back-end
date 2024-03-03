package com.outman.avis.repository;

import com.outman.avis.dto.recettes.RecetteDto;
import com.outman.avis.entite.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetteRepository extends JpaRepository<Recette, Integer> {

    // SELECT * FROM recette WHERE name=param;
    List<Recette> findByName(String name);



}
