package com.outman.avis.service;

import com.outman.avis.entite.Validation;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotificationService {
    JavaMailSender javaMailSender;
    public void envoyer(Validation validation){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("no-reply@cuistot.fr");
        mailMessage.setTo(validation.getUtilisateur().getEmail());
        mailMessage.setSubject("Votre code d'activation");

      String text =  String.format("Bonjour %s, /n Votre code d'activation : %s" ,
                validation.getUtilisateur().getNom(),
                validation.getCode()
                );
        mailMessage.setText(text);

        javaMailSender.send(mailMessage);



    }
}
