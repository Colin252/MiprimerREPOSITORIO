package com.fitflow.fitflowbackend.controller;

import com.fitflow.fitflowbackend.entity.Routine;
import com.fitflow.fitflowbackend.service.RoutineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routines")
public class RoutineController {

    private final RoutineService routineService;

    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }

    @GetMapping
    public List<Routine> getAllRoutines() {
        return routineService.getAllRoutines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Routine> getRoutineById(@PathVariable Long id) {
        Routine routine = routineService.getRoutineById(id);
        if (routine == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(routine);
    }

    @PostMapping
    public Routine createRoutine(@RequestBody Routine routine) {
        return routineService.createRoutine(routine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Routine> updateRoutine(@PathVariable Long id, @RequestBody Routine routineDetails) {
        Routine updatedRoutine = routineService.updateRoutine(id, routineDetails);
        if (updatedRoutine == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRoutine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoutine(@PathVariable Long id) {
        boolean deleted = routineService.deleteRoutine(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
