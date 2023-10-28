package com.example.casinojwtservice.auth.controller;

import com.example.casinojwtservice.auth.model.AuthenticationRequest;
import com.example.casinojwtservice.auth.model.AuthenticationResponse;
import com.example.casinojwtservice.auth.model.RegisterRequest;
import com.example.casinojwtservice.auth.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    //http://localhost:8080/swagger-ui/index.html#/authentication-controller/authentication
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/registration")
    public String register(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String email,
                           @RequestParam String password) {
        RegisterRequest request = RegisterRequest.builder()
                .firstName(firstName)
                .lastName(lastName)
                .password(password)
                .email(email).build();
        return authenticationService.register(request);
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestParam String email, @RequestParam String password) {
        AuthenticationRequest authenticationRequest = AuthenticationRequest.builder()
                .email(email)
                .password(password)
                .build();
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

    @PostMapping("/outh")
    public ResponseEntity<?> outhAuthentication(@RequestParam String jwtToken) {
        return ResponseEntity.ok(authenticationService.outhAuth(jwtToken));
    }
}

