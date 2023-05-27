package com.deyvidjlira.atividade_pratica_14.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringdocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        Contact contact = new Contact();
        contact.setName("Deyvid Jaguaribe");
        return new OpenAPI()
                .info(new Info().title("API Referente Prática 14")
                        .contact(contact)
                        .description("Documentação.")
                        .version("1.0.0")
                        .license(new License().name("MIT").url("https://github.com/DeyvidJLira/spring-boot-descomplica-pratica-14/blob/main/LICENSE")))
                .externalDocs(new ExternalDocumentation()
                        .description("Link do Repositório da Aplicação")
                        .url("https://github.com/DeyvidJLira/spring-boot-descomplica-pratica-14"));
    }
}