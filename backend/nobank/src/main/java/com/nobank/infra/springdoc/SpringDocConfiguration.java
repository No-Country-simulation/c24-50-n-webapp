package com.nobank.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Value("${server.url:}") // Opcional: Define una URL base desde properties
    private String serverUrl;

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openApi = new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList("bearer-key"));

        // Configura el servidor dinámicamente si es necesario
        if (!serverUrl.isEmpty()) {
            openApi.addServersItem(new Server().url(serverUrl));
        }

        return openApi;
    }
}