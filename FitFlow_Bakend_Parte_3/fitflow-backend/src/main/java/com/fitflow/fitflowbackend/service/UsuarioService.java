package com.fitflow.fitflowbackend.service;

import com.fitflow.fitflowbackend.entity.Usuario;
import com.fitflow.fitflowbackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Usuario> login(String email, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            String storedPassword = usuario.get().getPassword();
            if (storedPassword != null && passwordEncoder.matches(password, storedPassword)) {
                return usuario;
            }
        }
        return Optional.empty();
    }
}
