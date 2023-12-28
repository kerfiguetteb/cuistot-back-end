package com.outman.avis.controller;

import com.outman.avis.entite.Avis;
import com.outman.avis.service.AvisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("avis")
@AllArgsConstructor
public class AvisController {
    private final AvisService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Avis avis){
        this.service.save(avis);
    }
}
