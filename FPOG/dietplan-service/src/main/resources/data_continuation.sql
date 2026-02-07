-- Continuation of BMI-Based Diet Plans for Adults and Seniors

-- ==========================================
-- NORMAL BMI CATEGORY - ADULT PLANS
-- ==========================================

-- Normal Adult Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('adult', 'veg', 'Normal', 'Day 1', 'Breakfast: Oats + Almond Milk + Berries + Green Tea | Lunch: Quinoa + Dal + Mixed Vegetables + Salad | Dinner: Multi-grain Roti + Paneer Curry + Yogurt', NOW(), NOW()),
('adult', 'veg', 'Normal', 'Day 2', 'Breakfast: Smoothie Bowl + Granola + Green Tea | Lunch: Brown Rice + Chickpea Curry + Salad | Dinner: Chapati + Vegetable Curry + Buttermilk', NOW(), NOW()),
('adult', 'veg', 'Normal', 'Day 3', 'Breakfast: Avocado Toast + Green Tea + Fruits | Lunch: Rice + Sambar + Mixed Vegetables | Dinner: Roti + Dal + Salad + Yogurt', NOW(), NOW()),
('adult', 'veg', 'Normal', 'Day 4', 'Breakfast: Chia Pudding + Fruits + Coffee | Lunch: Rice + Rajma + Cucumber Salad | Dinner: Multi-grain Chapati + Paneer + Vegetables', NOW(), NOW()),
('adult', 'veg', 'Normal', 'Day 5', 'Breakfast: Green Smoothie + Nuts + Green Tea | Lunch: Quinoa Salad + Dal + Steamed Vegetables | Dinner: Roti + Vegetable Curry + Milk', NOW(), NOW()),
('adult', 'veg', 'Normal', 'Day 6', 'Breakfast: Oatmeal + Banana + Coffee | Lunch: Brown Rice + Chole + Mixed Salad | Dinner: Chapati + Palak Paneer + Yogurt', NOW(), NOW()),
('adult', 'veg', 'Normal', 'Day 7', 'Breakfast: Fruit Salad + Nuts + Green Tea | Lunch: Rice + Vegetable Biryani + Raita | Dinner: Multi-grain Roti + Dal + Salad', NOW(), NOW());

-- Normal Adult Non-Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('adult', 'nonveg', 'Normal', 'Day 1', 'Breakfast: Protein Omelette + Toast + Green Tea | Lunch: Brown Rice + Grilled Chicken + Salad | Dinner: Multi-grain Roti + Fish Curry + Vegetables', NOW(), NOW()),
('adult', 'nonveg', 'Normal', 'Day 2', 'Breakfast: Scrambled Eggs + Avocado + Coffee | Lunch: Rice + Fish Curry + Dal | Dinner: Chapati + Chicken + Mixed Salad', NOW(), NOW()),
('adult', 'nonveg', 'Normal', 'Day 3', 'Breakfast: Boiled Eggs + Fruits + Green Tea | Lunch: Quinoa + Chicken Breast + Vegetables | Dinner: Roti + Fish + Yogurt', NOW(), NOW()),
('adult', 'nonveg', 'Normal', 'Day 4', 'Breakfast: Protein Smoothie + Eggs + Toast | Lunch: Rice + Mutton Curry + Salad | Dinner: Multi-grain Chapati + Grilled Fish + Vegetables', NOW(), NOW()),
('adult', 'nonveg', 'Normal', 'Day 5', 'Breakfast: Egg Benedict + Coffee | Lunch: Brown Rice + Chicken Curry + Mixed Salad | Dinner: Roti + Fish Curry + Dal', NOW(), NOW()),
('adult', 'nonveg', 'Normal', 'Day 6', 'Breakfast: Omelette + Fruits + Green Tea | Lunch: Rice + Prawn Curry + Vegetables | Dinner: Chapati + Chicken + Salad', NOW(), NOW()),
('adult', 'nonveg', 'Normal', 'Day 7', 'Breakfast: Scrambled Eggs + Toast + Coffee | Lunch: Quinoa + Grilled Chicken + Salad | Dinner: Multi-grain Roti + Fish + Mixed Vegetables', NOW(), NOW());

-- ==========================================
-- NORMAL BMI CATEGORY - SENIOR PLANS
-- ==========================================

