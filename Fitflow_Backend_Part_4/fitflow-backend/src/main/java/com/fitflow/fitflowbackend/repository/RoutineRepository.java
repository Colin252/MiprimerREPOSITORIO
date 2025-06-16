package com.fitflow.fitflowbackend.repository;

import com.fitflow.fitflowbackend.entity.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
}
