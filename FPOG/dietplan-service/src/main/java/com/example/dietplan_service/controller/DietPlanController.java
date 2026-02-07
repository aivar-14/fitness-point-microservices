package com.example.dietplan_service.controller;

import com.example.dietplan_service.model.DietPlan;
import com.example.dietplan_service.model.DietCompletion;
import com.example.dietplan_service.repository.DietPlanRepository;
import com.example.dietplan_service.repository.DietCompletionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DietPlanController {

    private final DietPlanRepository dietPlanRepository;
    private final DietCompletionRepository dietCompletionRepository;

    public DietPlanController(DietPlanRepository dietPlanRepository,
            DietCompletionRepository dietCompletionRepository) {
        this.dietPlanRepository = dietPlanRepository;
        this.dietCompletionRepository = dietCompletionRepository;
    }

    @GetMapping("/diet")
    public ResponseEntity<List<DietPlan>> getDietPlans(@RequestParam("ageGroup") String ageGroup,
            @RequestParam("type") String type) {
        List<DietPlan> plans = dietPlanRepository.findByAgeGroupAndType(ageGroup, type);
        return ResponseEntity.ok(plans);
    }

    @GetMapping("/diet/bmi")
    public ResponseEntity<List<DietPlan>> getDietPlansWithBMI(
            @RequestParam("ageGroup") String ageGroup,
            @RequestParam("type") String type,
            @RequestParam("bmiCategory") String bmiCategory) {

        // First try to get BMI-specific diet plans
        List<DietPlan> bmiSpecificPlans = dietPlanRepository.findByAgeGroupAndTypeAndBmiCategory(ageGroup, type,
                bmiCategory);

        if (!bmiSpecificPlans.isEmpty()) {
            return ResponseEntity.ok(bmiSpecificPlans);
        }

        // Fallback to general plans if no BMI-specific plans are found
        List<DietPlan> generalPlans = dietPlanRepository.findByAgeGroupAndType(ageGroup, type);
        return ResponseEntity.ok(generalPlans);
    }

    @PostMapping("/diet/complete")
    public ResponseEntity<Void> markDietCompleted(@RequestBody DietCompleteRequest request) {
        DietCompletion completion = new DietCompletion(request.userId, request.dietPlanId, LocalDateTime.now());
        dietCompletionRepository.save(completion);
        return ResponseEntity.ok().build();
    }

    // Add this inner class to handle the request body
    public static class DietCompleteRequest {
        public Long userId;
        public Long dietPlanId;

        // ... getters and setters ...
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