package com.msdev.hr_oauth.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final JwtService jwtService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String authenticate(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }
}


// TODO: o vídeo parou em 14:27, no inicio da configuração dos beans do JWT - https://www.youtube.com/watch?v=kEJ8a1w4a2Q&list=WL&index=23 