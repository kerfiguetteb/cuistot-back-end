package com.outman.avis.controller;

import com.outman.avis.entite.Ingredient;
import com.outman.avis.entite.IngredientQuantite;
import com.outman.avis.service.IngredientQuantiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientQuantites")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IngredientQuantiteController {

    private final IngredientQuantiteService ingredientQuantiteService;

    @GetMapping("")
    public List<IngredientQuantite> findAll(){return ingredientQuantiteService.findAll();}

    @GetMapping("/{id}")
    public IngredientQuantite findById(@PathVariable int id){ return ingredientQuantiteService.findById(id);}


    @PostMapping("")
    public ResponseEntity<Void> save (@RequestBody IngredientQuantite ingredientQuantite){
        ingredientQuantiteService.save(ingredientQuantite);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
