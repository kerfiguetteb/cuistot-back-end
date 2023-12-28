package com.outman.avis.entite;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Jwt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String valeur;

    private  boolean desactive;

    private boolean expire;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    private Utilisateur utilisateur;

}
