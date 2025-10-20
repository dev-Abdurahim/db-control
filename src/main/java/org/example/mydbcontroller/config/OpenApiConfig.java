package org.example.mydbcontroller.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Db control API",
                description = "API for DB control management system",
                version = "1",
                contact = @Contact(
                        name = "Abdurahim soft",
                        email = "abdurahimbohodirov25@gamil.com",
                        url = "https://wywhere.soft.uz/api"
                )

        ),
        servers = {
                @Server(
                        description = "Local Server",
                        url = "http://localhost:8081"
                ),
                @Server(
                        description = "ser2",
                        url = "http://localhost:1111"
                )
        }

)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT scientification",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)

public class OpenApiConfig {

    @Bean
    public GroupedOpenApi userApi(){
        return GroupedOpenApi.builder()
                .group("Auth") // Guruh nomi
                .pathsToMatch("/api/v1/auth/**") // Guruhga mos keluvchi yo'llar
                .build();
    }
    @Bean
    public GroupedOpenApi dbUserApi() {


        return GroupedOpenApi.builder()
                .group("db user") // Guruh nomi
                .pathsToMatch("/api/v1/db-user/**") // Guruhga mos keluvchi yo'llar
                .build();
    }
}
