package com.example.dietplan_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dietplan_service.model.DietPlan;

public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {
    List<DietPlan> findByAgeGroupAndType(String ageGroup, String type);
    List<DietPlan> findByAgeGroupAndTypeAndBmiCategory(String ageGroup, String type, String bmiCategory);

}
