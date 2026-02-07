package com.example.dietplan_service.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.dietplan_service.model.DietPlan;
import com.example.dietplan_service.repository.DietPlanRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final DietPlanRepository dietPlanRepository;

    public DataLoader(DietPlanRepository dietPlanRepository) {
        this.dietPlanRepository = dietPlanRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only add data if the table is empty
        if (dietPlanRepository.count() == 0) {
            System.out.println("Loading sample diet plans...");

            // Vegetarian Teen Plans
            dietPlanRepository.save(new DietPlan("teen", "veg", "Day 1",
                    "Breakfast: Oatmeal with fruits, Lunch: Quinoa salad, Dinner: Lentil curry with roti"));
            dietPlanRepository.save(new DietPlan("teen", "veg", "Day 2",
                    "Breakfast: Smoothie bowl, Lunch: Vegetable wrap, Dinner: Paneer curry with rice"));
            dietPlanRepository.save(new DietPlan("teen", "veg", "Day 3",
                    "Breakfast: Yogurt with granola, Lunch: Buddha bowl, Dinner: Dal with chapati"));

            // Non-Vegetarian Teen Plans
            dietPlanRepository.save(new DietPlan("teen", "nonveg", "Day 1",
                    "Breakfast: Eggs and toast, Lunch: Chicken salad, Dinner: Fish curry with rice"));
            dietPlanRepository.save(new DietPlan("teen", "nonveg", "Day 2",
                    "Breakfast: Protein smoothie, Lunch: Turkey sandwich, Dinner: Grilled chicken with vegetables"));
            dietPlanRepository.save(new DietPlan("teen", "nonveg", "Day 3",
                    "Breakfast: Omelet with vegetables, Lunch: Chicken wrap, Dinner: Salmon with quinoa"));

            // Vegetarian Adult Plans
            dietPlanRepository.save(new DietPlan("adult", "veg", "Day 1",
                    "Breakfast: Greek yogurt with nuts, Lunch: Chickpea salad, Dinner: Vegetable stir-fry with tofu"));
            dietPlanRepository.save(new DietPlan("adult", "veg", "Day 2",
                    "Breakfast: Avocado toast, Lunch: Lentil soup, Dinner: Stuffed bell peppers"));
            dietPlanRepository.save(new DietPlan("adult", "veg", "Day 3",
                    "Breakfast: Chia pudding, Lunch: Quinoa bowl, Dinner: Black bean tacos"));

            // Non-Vegetarian Adult Plans
            dietPlanRepository.save(new DietPlan("adult", "nonveg", "Day 1",
                    "Breakfast: Scrambled eggs, Lunch: Grilled chicken salad, Dinner: Baked cod with vegetables"));
            dietPlanRepository.save(new DietPlan("adult", "nonveg", "Day 2",
                    "Breakfast: Protein pancakes, Lunch: Beef stir-fry, Dinner: Grilled salmon"));
            dietPlanRepository.save(new DietPlan("adult", "nonveg", "Day 3",
                    "Breakfast: Egg white omelet, Lunch: Turkey and avocado wrap, Dinner: Lean beef with sweet potato"));

            // Senior Plans
            dietPlanRepository.save(new DietPlan("senior", "veg", "Day 1",
                    "Breakfast: Soft fruits and yogurt, Lunch: Vegetable soup, Dinner: Mashed lentils with rice"));
            dietPlanRepository.save(new DietPlan("senior", "veg", "Day 2",
                    "Breakfast: Porridge with honey, Lunch: Steamed vegetables, Dinner: Soft tofu curry"));

            dietPlanRepository.save(new DietPlan("senior", "nonveg", "Day 1",
                    "Breakfast: Soft boiled eggs, Lunch: Chicken broth, Dinner: Steamed fish with rice"));
            dietPlanRepository.save(new DietPlan("senior", "nonveg", "Day 2",
                    "Breakfast: Egg custard, Lunch: Minced chicken, Dinner: Fish soup with bread"));

            System.out.println("Sample diet plans loaded successfully!");
        } else {
            System.out.println("Diet plans already exist in database, skipping data loading.");
        }
    }
}