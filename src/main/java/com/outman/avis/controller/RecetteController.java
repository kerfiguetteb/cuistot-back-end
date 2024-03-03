package com.outman.avis.controller;

import com.outman.avis.dto.recettes.RecetteDto;
import com.outman.avis.entite.Recette;
import com.outman.avis.service.RecetteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recettes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RecetteController {

    private final RecetteService recetteService;


    @GetMapping("")
    public List<RecetteDto> search(@RequestParam(required = false) String name){
        return recetteService.search(name);}

    @GetMapping("/{id}")
    public Recette findById(@PathVariable int id){ return recetteService.findById(id);}


    @PostMapping("")
    public ResponseEntity<Void> save (@RequestBody Recette recette){
        recetteService.save(recette);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
