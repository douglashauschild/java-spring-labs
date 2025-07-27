package com.github.douglashauschild.jwtauthapi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected")
public class ProtectedController {

	@GetMapping
    public String protectedRoute(Authentication authentication) {
        return "Access allowed for: " + authentication.getName();
    }
	
}
