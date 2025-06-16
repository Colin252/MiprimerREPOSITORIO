package com.fitflow.fitflowbackend.controller;

import com.fitflow.fitflowbackend.dto.AuthRequest;
import com.fitflow.fitflowbackend.dto.AuthResponse;
import com.fitflow.fitflowbackend.entity.User;
import com.fitflow.fitflowbackend.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody User user) {
        return authService.register(user);
    }
}

