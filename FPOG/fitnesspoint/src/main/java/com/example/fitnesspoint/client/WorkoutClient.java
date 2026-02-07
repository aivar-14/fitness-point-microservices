package com.example.fitnesspoint.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

// The name attribute should match the Spring application name of the workout service
@FeignClient(name = "workout-service")
public interface WorkoutClient {

    @GetMapping("/api/workouts")
    ResponseEntity<List<Workout>> getAllWorkouts();

    @GetMapping("/api/workouts/{workoutName}")
    ResponseEntity<Workout> getWorkoutByName(@PathVariable String workoutName);

    @PostMapping("/api/workouts")
    ResponseEntity<Workout> createWorkout(@RequestBody Workout workout);

    @GetMapping("/api/workout-sessions")
    ResponseEntity<List<WorkoutSession>> getWorkoutSessions(@RequestParam Long userId);

    @PostMapping("/api/workout-sessions")
    ResponseEntity<WorkoutSession> createWorkoutSession(@RequestBody WorkoutSessionRequest request);

    // Nested classes for data transfer
    class Workout {
        private Long id;
        private String workoutName;
        private int caloriesBurned;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        // Default constructor
        public Workout() {
        }

        // Constructor with parameters
        public Workout(String workoutName, int caloriesBurned) {
            this.workoutName = workoutName;
            this.caloriesBurned = caloriesBurned;
        }

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getWorkoutName() {
            return workoutName;
        }

        public void setWorkoutName(String workoutName) {
            this.workoutName = workoutName;
        }

        public int getCaloriesBurned() {
            return caloriesBurned;
        }

        public void setCaloriesBurned(int caloriesBurned) {
            this.caloriesBurned = caloriesBurned;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }
    }

    class WorkoutSession {
        private Long id;
        private Long userId;
        private String workoutName;
        private double caloriesBurned;
        private double minutes;
        private LocalDateTime completedAt;

        // Default constructor
        public WorkoutSession() {
        }

        // Constructor with parameters
        public WorkoutSession(Long userId, String workoutName, double caloriesBurned, double minutes,
                LocalDateTime completedAt) {
            this.userId = userId;
            this.workoutName = workoutName;
            this.caloriesBurned = caloriesBurned;
            this.minutes = minutes;
            this.completedAt = completedAt;
        }

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

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

        public LocalDateTime getCompletedAt() {
            return completedAt;
        }

        public void setCompletedAt(LocalDateTime completedAt) {
            this.completedAt = completedAt;
        }
    }

    class WorkoutSessionRequest {
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