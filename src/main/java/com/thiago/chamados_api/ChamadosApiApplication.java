package com.thiago.chamados_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChamadosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChamadosApiApplication.class, args);
	}

}