-- Normal Senior Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('senior', 'veg', 'Normal', 'Day 1', 'Breakfast: Soft Oats + Warm Milk + Banana | Lunch: Rice + Dal + Soft Vegetables | Dinner: Soft Chapati + Light Vegetable Curry + Yogurt', NOW(), NOW()),
('senior', 'veg', 'Normal', 'Day 2', 'Breakfast: Fruits + Green Tea + Honey | Lunch: Khichdi + Vegetables + Ghee | Dinner: Soft Roti + Dal + Buttermilk', NOW(), NOW()),
('senior', 'veg', 'Normal', 'Day 3', 'Breakfast: Idli + Sambar + Coconut Chutney | Lunch: Rice + Light Dal + Soft Vegetables | Dinner: Chapati + Paneer + Warm Milk', NOW(), NOW()),
('senior', 'veg', 'Normal', 'Day 4', 'Breakfast: Poha + Green Tea + Fruits | Lunch: Dalia + Vegetable Curry + Yogurt | Dinner: Soft Roti + Dal + Light Vegetables', NOW(), NOW()),
('senior', 'veg', 'Normal', 'Day 5', 'Breakfast: Smoothie + Soft Fruits | Lunch: Rice + Rajma + Soft Salad | Dinner: Chapati + Light Curry + Warm Milk', NOW(), NOW()),
('senior', 'veg', 'Normal', 'Day 6', 'Breakfast: Soft Paratha + Yogurt + Honey | Lunch: Rice + Sambar + Soft Vegetables | Dinner: Roti + Dal + Light Soup', NOW(), NOW()),
('senior', 'veg', 'Normal', 'Day 7', 'Breakfast: Fruits + Oats + Warm Milk | Lunch: Khichdi + Light Curry | Dinner: Soft Chapati + Dal + Yogurt', NOW(), NOW());

-- Normal Senior Non-Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('senior', 'nonveg', 'Normal', 'Day 1', 'Breakfast: Soft Boiled Eggs + Toast + Green Tea | Lunch: Rice + Chicken Soup + Soft Vegetables | Dinner: Soft Chapati + Fish Curry + Warm Milk', NOW(), NOW()),
('senior', 'nonveg', 'Normal', 'Day 2', 'Breakfast: Scrambled Eggs + Fruits + Warm Water | Lunch: Khichdi + Chicken Pieces + Light Curry | Dinner: Soft Roti + Fish + Yogurt', NOW(), NOW()),
('senior', 'nonveg', 'Normal', 'Day 3', 'Breakfast: Omelette + Soft Toast + Green Tea | Lunch: Rice + Fish Curry + Dal | Dinner: Chapati + Chicken Soup + Warm Milk', NOW(), NOW()),
('senior', 'nonveg', 'Normal', 'Day 4', 'Breakfast: Boiled Eggs + Banana + Warm Water | Lunch: Soft Rice + Chicken Curry + Light Vegetables | Dinner: Soft Roti + Fish + Light Soup', NOW(), NOW()),
('senior', 'nonveg', 'Normal', 'Day 5', 'Breakfast: Egg Curry + Soft Bread + Green Tea | Lunch: Rice + Fish Soup + Soft Vegetables | Dinner: Chapati + Chicken + Warm Milk', NOW(), NOW()),
('senior', 'nonveg', 'Normal', 'Day 6', 'Breakfast: Scrambled Eggs + Fruits + Warm Water | Lunch: Khichdi + Fish Pieces + Light Dal | Dinner: Soft Roti + Chicken Curry + Yogurt', NOW(), NOW()),
('senior', 'nonveg', 'Normal', 'Day 7', 'Breakfast: Soft Omelette + Toast + Green Tea | Lunch: Rice + Chicken Soup + Soft Curry | Dinner: Chapati + Fish + Warm Milk', NOW(), NOW());

-- ==========================================
-- OVERWEIGHT BMI CATEGORY - SENIOR PLANS
-- ==========================================

