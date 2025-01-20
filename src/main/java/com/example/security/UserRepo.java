package com.example.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Userentity, Integer> {
    Optional<Userentity> findByUsername(String Username);
}
