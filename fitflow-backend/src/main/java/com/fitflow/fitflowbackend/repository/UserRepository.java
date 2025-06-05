package com.fitflow.fitflowbackend.repository;

import com.fitflow.fitflowbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Aquí puedes agregar consultas personalizadas si quieres
}
