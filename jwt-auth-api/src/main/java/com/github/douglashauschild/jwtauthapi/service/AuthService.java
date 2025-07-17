package com.github.douglashauschild.jwtauthapi.service;

import com.github.douglashauschild.jwtauthapi.dto.AuthRequest;
import com.github.douglashauschild.jwtauthapi.dto.AuthResponse;
import com.github.douglashauschild.jwtauthapi.dto.RegisterRequest;
import com.github.douglashauschild.jwtauthapi.entity.Role;
import com.github.douglashauschild.jwtauthapi.entity.User;
import com.github.douglashauschild.jwtauthapi.repository.UserRepository;
import com.github.douglashauschild.jwtauthapi.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }

    public AuthResponse authenticate(AuthRequest request) {
        var auth = new UsernamePasswordAuthenticationToken(
                request.username(), request.password()
        );
        authenticationManager.authenticate(auth);

        var user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }
}