package com.example.casinojwtservice.auth;

import com.example.casinojwtservice.config.SecurityConfig;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiKey;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("Users")
                .pathsToMatch("/api/v1/auth/**")
                .build();
    }

}

