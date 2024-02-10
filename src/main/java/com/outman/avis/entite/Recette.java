package com.outman.avis.entite;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recette {

    @Id
    private int id;

    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<IngredientQuantite> ingredientQuantite;


}
