package com.outman.avis;

import com.outman.avis.repository.RecetteRepository;
import com.outman.avis.service.RecetteService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

@AllArgsConstructor
@SpringBootApplication
@EnableScheduling

public class CuistotApplication implements CommandLineRunner {

	private RecetteService recetteService;
	public static void main(String[] args) {
		SpringApplication.run(CuistotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		this.recetteService.intializeRecette();

	}
}
