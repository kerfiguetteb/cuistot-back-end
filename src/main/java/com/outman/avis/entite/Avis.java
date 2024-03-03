package com.outman.avis.entite;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    private Instant creation;
    @ManyToOne(cascade = CascadeType.ALL)
    private Utilisateur utilisateur;
}
