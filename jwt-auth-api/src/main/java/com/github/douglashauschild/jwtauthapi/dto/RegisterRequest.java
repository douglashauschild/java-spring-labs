package com.github.douglashauschild.jwtauthapi.dto;

public record RegisterRequest(
    String username,
    String password
) {}

