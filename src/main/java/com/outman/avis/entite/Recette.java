package com.outman.avis.entite;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<IngredientQuantite> ingredientQuantites;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Avis> avis;



}
