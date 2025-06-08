package com.fitflow.fitflowbackend.service;

import com.fitflow.fitflowbackend.entity.Routine;
import com.fitflow.fitflowbackend.repository.RoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutineService {

    private final RoutineRepository routineRepository;

    public RoutineService(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }

    public List<Routine> getAllRoutines() {
        return routineRepository.findAll();
    }

    public Routine getRoutineById(Long id) {
        Optional<Routine> routine = routineRepository.findById(id);
        return routine.orElse(null);
    }

    public Routine createRoutine(Routine routine) {
        return routineRepository.save(routine);
    }

    public Routine updateRoutine(Long id, Routine routineDetails) {
        Optional<Routine> optionalRoutine = routineRepository.findById(id);
        if (optionalRoutine.isEmpty()) {
            return null;
        }
        Routine routine = optionalRoutine.get();
        routine.setTitle(routineDetails.getTitle());
        routine.setGoal(routineDetails.getGoal());
        routine.setExercises(routineDetails.getExercises());
        return routineRepository.save(routine);
    }

    public boolean deleteRoutine(Long id) {
        Optional<Routine> optionalRoutine = routineRepository.findById(id);
        if (optionalRoutine.isEmpty()) {
            return false;
        }
        routineRepository.deleteById(id);
        return true;
    }
}
