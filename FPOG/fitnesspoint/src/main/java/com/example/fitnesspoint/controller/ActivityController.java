package com.example.fitnesspoint.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitnesspoint.client.DietPlanClient;
import com.example.fitnesspoint.client.WorkoutClient;

@RestController
@RequestMapping("/api")
public class ActivityController {
    // @Autowired
    // private DietCompletionRepository dietCompletionRepository;
    private final DietPlanClient dietPlanClient;
    private final WorkoutClient workoutClient;

    public ActivityController(DietPlanClient dietPlanClient, WorkoutClient workoutClient) {
        this.dietPlanClient = dietPlanClient;
        this.workoutClient = workoutClient;
    }

    @PostMapping("/diet/complete")
    public ResponseEntity<?> markDietCompleted(@RequestBody DietPlanClient.DietCompleteRequest req) {
        // Call the new Feign client to send data to the dietplan-service
        return dietPlanClient.markDietCompleted(req);
    }

    // @PostMapping("/diet/complete")
    // public ResponseEntity<?> markDietCompleted(@RequestBody DietCompleteRequest
    // req) {
    // DietCompletion completion = new DietCompletion(req.userId, req.dietPlanId,
    // LocalDateTime.now());
    // dietCompletionRepository.save(completion);
    // return ResponseEntity.ok().build();
    // }

    @PostMapping("/workout/session")
    public ResponseEntity<?> saveWorkoutSession(@RequestBody WorkoutSessionRequest req) {
        try {
            WorkoutClient.WorkoutSessionRequest workoutRequest = new WorkoutClient.WorkoutSessionRequest();
            workoutRequest.setUserId(req.userId);
            workoutRequest.setWorkoutName(req.workoutName);
            workoutRequest.setCaloriesBurned(req.caloriesBurned);
            workoutRequest.setMinutes(req.minutes);

            ResponseEntity<WorkoutClient.WorkoutSession> response = workoutClient.createWorkoutSession(workoutRequest);
            if (response.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(response.getStatusCode()).build();
            }
        } catch (Exception e) {
            System.err.println("Error calling workout-service: " + e.getMessage());
            // Return error response since we no longer have local fallback
            return ResponseEntity.status(500).body("Workout service is unavailable");
        }
    }

    // Removed duplicate DietCompleteRequest class, using
    // DietPlanClient.DietCompleteRequest instead.

    public static class WorkoutSessionRequest {
        public Long userId;
        public String workoutName;
        public double caloriesBurned;
        public double minutes;
    }
}
