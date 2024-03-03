package com.outman.avis.dto.recettes;

import com.outman.avis.dto.avis.AvisDto;
import com.outman.avis.entite.IngredientQuantite;

import java.util.List;

public record RecetteDto (

    int id,
    String name,
    String description,
    List<AvisDto> avis,
    List<IngredientQuantite> ingredientQuantites


){}
