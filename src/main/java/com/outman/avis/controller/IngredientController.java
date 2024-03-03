package com.outman.avis.controller;


import com.outman.avis.entite.Ingredient;
import com.outman.avis.entite.Recette;
import com.outman.avis.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("")
    public List<Ingredient> findAll(){return ingredientService.findAll();}

    @GetMapping("/{id}")
    public Ingredient findById(@PathVariable int id){ return ingredientService.findById(id);}


    @PostMapping("")
    public ResponseEntity<Void> save (@RequestBody Ingredient ingredient){
        ingredientService.save(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