-- Overweight Senior Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('senior', 'veg', 'Overweight', 'Day 1', 'Breakfast: Green Tea + Soft Fruits + Oats (small portion) | Lunch: Brown Rice (small) + Dal + Steamed Vegetables | Dinner: Soft Multi-grain Roti + Light Vegetable Soup + Green Tea', NOW(), NOW()),
('senior', 'veg', 'Overweight', 'Day 2', 'Breakfast: Lemon Water + Soft Vegetable Salad + Green Tea | Lunch: Dalia + Light Dal + Soft Steamed Vegetables | Dinner: Small Chapati + Clear Vegetable Broth + Cucumber Water', NOW(), NOW()),
('senior', 'veg', 'Overweight', 'Day 3', 'Breakfast: Green Tea + Soft Sprouts + Warm Water | Lunch: Small Brown Rice + Moong Dal + Soft Vegetables | Dinner: Multi-grain Roti + Light Soup + Herbal Tea', NOW(), NOW()),
('senior', 'veg', 'Overweight', 'Day 4', 'Breakfast: Herbal Tea + Soft Fruits + Lemon Water | Lunch: Quinoa (small) + Light Dal + Steamed Soft Vegetables | Dinner: Soft Chapati + Vegetable Broth + Green Tea', NOW(), NOW()),
('senior', 'veg', 'Overweight', 'Day 5', 'Breakfast: Green Tea + Soft Salad + Warm Water | Lunch: Small Khichdi + Light Vegetables | Dinner: Multi-grain Roti + Clear Soup + Mint Water', NOW(), NOW()),
('senior', 'veg', 'Overweight', 'Day 6', 'Breakfast: Lemon Ginger Water + Soft Fruits + Green Tea | Lunch: Brown Rice (small) + Light Sambar + Soft Vegetables | Dinner: Soft Roti + Vegetable Broth + Herbal Tea', NOW(), NOW()),
('senior', 'veg', 'Overweight', 'Day 7', 'Breakfast: Green Tea + Soft Vegetable Salad + Warm Water | Lunch: Small Dalia + Light Dal + Steamed Vegetables | Dinner: Multi-grain Chapati + Clear Soup + Cucumber Water', NOW(), NOW());

-- Overweight Senior Non-Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('senior', 'nonveg', 'Overweight', 'Day 1', 'Breakfast: Green Tea + Soft Boiled Egg White + Cucumber | Lunch: Small Brown Rice + Light Chicken Soup + Soft Vegetables | Dinner: Soft Multi-grain Roti + Clear Fish Broth + Herbal Tea', NOW(), NOW()),
('senior', 'nonveg', 'Overweight', 'Day 2', 'Breakfast: Lemon Water + Egg White Scramble + Green Tea | Lunch: Small Portion Steamed Fish + Light Vegetables + Clear Soup | Dinner: Soft Chapati + Chicken Broth + Cucumber Water', NOW(), NOW()),
('senior', 'nonveg', 'Overweight', 'Day 3', 'Breakfast: Green Tea + Soft Boiled Eggs + Warm Water | Lunch: Small Rice + Light Fish Curry + Soft Steamed Vegetables | Dinner: Multi-grain Roti + Clear Chicken Soup + Mint Water', NOW(), NOW()),
('senior', 'nonveg', 'Overweight', 'Day 4', 'Breakfast: Herbal Tea + Egg Whites + Soft Vegetables | Lunch: Small Khichdi + Light Chicken Pieces + Clear Broth | Dinner: Soft Roti + Fish Soup + Green Tea', NOW(), NOW()),
('senior', 'nonveg', 'Overweight', 'Day 5', 'Breakfast: Green Tea + Scrambled Egg Whites + Lemon Water | Lunch: Small Brown Rice + Steamed Fish + Light Vegetables | Dinner: Multi-grain Chapati + Clear Broth + Cucumber Water', NOW(), NOW()),
('senior', 'nonveg', 'Overweight', 'Day 6', 'Breakfast: Lemon Ginger Water + Boiled Eggs + Green Tea | Lunch: Small Portion Chicken Soup + Soft Vegetables + Light Rice | Dinner: Soft Roti + Fish Broth + Herbal Tea', NOW(), NOW()),
('senior', 'nonveg', 'Overweight', 'Day 7', 'Breakfast: Green Tea + Egg White Omelette + Warm Water | Lunch: Small Rice + Light Fish Curry + Steamed Vegetables | Dinner: Multi-grain Chapati + Clear Chicken Soup + Mint Water', NOW(), NOW());

-- ==========================================
-- OBESE BMI CATEGORY - ADULT PLANS
-- ==========================================

