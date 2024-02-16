package com.outman.avis.service;

import com.outman.avis.entite.Ingredient;
import com.outman.avis.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public List<Ingredient> findAll(){ return ingredientRepository.findAll(); }

    public Ingredient findById(int id){ return ingredientRepository.findById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"ingredient introuvable" ));
    }
    public Ingredient save(Ingredient ingredient){ return ingredientRepository.save(ingredient); }

    public void delete(int id){ ingredientRepository.deleteById(id);}

    public void deleteAll(){ingredientRepository.deleteAll();}
}
