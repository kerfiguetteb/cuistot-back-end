package com.outman.avis.dto.avis;

import com.outman.avis.dto.utilisateurs.UtilisateurDto;

import java.time.Instant;

public record AvisDto (

    int id,
    String message,
    Instant creation,
    UtilisateurDto utilisateur
){}
