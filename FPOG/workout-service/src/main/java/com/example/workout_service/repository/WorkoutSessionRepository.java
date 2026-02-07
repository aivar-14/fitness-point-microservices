package com.example.workout_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.workout_service.model.WorkoutSession;

@Repository
public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, Long> {
    List<WorkoutSession> findByUserId(Long userId);
}