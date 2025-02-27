package com.nobank.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nobank.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> { 
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByDni(String dni);
    boolean existsByUsername(String username);
}
