package com.deyvidjlira.atividade_pratica_14.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SpringdocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        Contact contact = new Contact();
        contact.setName("Deyvid Jaguaribe");
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT"))
                )
                .security(List.of(new SecurityRequirement().addList(securitySchemeName)))
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