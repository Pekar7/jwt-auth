package com.example.casinojwtservice.auth.controller;

import com.example.casinojwtservice.auth.model.AuthenticationRequest;
import com.example.casinojwtservice.auth.model.AuthenticationResponse;
import com.example.casinojwtservice.auth.model.RegisterRequest;
import com.example.casinojwtservice.auth.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    //http://localhost:8080/swagger-ui/index.html#/authentication-controller/authentication
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/registration")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}

