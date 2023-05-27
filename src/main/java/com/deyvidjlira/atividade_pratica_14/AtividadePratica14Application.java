package com.deyvidjlira.atividade_pratica_14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AtividadePratica14Application {

	public static void main(String[] args) {
		SpringApplication.run(AtividadePratica14Application.class, args);
	}

}
