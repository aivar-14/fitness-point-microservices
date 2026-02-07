package com.example.fitnesspoint.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

// The name attribute should match the Spring application name of the diet plan service
@FeignClient(name = "dietplan-service")
public interface DietPlanClient {

    @GetMapping("/api/diet")
    ResponseEntity<List<DietPlan>> getDietPlans(@RequestParam("ageGroup") String ageGroup,
            @RequestParam("type") String type);

    @GetMapping("/api/diet/bmi")
    ResponseEntity<List<DietPlan>> getDietPlansWithBMI(@RequestParam("ageGroup") String ageGroup,
            @RequestParam("type") String type,
            @RequestParam("bmiCategory") String bmiCategory);

    @PostMapping("/api/diet/complete")
    ResponseEntity<Void> markDietCompleted(@RequestBody DietCompleteRequest request);

    // Nested classes for data transfer
    class DietPlan {
        // Re-create the DietPlan class here with getters/setters, but no JPA
        // annotations
        private Long id;
        private String ageGroup;
        private String type;
        private String bmiCategory;
        private String day;
        private String meal;

        // Getters and Setters
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
    }

    class DietCompleteRequest {
        private Long userId;
        private Long dietPlanId;

        // Getters and Setters
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
    }
}
