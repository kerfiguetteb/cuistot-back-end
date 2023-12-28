package com.outman.avis.service;

import com.outman.avis.entite.Avis;
import com.outman.avis.entite.Utilisateur;
import com.outman.avis.repository.AvisRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AvisService {

    private final AvisRepository repository;

    public void save(Avis avis){
       Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        avis.setUtilisateur(utilisateur);
        this.repository.save(avis);
    }







}
