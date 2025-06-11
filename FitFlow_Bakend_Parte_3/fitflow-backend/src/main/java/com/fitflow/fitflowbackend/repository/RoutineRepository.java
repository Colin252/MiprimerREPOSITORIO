package com.fitflow.fitflowbackend.repository;

import com.fitflow.fitflowbackend.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
    // Aquí puedes agregar consultas personalizadas si las necesitas
}
