package com.example.dietplan_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DietCompletion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // or String username if you use usernames
    private Long dietPlanId;
    private LocalDateTime completedAt;

    public DietCompletion() {
    }

    public DietCompletion(Long userId, Long dietPlanId, LocalDateTime completedAt) {
        this.userId = userId;
        this.dietPlanId = dietPlanId;
        this.completedAt = completedAt;
    }

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

    public Long getDietPlanId() {
        return dietPlanId;
    }

    public void setDietPlanId(Long dietPlanId) {
        this.dietPlanId = dietPlanId;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
