package com.fitflow.fitflowbackend.dto;

public class RegisterRequest {
    private String name;
    private String email;
    private String username; // <- Agregado
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() { // <- Getter agregado
        return username;
    }

    public void setUsername(String username) { // <- Setter agregado
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
