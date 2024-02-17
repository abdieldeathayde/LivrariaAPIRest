package com.abdiel.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.abdiel.livraria.controller.livrariaController;

@SpringBootApplication
public class LivrariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
		livrariaController livroController = new livrariaController();
		livroController.menu();

	}

}
