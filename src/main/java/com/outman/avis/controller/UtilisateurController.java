package com.outman.avis.controller;

import com.outman.avis.dto.AuthentificationDto;
import com.outman.avis.entite.Utilisateur;
import com.outman.avis.securite.JwtService;
import com.outman.avis.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UtilisateurController {

    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private UtilisateurService utilisateurService;

    @PostMapping("inscription")
    public void inscription(@RequestBody Utilisateur utilisateur){
        this.utilisateurService.inscription(utilisateur);
    }


    @PostMapping("deconnexion")
    public void deconnexion(){
        this.jwtService.deconnexion();
    }

    @PostMapping(path = "activation")
    public void activation(@RequestBody Map<String, String> activation) {
        this.utilisateurService.activation(activation);
    }

    @PostMapping("connexion")
    public Map<String, String> connexion(@RequestBody AuthentificationDto authentificationDto){
       final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDto.username(), authentificationDto.password())
        );

       if (authenticate.isAuthenticated()){
         return  this.jwtService.generate(authentificationDto.username());
       }

        return null;
    }
}
