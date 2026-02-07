package com.example.fitnesspoint.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitnesspoint.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
