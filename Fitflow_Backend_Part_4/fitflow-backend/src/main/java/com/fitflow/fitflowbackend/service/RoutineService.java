package com.fitflow.fitflowbackend.service;

import com.fitflow.fitflowbackend.entity.Routine;
import com.fitflow.fitflowbackend.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutineService {

    @Autowired
    private RoutineRepository routineRepository;

    public Routine createRoutine(Routine routine, String email) {
        // Aquí puedes enlazar con el usuario si lo deseas
        System.out.println("Usuario que creó la rutina: " + email);
        return routineRepository.save(routine);
    }
}

