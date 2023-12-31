package com.outman.avis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CuistotApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuistotApplication.class, args);
	}

}
