package com.example.workout_service.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.workout_service.model.Workout;
import com.example.workout_service.model.WorkoutSession;
import com.example.workout_service.repository.WorkoutRepository;
import com.example.workout_service.repository.WorkoutSessionRepository;

@RestController
@RequestMapping("/api")
public class WorkoutController {

    private final WorkoutRepository workoutRepository;
    private final WorkoutSessionRepository workoutSessionRepository;

    public WorkoutController(WorkoutRepository workoutRepository, WorkoutSessionRepository workoutSessionRepository) {
        this.workoutRepository = workoutRepository;
        this.workoutSessionRepository = workoutSessionRepository;
    }

    // Get all workout types
    @GetMapping("/workouts")
    public ResponseEntity<List<Workout>> getAllWorkouts() {
        List<Workout> workouts = workoutRepository.findAll();
        return ResponseEntity.ok(workouts);
    }

    // Get workout by name
    @GetMapping("/workouts/{workoutName}")
    public ResponseEntity<Workout> getWorkoutByName(@PathVariable String workoutName) {
        Workout workout = workoutRepository.findByWorkoutName(workoutName);
        if (workout != null) {
            return ResponseEntity.ok(workout);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new workout type
    @PostMapping("/workouts")
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
        try {
            Workout savedWorkout = workoutRepository.save(workout);
            return ResponseEntity.ok(savedWorkout);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get workout sessions for a user
    @GetMapping("/workout-sessions")
    public ResponseEntity<List<WorkoutSession>> getWorkoutSessions(@RequestParam Long userId) {
        List<WorkoutSession> sessions = workoutSessionRepository.findByUserId(userId);
        return ResponseEntity.ok(sessions);
    }

    // Create a new workout session
    @PostMapping("/workout-sessions")
    public ResponseEntity<WorkoutSession> createWorkoutSession(@RequestBody WorkoutSessionRequest request) {
        try {
            WorkoutSession session = new WorkoutSession(
                    request.userId,
                    request.workoutName,
                    request.caloriesBurned,
                    request.minutes,
                    LocalDateTime.now());
            WorkoutSession savedSession = workoutSessionRepository.save(session);
            return ResponseEntity.ok(savedSession);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // DTO for workout session requests
    public static class WorkoutSessionRequest {
        public Long userId;
        public String workoutName;
        public double caloriesBurned;
        public double minutes;

        // Getters and Setters
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getWorkoutName() {
            return workoutName;
        }

        public void setWorkoutName(String workoutName) {
            this.workoutName = workoutName;
        }

        public double getCaloriesBurned() {
            return caloriesBurned;
        }

        public void setCaloriesBurned(double caloriesBurned) {
            this.caloriesBurned = caloriesBurned;
        }

        public double getMinutes() {
            return minutes;
        }

        public void setMinutes(double minutes) {
            this.minutes = minutes;
        }
    }
}