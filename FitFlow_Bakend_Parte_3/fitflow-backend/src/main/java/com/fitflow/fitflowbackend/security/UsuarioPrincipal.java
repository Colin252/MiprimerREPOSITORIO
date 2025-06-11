package com.fitflow.fitflowbackend.security;

import com.fitflow.fitflowbackend.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UsuarioPrincipal implements UserDetails {

    private final Usuario usuario;

    public UsuarioPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Por ahora no manejamos roles, si quieres luego agregas aquí
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        // Usamos el email como username
        return usuario.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // puedes personalizar si quieres
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // puedes personalizar si quieres
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // puedes personalizar si quieres
    }

    @Override
    public boolean isEnabled() {
        return true; // puedes personalizar si quieres
    }

    // Getter para acceder al objeto Usuario completo si hace falta
    public Usuario getUsuario() {
        return usuario;
    }
}