-- Obese Adult Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('adult', 'veg', 'Obese', 'Day 1', 'Breakfast: Green Tea + Large Vegetable Salad + Lemon Water | Lunch: Large Mixed Salad + Steamed Vegetables + Small Quinoa Portion | Dinner: Clear Vegetable Broth + Raw Vegetables + Herbal Tea', NOW(), NOW()),
('adult', 'veg', 'Obese', 'Day 2', 'Breakfast: Detox Water + Green Smoothie (no sugar) + Green Tea | Lunch: Steamed Broccoli + Large Salad + Small Brown Rice | Dinner: Vegetable Soup + Cucumber Salad + Mint Water', NOW(), NOW()),
('adult', 'veg', 'Obese', 'Day 3', 'Breakfast: Lemon Ginger Water + Sprouts + Green Tea | Lunch: Large Vegetable Salad + Steamed Spinach + Small Dal Portion | Dinner: Clear Broth + Raw Vegetable Salad + Green Tea', NOW(), NOW()),
('adult', 'veg', 'Obese', 'Day 4', 'Breakfast: Green Tea + Cucumber Tomato Salad + Detox Water | Lunch: Steamed Mixed Vegetables + Large Salad + Minimal Quinoa | Dinner: Vegetable Broth + Raw Vegetables + Herbal Tea', NOW(), NOW()),
('adult', 'veg', 'Obese', 'Day 5', 'Breakfast: Apple Cider Vinegar Water + Green Salad + Green Tea | Lunch: Large Salad + Steamed Cabbage + Small Moong Dal | Dinner: Clear Vegetable Soup + Cucumber Salad + Lemon Water', NOW(), NOW()),
('adult', 'veg', 'Obese', 'Day 6', 'Breakfast: Green Tea + Mixed Green Salad + Warm Water | Lunch: Steamed Vegetables + Large Raw Salad + Small Brown Rice | Dinner: Vegetable Broth + Raw Vegetable Mix + Mint Water', NOW(), NOW()),
('adult', 'veg', 'Obese', 'Day 7', 'Breakfast: Detox Water + Green Vegetable Juice + Green Tea | Lunch: Large Mixed Salad + Steamed Vegetables + Minimal Quinoa | Dinner: Clear Soup + Raw Vegetables + Herbal Tea', NOW(), NOW());

-- Obese Adult Non-Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('adult', 'nonveg', 'Obese', 'Day 1', 'Breakfast: Green Tea + Boiled Egg Whites + Large Cucumber Salad | Lunch: Grilled Chicken Breast + Large Mixed Salad + Steamed Vegetables | Dinner: Clear Chicken Broth + Raw Vegetable Salad + Green Tea', NOW(), NOW()),
('adult', 'nonveg', 'Obese', 'Day 2', 'Breakfast: Lemon Water + Egg White Omelette + Green Vegetables | Lunch: Grilled Fish + Large Salad + Steamed Broccoli | Dinner: Fish Broth + Cucumber Salad + Herbal Tea', NOW(), NOW()),
('adult', 'nonveg', 'Obese', 'Day 3', 'Breakfast: Green Tea + Scrambled Egg Whites + Tomato Salad | Lunch: Lean Chicken + Large Raw Salad + Steamed Vegetables | Dinner: Clear Chicken Soup + Raw Vegetables + Lemon Water', NOW(), NOW()),
('adult', 'nonveg', 'Obese', 'Day 4', 'Breakfast: Detox Water + Boiled Eggs + Green Salad | Lunch: Grilled Fish + Mixed Vegetable Salad + Steamed Spinach | Dinner: Fish Broth + Large Cucumber Salad + Green Tea', NOW(), NOW()),
('adult', 'nonveg', 'Obese', 'Day 5', 'Breakfast: Green Tea + Egg White Scramble + Raw Vegetables | Lunch: Chicken Breast + Large Salad + Steamed Vegetables | Dinner: Clear Broth + Raw Vegetable Mix + Mint Water', NOW(), NOW()),
('adult', 'nonveg', 'Obese', 'Day 6', 'Breakfast: Lemon Ginger Water + Boiled Egg Whites + Green Vegetables | Lunch: Grilled Fish + Large Mixed Salad + Steamed Broccoli | Dinner: Chicken Broth + Raw Salad + Herbal Tea', NOW(), NOW()),
('adult', 'nonveg', 'Obese', 'Day 7', 'Breakfast: Green Tea + Egg White Omelette + Large Salad | Lunch: Lean Chicken + Mixed Vegetable Salad + Steamed Vegetables | Dinner: Clear Fish Soup + Raw Vegetables + Cucumber Water', NOW(), NOW());

-- ==========================================
-- OBESE BMI CATEGORY - SENIOR PLANS  
-- ==========================================

