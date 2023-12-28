package com.outman.avis.service;

import com.outman.avis.TypeDeRole;
import com.outman.avis.entite.Role;
import com.outman.avis.entite.Utilisateur;
import com.outman.avis.entite.Validation;
import com.outman.avis.repository.UtilisateurRepository;
import com.outman.avis.repository.ValidationRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;


@AllArgsConstructor
@Service
public class UtilisateurService implements UserDetailsService {

    private  UtilisateurRepository repository;
    private  BCryptPasswordEncoder passwordEncoder;
    private ValidationService validationService;
    private UtilisateurRepository utilisateurRepository;

    public void inscription(Utilisateur utilisateur){
        if (!utilisateur.getEmail().contains("@") || !utilisateur.getEmail().contains(".") ){
            throw new RuntimeException("Email invalide");
        }

        String mdpCrypte = this.passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setMdp(mdpCrypte);

        Optional<Utilisateur> utilisateurOptional = this.repository.findByEmail(utilisateur.getEmail());
        if (utilisateurOptional.isPresent()){
            throw new RuntimeException("Votre email existe");
        }

        Role roleUtilisateur = new Role();
        roleUtilisateur.setLibelle(TypeDeRole.UTILISATEUR);
        utilisateur.setRole(roleUtilisateur);

        utilisateur = this.utilisateurRepository.save(utilisateur);
        this.validationService.enregistrer(utilisateur);

    }

    public void activation(Map<String, String> activation) {
        Validation validation = this.validationService.lireEnFonctionDuCode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpiration())){
            throw  new RuntimeException("Votre code a expiré");
        }
        Utilisateur utilisateurActiver = this.utilisateurRepository.findById(validation.getUtilisateur().getId()).orElseThrow(() -> new RuntimeException("Utilisateur inconnu"));
        utilisateurActiver.setActif(true);
        this.utilisateurRepository.save(utilisateurActiver);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Aucun Utilisateur ne correspond à cet identifiant"));

    }
}
