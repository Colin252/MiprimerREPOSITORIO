package com.fitflow.fitflowbackend.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Esta clase carga el usuario desde la base de datos o cualquier fuente
@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Aquí deberías inyectar tu repositorio para buscar usuarios (ejemplo comentado)
    // private final UserRepository userRepository;
    //
    // public CustomUserDetailsService(UserRepository userRepository) {
    //     this.userRepository = userRepository;
    // }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Aquí buscarías el usuario en la base de datos, ejemplo básico:
        // User user = userRepository.findByUsername(username)
        //     .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Por ahora, un usuario dummy para que compile:
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password("{noop}password") // {noop} para no encriptar
                .roles("USER")
                .build();
    }
}
