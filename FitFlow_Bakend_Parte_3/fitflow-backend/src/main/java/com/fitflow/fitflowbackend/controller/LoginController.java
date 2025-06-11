package com.fitflow.fitflowbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fitflow.fitflowbackend.entity.User;
import com.fitflow.fitflowbackend.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Permite solicitudes desde el frontend
public class LoginController {

    @Autowired
    private UserService userService;

    // DTO para recibir login (usuario + password)
    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest loginRequest) {
        return userService.validateLogin(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
