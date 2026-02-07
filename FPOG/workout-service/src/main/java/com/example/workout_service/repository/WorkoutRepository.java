package com.example.workout_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.workout_service.model.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    Workout findByWorkoutName(String workoutName);
}