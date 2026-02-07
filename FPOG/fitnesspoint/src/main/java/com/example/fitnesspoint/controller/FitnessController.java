package com.example.fitnesspoint.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.fitnesspoint.client.DietPlanClient;
import com.example.fitnesspoint.client.DietPlanClient.DietPlan;
import com.example.fitnesspoint.client.WorkoutClient;
import com.example.fitnesspoint.client.WorkoutClient.Workout;

@Controller
public class FitnessController {

    // private final DietPlanRepository dietRepo;
    private final WorkoutClient workoutClient;
    private final DietPlanClient dietPlanClient;

    public FitnessController(WorkoutClient workoutClient, DietPlanClient dietPlanClient) {
        // this.dietRepo = dietRepo;
        this.workoutClient = workoutClient;
        this.dietPlanClient = dietPlanClient;
    }

    @GetMapping("/diet")
    public String dietPage(@RequestParam(required = false) String ageGroup,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String bmiCategory,
            @RequestParam(required = false) Double bmiValue,
            Model model, org.springframework.security.core.Authentication authentication) {

        try {
            if (ageGroup != null && type != null) {
                // Call the new Feign client to get data from the dietplan-service with BMI
                ResponseEntity<List<DietPlan>> response;
                if (bmiCategory != null) {
                    response = dietPlanClient.getDietPlansWithBMI(ageGroup, type, bmiCategory);
                } else {
                    response = dietPlanClient.getDietPlans(ageGroup, type);
                }
                
                if (response.getStatusCode().is2xxSuccessful()) {
                    model.addAttribute("plans", response.getBody());
                } else {
                    // Handle error
                    model.addAttribute("plans", new ArrayList<DietPlan>());
                    model.addAttribute("error", "Failed to load diet plans from service");
                }
            } else {
                model.addAttribute("plans", new ArrayList<DietPlan>());
            }
        } catch (Exception e) {
            // Handle Feign client errors (service not available, etc.)
            model.addAttribute("plans", new ArrayList<DietPlan>());
            model.addAttribute("error", "Diet plan service is currently unavailable. Please try again later.");
            System.err.println("Error calling dietplan-service: " + e.getMessage());
        }

        // Add BMI information to the model for display
        if (bmiCategory != null) {
            model.addAttribute("bmiCategory", bmiCategory);
            model.addAttribute("bmiValue", bmiValue);
            model.addAttribute("bmiBasedRecommendation", true);
        }

        // Pass user id to template
        // ... (your existing user logic) ...
        return "dietplan";
    }

    // API endpoint for JavaScript to fetch diet plans as JSON
    @GetMapping("/api/diet")
    @ResponseBody
    public ResponseEntity<List<DietPlan>> getDietPlansApi(@RequestParam String ageGroup, @RequestParam String type) {
        try {
            ResponseEntity<List<DietPlan>> response = dietPlanClient.getDietPlans(ageGroup, type);
            if (response.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok(response.getBody());
            } else {
                return ResponseEntity.status(response.getStatusCode()).body(new ArrayList<>());
            }
        } catch (Exception e) {
            System.err.println("Error calling dietplan-service: " + e.getMessage());
            return ResponseEntity.status(500).body(new ArrayList<>());
        }
    }

    // Save a new DietPlan (API endpoint)
    // @PostMapping("/api/diet")
    // public ResponseEntity<DietPlan> saveDietPlan(@RequestBody DietPlan dietPlan)
    // {
    // DietPlan saved = dietRepo.save(dietPlan);
    // return ResponseEntity.ok(saved);
    // }

    // Save a new Workout (API endpoint)
    @PostMapping("/api/workout")
    public ResponseEntity<Workout> saveWorkout(@RequestBody Workout workout) {
        try {
            ResponseEntity<Workout> response = workoutClient.createWorkout(workout);
            if (response.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok(response.getBody());
            } else {
                return ResponseEntity.status(response.getStatusCode()).build();
            }
        } catch (Exception e) {
            System.err.println("Error calling workout-service: " + e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    // @GetMapping("/diet")
    // public String dietPage(@RequestParam(required = false) String ageGroup,
    // @RequestParam(required = false) String type,
    // Model model, org.springframework.security.core.Authentication authentication)
    // {
    // if (ageGroup != null && type != null) {
    // List<DietPlan> plans = dietRepo.findByAgeGroupAndType(ageGroup, type);
    // model.addAttribute("plans", plans);
    // }
    // // Pass user id to template
    // if (authentication != null && authentication.isAuthenticated()) {
    // Object principal = authentication.getPrincipal();
    // if (principal instanceof com.example.fitnesspoint.model.User user) {
    // model.addAttribute("userId", user.getId());
    // } else {
    // // fallback: username
    // model.addAttribute("username", authentication.getName());
    // }
    // }
    // model.addAttribute("newDietPlan", new DietPlan());
    // return "dietplan"; // dietplan.html
    // }

    // // Handle diet plan form submission
    // @PostMapping(value = "/diet", consumes = "application/x-www-form-urlencoded")
    // public String saveDietPlanForm(@ModelAttribute DietPlan newDietPlan, Model
    // model) {
    // dietRepo.save(newDietPlan);
    // model.addAttribute("newDietPlan", new DietPlan());
    // model.addAttribute("success", "Diet plan saved successfully!");
    // return "dietplan";
    // }

    @GetMapping("/workout")
    public String workoutPage(@RequestParam(required = false) String workoutName,
            Model model, org.springframework.security.core.Authentication authentication) {
        if (workoutName != null) {
            try {
                ResponseEntity<Workout> response = workoutClient.getWorkoutByName(workoutName);
                if (response.getStatusCode().is2xxSuccessful()) {
                    model.addAttribute("workout", response.getBody());
                } else {
                    model.addAttribute("error", "Workout not found");
                }
            } catch (Exception e) {
                model.addAttribute("error", "Workout service is currently unavailable. Please try again later.");
                System.err.println("Error calling workout-service: " + e.getMessage());
            }
        }
        // Pass user id to template
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof com.example.fitnesspoint.model.User user) {
                model.addAttribute("userId", user.getId());
            } else {
                // fallback: username
                model.addAttribute("username", authentication.getName());
            }
        }
        model.addAttribute("newWorkout", new Workout());
        return "workout"; // workout.html
    }

    // Handle workout form submission
    @PostMapping(value = "/workout", consumes = "application/x-www-form-urlencoded")
    public String saveWorkoutForm(@ModelAttribute Workout newWorkout, Model model) {
        try {
            ResponseEntity<Workout> response = workoutClient.createWorkout(newWorkout);
            if (response.getStatusCode().is2xxSuccessful()) {
                model.addAttribute("workout", response.getBody());
                model.addAttribute("newWorkout", new Workout());
                model.addAttribute("success", "Workout saved successfully!");
            } else {
                model.addAttribute("error", "Failed to save workout");
                model.addAttribute("newWorkout", newWorkout);
            }
        } catch (Exception e) {
            model.addAttribute("error", "Workout service is currently unavailable. Please try again later.");
            model.addAttribute("newWorkout", newWorkout);
            System.err.println("Error calling workout-service: " + e.getMessage());
        }
        return "workout";
    }
}
