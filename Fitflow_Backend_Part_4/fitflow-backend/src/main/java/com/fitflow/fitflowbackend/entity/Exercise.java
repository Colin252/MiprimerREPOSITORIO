package com.fitflow.fitflowbackend.entity;

import jakarta.persistence.*;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String difficulty;    // Nuevo campo
    private String muscleGroup;   // Nuevo campo

    // Constructor vacío (requerido por JPA)
    public Exercise() {
    }

    // Constructor con parámetros
    public Exercise(String name, String difficulty, String muscleGroup) {
        this.name = name;
        this.difficulty = difficulty;
        this.muscleGroup = muscleGroup;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }
}
