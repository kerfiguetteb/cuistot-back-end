package com.outman.avis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.outman.avis.TypeDeRole;
import com.outman.avis.dto.recettes.RecetteDto;
import com.outman.avis.entite.*;
import com.outman.avis.repository.RecetteRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class RecetteService {

    private final ObjectMapper mapper;
    private final RecetteRepository recetteRepository;


    public List<RecetteDto> search(String name){

        List<Recette> recettes = recetteRepository.findAll();
        List<Recette> recetteByName = recetteRepository.findByName(name);

        if (Strings.isNotEmpty(name)) {
            return recetteByName.stream()
                    .map(recette -> mapper.convertValue(recette, RecetteDto.class))
                    .toList();
        }

        return recettes.stream()
                .map(recette -> mapper.convertValue(recette, RecetteDto.class))
                .toList();
    }
    public void intializeRecette(){
        Faker faker = new Faker();

        final List<Recette> recetteStream = IntStream.range(30, 100).mapToObj(index ->
                {
                    Role roleUtilisateur = new Role();
                    roleUtilisateur.setLibelle(TypeDeRole.UTILISATEUR);

                    Utilisateur utlisateurs = Utilisateur.builder()
                            .nom(faker.name().fullName())
                            .actif(true)
                            .role(roleUtilisateur)
                            .build();
                    List<Avis> avis = IntStream.range(2, 5).mapToObj(i -> Avis.builder()
                            .utilisateur(utlisateurs)
                            .message(faker.lorem().sentence())
                            .build()
                    ).toList();


                    Random random = new Random();
                    String[] arrayIngredients = {"Sel", "Poivre", "Farine", "Sucre", "Lait", "Levure"};

                    // Liste pour stocker les objets Ingredient
                    List<Ingredient> ingredients = Arrays.stream(arrayIngredients)
                            .map(name -> Ingredient.builder().name(name).build())
                            .collect(Collectors.toList());

                    // Mélanger la liste d'ingrédients
                    Collections.shuffle(ingredients);

                    // Liste pour stocker les objets IngredientQuantite
                    List<IngredientQuantite> ingredientQuantites = IntStream.range(0, arrayIngredients.length)
                            .mapToObj(i -> IngredientQuantite.builder()
                                    .quantite(random.nextInt(151) + 50)
                                    .ingredient(ingredients.get(i))
                                    .build()
                            ).collect(Collectors.toList());


                    return  Recette.builder()
                            .avis(avis)
                            .ingredientQuantites(ingredientQuantites)
                            .name("Recette " + index)
                            .build();
                }

    ).toList();

        this.recetteRepository.saveAll(recetteStream);
    }


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