-- Obese Senior Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('senior', 'veg', 'Obese', 'Day 1', 'Breakfast: Warm Green Tea + Soft Vegetable Salad + Lemon Water | Lunch: Soft Steamed Vegetables + Small Dal + Warm Water | Dinner: Clear Vegetable Broth + Soft Salad + Herbal Tea', NOW(), NOW()),
('senior', 'veg', 'Obese', 'Day 2', 'Breakfast: Warm Lemon Water + Soft Fruits + Green Tea | Lunch: Light Khichdi + Soft Steamed Vegetables + Clear Broth | Dinner: Vegetable Soup + Soft Cucumber Salad + Warm Water', NOW(), NOW()),
('senior', 'veg', 'Obese', 'Day 3', 'Breakfast: Green Tea + Soft Sprouts + Warm Water | Lunch: Soft Steamed Vegetables + Light Dal + Small Portion | Dinner: Clear Broth + Soft Raw Vegetables + Herbal Tea', NOW(), NOW()),
('senior', 'veg', 'Obese', 'Day 4', 'Breakfast: Warm Detox Water + Soft Green Salad + Green Tea | Lunch: Light Vegetable Soup + Soft Steamed Vegetables + Minimal Rice | Dinner: Clear Broth + Soft Salad + Warm Water', NOW(), NOW()),
('senior', 'veg', 'Obese', 'Day 5', 'Breakfast: Green Tea + Soft Vegetable Juice + Warm Water | Lunch: Soft Steamed Mixed Vegetables + Light Soup + Small Dal | Dinner: Vegetable Broth + Soft Raw Salad + Herbal Tea', NOW(), NOW()),
('senior', 'veg', 'Obese', 'Day 6', 'Breakfast: Warm Lemon Water + Soft Salad + Green Tea | Lunch: Light Khichdi + Soft Vegetables + Clear Soup | Dinner: Vegetable Broth + Soft Cucumber Salad + Warm Water', NOW(), NOW()),
('senior', 'veg', 'Obese', 'Day 7', 'Breakfast: Green Tea + Soft Green Vegetables + Warm Detox Water | Lunch: Soft Steamed Vegetables + Light Soup + Minimal Rice | Dinner: Clear Broth + Soft Salad + Herbal Tea', NOW(), NOW());

-- Obese Senior Non-Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('senior', 'nonveg', 'Obese', 'Day 1', 'Breakfast: Warm Green Tea + Soft Boiled Egg Whites + Cucumber | Lunch: Light Chicken Soup + Soft Steamed Vegetables + Clear Broth | Dinner: Fish Broth + Soft Vegetable Salad + Herbal Tea', NOW(), NOW()),
('senior', 'nonveg', 'Obese', 'Day 2', 'Breakfast: Warm Lemon Water + Soft Egg White Scramble + Green Tea | Lunch: Soft Steamed Fish + Light Vegetables + Clear Soup | Dinner: Chicken Broth + Soft Salad + Warm Water', NOW(), NOW()),
('senior', 'nonveg', 'Obese', 'Day 3', 'Breakfast: Green Tea + Soft Boiled Eggs + Warm Water | Lunch: Light Fish Soup + Soft Steamed Vegetables + Minimal Broth | Dinner: Clear Chicken Soup + Soft Raw Vegetables + Herbal Tea', NOW(), NOW()),
('senior', 'nonveg', 'Obese', 'Day 4', 'Breakfast: Warm Detox Water + Soft Egg Whites + Green Tea | Lunch: Light Chicken Pieces + Soft Vegetables + Clear Broth | Dinner: Fish Soup + Soft Salad + Warm Water', NOW(), NOW()),
('senior', 'nonveg', 'Obese', 'Day 5', 'Breakfast: Green Tea + Soft Scrambled Egg Whites + Lemon Water | Lunch: Soft Steamed Fish + Light Vegetables + Clear Soup | Dinner: Chicken Broth + Soft Raw Vegetables + Herbal Tea', NOW(), NOW()),
('senior', 'nonveg', 'Obese', 'Day 6', 'Breakfast: Warm Lemon Water + Soft Boiled Eggs + Green Tea | Lunch: Light Fish Soup + Soft Steamed Vegetables + Clear Broth | Dinner: Chicken Soup + Soft Salad + Warm Water', NOW(), NOW()),
('senior', 'nonveg', 'Obese', 'Day 7', 'Breakfast: Green Tea + Soft Egg White Omelette + Warm Water | Lunch: Light Chicken Soup + Soft Vegetables + Minimal Broth | Dinner: Fish Broth + Soft Raw Vegetables + Herbal Tea', NOW(), NOW());