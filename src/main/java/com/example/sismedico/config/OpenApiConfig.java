package com.example.sismedico.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI sistemaMedicoOpenAPI() {

        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Servidor Local");

        Server productionServer = new Server();
        productionServer.setUrl("https://api.sismedico.com");
        productionServer.setDescription("Servidor de Producción");

        Contact contact = new Contact();
        contact.setName("Equipo SISMEDICO");
        contact.setEmail("soporte@sismedico.com");
        contact.setUrl("https://github.com/isairey/Backend-SistemaMedico");

        License license = new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT");

        Info info = new Info()
                .title("SISMEDICO API")
                .version("1.0.0")
                .description("""
                        API REST para el Sistema de Citas Médicas.

                        Funcionalidades:

                        • Autenticación JWT
                        • Gestión de usuarios
                        • Gestión de médicos
                        • Gestión de pacientes
                        • Especialidades médicas
                        • Horarios
                        • Citas médicas
                        • Diagnósticos
                        • Recetas
                        • Notificaciones
                        """)
                .contact(contact)
                .license(license);

        return new OpenAPI()
                .info(info)
                .servers(List.of(localServer, productionServer))
                .externalDocs(
                        new ExternalDocumentation()
                                .description("Documentación del Proyecto")
                                .url("https://github.com/isairey/Backend-SistemaMedico")
                );

    }

}