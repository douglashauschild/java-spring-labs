package com.github.douglashauschild.jwtauthapi.dto;

public record AuthRequest(
    String username,
    String password
) {}
