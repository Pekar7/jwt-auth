package com.example.casinojwtservice;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SecuritySchemes({
//        @SecurityScheme(
//                name = "BearerAuth",
//                type = SecuritySchemeType.HTTP,
//                scheme = "bearer",
//                bearerFormat = "JWT"
//        )
//})
@SpringBootApplication
public class CasinoJwtServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasinoJwtServiceApplication.class, args);
    }
}
