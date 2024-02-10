package com.outman.avis.service;

import com.outman.avis.entite.Recette;
import com.outman.avis.repository.RecetteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class RecetteService {

    private final RecetteRepository recetteRepository;


    public List<Recette> findAll(){
        return recetteRepository.findAll();
    }

    public Recette save (Recette recette){
        return recetteRepository.save(recette);
    }

    public Recette findById(int id){
        return recetteRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recette introuvable"));
    }

    public void delete(int id){ recetteRepository.deleteById(id);}

    public void deleteAll(){recetteRepository.deleteAll();}
}
