package com.github.douglashauschild.jwtauthapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.douglashauschild.jwtauthapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

