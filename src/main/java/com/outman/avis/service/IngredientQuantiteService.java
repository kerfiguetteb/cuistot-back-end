package com.outman.avis.service;

import com.outman.avis.entite.Ingredient;
import com.outman.avis.entite.IngredientQuantite;
import com.outman.avis.repository.IngredientQuantiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientQuantiteService {

    private final IngredientQuantiteRepository ingredientQuantiteRepository;

    public List<IngredientQuantite> findAll(){ return ingredientQuantiteRepository.findAll(); }

    public IngredientQuantite findById(int id){ return ingredientQuantiteRepository.findById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Quantiter de l'ingredient introuvable introuvable" ));
    }
    public IngredientQuantite save(IngredientQuantite ingredientQuantite){ return ingredientQuantiteRepository.save(ingredientQuantite); }

    public void delete(int id){ ingredientQuantiteRepository.deleteById(id);}

    public void deleteAll(){ingredientQuantiteRepository.deleteAll();}

}
