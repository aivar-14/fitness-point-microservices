package com.example.dietplan_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ageGroup; // teen, adult, senior
    private String type; // veg or nonveg
    private String bmiCategory; // Underweight, Normal, Overweight, Obese (optional, can be null for general plans)
    private String day; // Day 1, Day 2, etc.
    private String meal; // Meal details

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Default constructor
    public DietPlan() {
    }

    // Constructor with parameters
    public DietPlan(String ageGroup, String type, String day, String meal) {
        this.ageGroup = ageGroup;
        this.type = type;
        this.day = day;
        this.meal = meal;
    }

    // Constructor with BMI category
    public DietPlan(String ageGroup, String type, String bmiCategory, String day, String meal) {
        this.ageGroup = ageGroup;
        this.type = type;
        this.bmiCategory = bmiCategory;
        this.day = day;
        this.meal = meal;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBmiCategory() {
        return bmiCategory;
    }

    public void setBmiCategory(String bmiCategory) {
        this.bmiCategory = bmiCategory;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
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
