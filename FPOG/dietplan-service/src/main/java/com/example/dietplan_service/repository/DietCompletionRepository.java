package com.example.dietplan_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dietplan_service.model.DietCompletion;

public interface DietCompletionRepository extends JpaRepository<DietCompletion, Long> {
}

