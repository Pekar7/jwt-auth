package com.example.casinojwtservice.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<CasinoUser, Long> {
    Optional<CasinoUser> findByEmail(String email);
}
