package com.example.casinojwtservice;

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
