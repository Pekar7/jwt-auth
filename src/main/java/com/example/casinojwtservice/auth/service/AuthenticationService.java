package com.example.casinojwtservice.auth.service;


import com.example.casinojwtservice.auth.model.AuthenticationRequest;
import com.example.casinojwtservice.auth.model.AuthenticationResponse;
import com.example.casinojwtservice.auth.model.RegisterRequest;
import com.example.casinojwtservice.config.JWTService;
import com.example.casinojwtservice.user.CasinoUser;
import com.example.casinojwtservice.user.UserRepository;
import com.example.casinojwtservice.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(RegisterRequest request) {

        boolean isRegistered = userRepository.findByEmail(request.getEmail()).isPresent();
        if (isRegistered) {
            return "Account already exists ";
        }

        var user = CasinoUser.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .role(UserRole.USER)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        var jwtToken = jwtService.generateToken(user);
        user.setToken(jwtToken);
        userRepository.save(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken).build().getToken();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken).build();
    }

    public boolean outhAuth(String jwtToken) {
        return jwtService.isTokenValid(jwtToken);
    }
}
