package com.example.dietplan_service.config;

import com.example.dietplan_service.model.DietPlan;
import com.example.dietplan_service.repository.DietPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private DietPlanRepository dietPlanRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if BMI-specific data already exists
        if (dietPlanRepository.findByAgeGroupAndTypeAndBmiCategory("adult", "veg", "Normal").isEmpty()) {
            initializeBMISpecificDietPlans();
            System.out.println("✅ BMI-specific diet plans initialized in database!");
        } else {
            System.out.println("ℹ️ BMI-specific diet plans already exist in database.");
        }
    }

    private void initializeBMISpecificDietPlans() {
        List<DietPlan> dietPlans = Arrays.asList(
                // UNDERWEIGHT PLANS
                // Teen Vegetarian Underweight
                new DietPlan("teen", "veg", "Underweight", "Day 1",
                        "Breakfast: Banana Oats + Full-fat Milk + Almonds + Dates | Lunch: Brown Rice + Dal + Paneer Curry + Ghee | Dinner: Whole Wheat Chapati + Mixed Veg + Yogurt + Nuts"),
                new DietPlan("teen", "veg", "Underweight", "Day 2",
                        "Breakfast: Smoothie (Mango + Banana + Nuts + Milk) | Lunch: Rice + Rajma + Avocado Salad | Dinner: Chapati + Paneer Butter Masala + Sweet Lassi"),
                new DietPlan("teen", "veg", "Underweight", "Day 3",
                        "Breakfast: Sprouts + Whole Grain Toast + Peanut Butter | Lunch: Rice + Sambar + Coconut Chutney | Dinner: Roti + Dal + Ghee + Mixed Nuts"),

                // Teen Non-vegetarian Underweight
                new DietPlan("teen", "nonveg", "Underweight", "Day 1",
                        "Breakfast: Scrambled Eggs + Whole Grain Toast + Avocado | Lunch: Rice + Chicken Curry + Ghee | Dinner: Chapati + Fish Curry + Full-fat Yogurt"),
                new DietPlan("teen", "nonveg", "Underweight", "Day 2",
                        "Breakfast: Protein Smoothie + Boiled Eggs + Nuts | Lunch: Rice + Mutton Curry + Salad | Dinner: Roti + Chicken Tikka + Milk"),
                new DietPlan("teen", "nonveg", "Underweight", "Day 3",
                        "Breakfast: Omelette + Cheese + Toast + Butter | Lunch: Rice + Fish Curry + Dal | Dinner: Chapati + Chicken Curry + Lassi"),

                // Adult Vegetarian Underweight
                new DietPlan("adult", "veg", "Underweight", "Day 1",
                        "Breakfast: Quinoa Porridge + Nuts + Dried Fruits + Milk | Lunch: Brown Rice + Dal + Paneer + Ghee | Dinner: Multi-grain Roti + Vegetable Curry + Yogurt + Almonds"),
                new DietPlan("adult", "veg", "Underweight", "Day 2",
                        "Breakfast: Avocado Toast + Nuts + Green Tea | Lunch: Rice + Chickpea Curry + Coconut Oil | Dinner: Chapati + Paneer Makhani + Milk with Turmeric"),
                new DietPlan("adult", "veg", "Underweight", "Day 3",
                        "Breakfast: Smoothie Bowl + Granola + Seeds | Lunch: Rice + Rajma + Salad with Olive Oil | Dinner: Roti + Dal + Ghee + Mixed Nuts"),

                // NORMAL WEIGHT PLANS
                // Teen Vegetarian Normal
                new DietPlan("teen", "veg", "Normal", "Day 1",
                        "Breakfast: Balanced Oats + Milk + Fruits | Lunch: Rice + Dal + Vegetable Curry + Salad | Dinner: Chapati + Paneer + Mixed Vegetables + Yogurt"),
                new DietPlan("teen", "veg", "Normal", "Day 2",
                        "Breakfast: Poha + Green Tea + Fruits | Lunch: Brown Rice + Sambar + Vegetable Curry | Dinner: Roti + Dal + Salad + Buttermilk"),
                new DietPlan("teen", "veg", "Normal", "Day 3",
                        "Breakfast: Smoothie + Whole Grain Toast | Lunch: Rice + Rajma + Mixed Salad | Dinner: Chapati + Vegetable Curry + Yogurt"),

                // Teen Non-vegetarian Normal
                new DietPlan("teen", "nonveg", "Normal", "Day 1",
                        "Breakfast: Eggs + Toast + Milk | Lunch: Rice + Chicken Curry + Salad | Dinner: Chapati + Fish Curry + Vegetables + Yogurt"),
                new DietPlan("teen", "nonveg", "Normal", "Day 2",
                        "Breakfast: Omelette + Fruits + Green Tea | Lunch: Rice + Fish Curry + Dal | Dinner: Roti + Chicken + Mixed Salad + Milk"),
                new DietPlan("teen", "nonveg", "Normal", "Day 3",
                        "Breakfast: Boiled Eggs + Toast + Juice | Lunch: Rice + Mutton Curry + Vegetables | Dinner: Chapati + Fish + Dal + Buttermilk"),

                // Adult Vegetarian Normal
                new DietPlan("adult", "veg", "Normal", "Day 1",
                        "Breakfast: Oats + Almond Milk + Berries + Green Tea | Lunch: Quinoa + Dal + Mixed Vegetables + Salad | Dinner: Multi-grain Roti + Paneer Curry + Yogurt"),
                new DietPlan("adult", "veg", "Normal", "Day 2",
                        "Breakfast: Smoothie Bowl + Granola + Green Tea | Lunch: Brown Rice + Chickpea Curry + Salad | Dinner: Chapati + Vegetable Curry + Buttermilk"),
                new DietPlan("adult", "veg", "Normal", "Day 3",
                        "Breakfast: Avocado Toast + Green Tea + Fruits | Lunch: Rice + Sambar + Mixed Vegetables | Dinner: Roti + Dal + Salad + Yogurt"),

                // OVERWEIGHT PLANS
                // Teen Vegetarian Overweight
                new DietPlan("teen", "veg", "Overweight", "Day 1",
                        "Breakfast: Oats + Skimmed Milk + Berries + Green Tea | Lunch: Brown Rice + Dal + Steamed Vegetables | Dinner: Multi-grain Roti + Vegetable Curry + Cucumber Salad"),
                new DietPlan("teen", "veg", "Overweight", "Day 2",
                        "Breakfast: Vegetable Poha + Green Tea + Lemon Water | Lunch: Quinoa + Chickpea Curry + Raw Salad | Dinner: Roti + Palak + Low-fat Yogurt"),
                new DietPlan("teen", "veg", "Overweight", "Day 3",
                        "Breakfast: Sprouts Salad + Whole Grain Toast + Green Tea | Lunch: Brown Rice + Sambar + Steamed Broccoli | Dinner: Multi-grain Chapati + Dal + Cucumber Water"),

                // Teen Non-vegetarian Overweight
                new DietPlan("teen", "nonveg", "Overweight", "Day 1",
                        "Breakfast: Boiled Eggs + Whole Grain Toast + Green Tea | Lunch: Brown Rice + Grilled Chicken + Salad | Dinner: Multi-grain Roti + Fish Curry + Cucumber"),
                new DietPlan("teen", "nonveg", "Overweight", "Day 2",
                        "Breakfast: Egg White Omelette + Vegetables + Green Tea | Lunch: Quinoa + Chicken Breast + Steamed Vegetables | Dinner: Roti + Fish + Tomato Salad"),
                new DietPlan("teen", "nonveg", "Overweight", "Day 3",
                        "Breakfast: Boiled Eggs + Spinach + Lemon Water | Lunch: Brown Rice + Grilled Fish + Raw Salad | Dinner: Chapati + Chicken Soup + Cucumber Water"),

                // OBESE PLANS
                // Teen Vegetarian Obese
                new DietPlan("teen", "veg", "Obese", "Day 1",
                        "Breakfast: Green Tea + Vegetable Juice + Small Bowl Oats | Lunch: Steamed Vegetables + Small Bowl Brown Rice + Dal | Dinner: Large Vegetable Salad + 1 Multi-grain Roti + Green Tea"),
                new DietPlan("teen", "veg", "Obese", "Day 2",
                        "Breakfast: Lemon Water + Sprouts + Green Tea | Lunch: Large Salad + Steamed Broccoli + Small Bowl Quinoa | Dinner: Vegetable Soup + 1 Roti + Cucumber Water"),
                new DietPlan("teen", "veg", "Obese", "Day 3",
                        "Breakfast: Green Smoothie + Chia Seeds + Water | Lunch: Steamed Vegetables + Moong Dal + Small Brown Rice | Dinner: Large Raw Salad + Vegetable Broth + Green Tea"),

                // Teen Non-vegetarian Obese
                new DietPlan("teen", "nonveg", "Obese", "Day 1",
                        "Breakfast: Green Tea + Boiled Egg Whites + Cucumber | Lunch: Large Salad + Grilled Chicken Breast + Steamed Vegetables | Dinner: Clear Chicken Broth + Raw Salad + Green Tea"),
                new DietPlan("teen", "nonveg", "Obese", "Day 2",
                        "Breakfast: Lemon Water + Egg White Omelette + Spinach | Lunch: Steamed Fish + Large Vegetable Salad + Small Brown Rice | Dinner: Grilled Chicken + Raw Vegetables + Mint Water"),
                new DietPlan("teen", "nonveg", "Obese", "Day 3",
                        "Breakfast: Green Tea + Boiled Eggs + Tomatoes | Lunch: Large Salad + Grilled Fish + Steamed Broccoli | Dinner: Clear Fish Soup + Cucumber Salad + Lemon Water"));

        dietPlanRepository.saveAll(dietPlans);
    }
}