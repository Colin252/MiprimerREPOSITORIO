package com.fitflow.fitflowbackend.repository;

import com.fitflow.fitflowbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);         // 🔐 Para login con email
    Optional<User> findByUsername(String username);   // ✅ Agregado para UserService
    boolean existsByEmail(String email);              // 🔄 Para evitar duplicados en registro
}
