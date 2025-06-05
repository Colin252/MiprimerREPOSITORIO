package com.fitflow.fitflowbackend.service;

import com.fitflow.fitflowbackend.entity.Exercise;
import com.fitflow.fitflowbackend.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseById(Long id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        return exercise.orElse(null);
    }

    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Exercise updateExercise(Long id, Exercise exerciseDetails) {
        Optional<Exercise> optionalExercise = exerciseRepository.findById(id);
        if (optionalExercise.isEmpty()) {
            return null;
        }
        Exercise exercise = optionalExercise.get();
        exercise.setName(exerciseDetails.getName());
        exercise.setDifficulty(exerciseDetails.getDifficulty());
        exercise.setMuscleGroup(exerciseDetails.getMuscleGroup());
        // Si quieres actualizar la rutina, agrégalo aquí (con cuidado)
        return exerciseRepository.save(exercise);
    }

    public boolean deleteExercise(Long id) {
        Optional<Exercise> optionalExercise = exerciseRepository.findById(id);
        if (optionalExercise.isEmpty()) {
            return false;
        }
        exerciseRepository.deleteById(id);
        return true;
    }
}
