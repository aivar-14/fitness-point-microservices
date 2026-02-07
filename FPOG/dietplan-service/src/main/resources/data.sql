-- BMI-Based Diet Plans
-- This file populates the database with diet plans specifically tailored for different BMI categories

-- Clear existing data if needed (optional)
-- DELETE FROM diet_plan WHERE bmi_category IS NOT NULL;

-- ==========================================
-- UNDERWEIGHT BMI CATEGORY DIET PLANS
-- ==========================================

-- Underweight Teen Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('teen', 'veg', 'Underweight', 'Day 1', 'Breakfast: Banana Oats + Full-fat Milk + Almonds + Dates | Lunch: Brown Rice + Dal + Paneer Curry + Ghee | Dinner: Whole Wheat Chapati + Mixed Veg + Yogurt + Nuts', NOW(), NOW()),
('teen', 'veg', 'Underweight', 'Day 2', 'Breakfast: Smoothie (Mango + Banana + Nuts + Milk) | Lunch: Rice + Rajma + Avocado Salad | Dinner: Chapati + Paneer Butter Masala + Sweet Lassi', NOW(), NOW()),
('teen', 'veg', 'Underweight', 'Day 3', 'Breakfast: Sprouts + Whole Grain Toast + Peanut Butter | Lunch: Rice + Sambar + Coconut Chutney | Dinner: Roti + Dal + Ghee + Mixed Nuts', NOW(), NOW()),
('teen', 'veg', 'Underweight', 'Day 4', 'Breakfast: Stuffed Paratha + Full-fat Yogurt + Honey | Lunch: Rice + Chole + Cucumber Raita | Dinner: Chapati + Palak Paneer + Milk with Turmeric', NOW(), NOW()),
('teen', 'veg', 'Underweight', 'Day 5', 'Breakfast: Mixed Fruits + Nuts + Cream | Lunch: Rice + Kidney Bean Curry + Ghee | Dinner: Roti + Aloo Gobi + Buttermilk + Dates', NOW(), NOW()),
('teen', 'veg', 'Underweight', 'Day 6', 'Breakfast: Protein Smoothie + Oats + Berries | Lunch: Rice + Dal + Veg Curry + Papad | Dinner: Chapati + Paneer Tikka + Full-fat Milk', NOW(), NOW()),
('teen', 'veg', 'Underweight', 'Day 7', 'Breakfast: Masala Dosa + Coconut Chutney + Sambar | Lunch: Rice + Fish Curry (for non-strict veg) | Dinner: Roti + Mixed Vegetable Curry + Kheer', NOW(), NOW());

-- Underweight Teen Non-Vegetarian Plans  
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('teen', 'nonveg', 'Underweight', 'Day 1', 'Breakfast: Scrambled Eggs + Whole Grain Toast + Avocado | Lunch: Rice + Chicken Curry + Ghee | Dinner: Chapati + Fish Curry + Full-fat Yogurt', NOW(), NOW()),
('teen', 'nonveg', 'Underweight', 'Day 2', 'Breakfast: Protein Smoothie + Boiled Eggs + Nuts | Lunch: Rice + Mutton Curry + Salad | Dinner: Roti + Chicken Tikka + Milk', NOW(), NOW()),
('teen', 'nonveg', 'Underweight', 'Day 3', 'Breakfast: Omelette + Cheese + Toast + Butter | Lunch: Rice + Fish Curry + Dal | Dinner: Chapati + Chicken Curry + Lassi', NOW(), NOW()),
('teen', 'nonveg', 'Underweight', 'Day 4', 'Breakfast: Egg Paratha + Yogurt + Honey | Lunch: Rice + Prawn Curry + Vegetables | Dinner: Roti + Chicken Biryani + Raita', NOW(), NOW()),
('teen', 'nonveg', 'Underweight', 'Day 5', 'Breakfast: Scrambled Eggs + Fruits + Nuts | Lunch: Rice + Lamb Curry + Ghee | Dinner: Chapati + Fish Fry + Buttermilk', NOW(), NOW()),
('teen', 'nonveg', 'Underweight', 'Day 6', 'Breakfast: Protein Shake + Boiled Eggs + Banana | Lunch: Rice + Chicken Masala + Salad | Dinner: Roti + Fish Curry + Full-fat Milk', NOW(), NOW()),
('teen', 'nonveg', 'Underweight', 'Day 7', 'Breakfast: Egg Sandwich + Cheese + Milk | Lunch: Rice + Mutton Biryani + Raita | Dinner: Chapati + Chicken Curry + Ice Cream', NOW(), NOW());

-- Underweight Adult Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('adult', 'veg', 'Underweight', 'Day 1', 'Breakfast: Quinoa Porridge + Nuts + Dried Fruits + Milk | Lunch: Brown Rice + Dal + Paneer + Ghee | Dinner: Multi-grain Roti + Vegetable Curry + Yogurt + Almonds', NOW(), NOW()),
('adult', 'veg', 'Underweight', 'Day 2', 'Breakfast: Avocado Toast + Nuts + Green Tea | Lunch: Rice + Chickpea Curry + Coconut Oil | Dinner: Chapati + Paneer Makhani + Milk with Turmeric', NOW(), NOW()),
('adult', 'veg', 'Underweight', 'Day 3', 'Breakfast: Smoothie Bowl + Granola + Seeds | Lunch: Rice + Rajma + Salad with Olive Oil | Dinner: Roti + Dal + Ghee + Mixed Nuts', NOW(), NOW()),
('adult', 'veg', 'Underweight', 'Day 4', 'Breakfast: Stuffed Paratha + Yogurt + Jaggery | Lunch: Rice + Sambar + Coconut Chutney | Dinner: Chapati + Aloo Matar + Buttermilk + Dates', NOW(), NOW()),
('adult', 'veg', 'Underweight', 'Day 5', 'Breakfast: Oats + Banana + Peanut Butter + Milk | Lunch: Rice + Chole + Cucumber Raita | Dinner: Roti + Paneer Curry + Kheer', NOW(), NOW()),
('adult', 'veg', 'Underweight', 'Day 6', 'Breakfast: Chia Pudding + Fruits + Nuts + Honey | Lunch: Rice + Vegetable Biryani + Raita | Dinner: Chapati + Dal Makhani + Full-fat Milk', NOW(), NOW()),
('adult', 'veg', 'Underweight', 'Day 7', 'Breakfast: Masala Dosa + Coconut Chutney + Coffee | Lunch: Rice + Palak Paneer + Papad | Dinner: Roti + Mixed Veg Curry + Ice Cream', NOW(), NOW());

-- Underweight Adult Non-Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('adult', 'nonveg', 'Underweight', 'Day 1', 'Breakfast: Protein Omelette + Avocado + Whole Grain Toast | Lunch: Rice + Chicken Curry + Ghee + Salad | Dinner: Chapati + Fish Curry + Full-fat Yogurt', NOW(), NOW()),
('adult', 'nonveg', 'Underweight', 'Day 2', 'Breakfast: Scrambled Eggs + Cheese + Toast + Coffee | Lunch: Rice + Mutton Curry + Vegetables | Dinner: Roti + Chicken Tikka + Milk Shake', NOW(), NOW()),
('adult', 'nonveg', 'Underweight', 'Day 3', 'Breakfast: Protein Smoothie + Boiled Eggs + Nuts | Lunch: Rice + Fish Curry + Dal | Dinner: Chapati + Chicken Biryani + Raita', NOW(), NOW()),
('adult', 'nonveg', 'Underweight', 'Day 4', 'Breakfast: Egg Benedict + Hollandaise + Fruits | Lunch: Rice + Prawn Curry + Coconut Milk | Dinner: Roti + Lamb Curry + Lassi', NOW(), NOW()),
('adult', 'nonveg', 'Underweight', 'Day 5', 'Breakfast: French Toast + Eggs + Butter + Honey | Lunch: Rice + Chicken Masala + Ghee | Dinner: Chapati + Fish Fry + Buttermilk + Nuts', NOW(), NOW()),
('adult', 'nonveg', 'Underweight', 'Day 6', 'Breakfast: Protein Pancakes + Eggs + Syrup | Lunch: Rice + Mutton Biryani + Salad | Dinner: Roti + Chicken Curry + Full-fat Milk', NOW(), NOW()),
('adult', 'nonveg', 'Underweight', 'Day 7', 'Breakfast: Egg Sandwich + Cheese + Avocado + Juice | Lunch: Rice + Fish Curry + Coconut Chutney | Dinner: Chapati + Chicken Tikka Masala + Ice Cream', NOW(), NOW());

-- ==========================================
-- OVERWEIGHT BMI CATEGORY DIET PLANS  
-- ==========================================

-- Overweight Teen Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('teen', 'veg', 'Overweight', 'Day 1', 'Breakfast: Oats + Skimmed Milk + Berries + Green Tea | Lunch: Brown Rice + Dal + Steamed Vegetables | Dinner: Multi-grain Roti + Vegetable Curry + Cucumber Salad', NOW(), NOW()),
('teen', 'veg', 'Overweight', 'Day 2', 'Breakfast: Vegetable Poha + Green Tea + Lemon Water | Lunch: Quinoa + Chickpea Curry + Raw Salad | Dinner: Roti + Palak + Low-fat Yogurt', NOW(), NOW()),
('teen', 'veg', 'Overweight', 'Day 3', 'Breakfast: Sprouts Salad + Whole Grain Toast + Green Tea | Lunch: Brown Rice + Sambar + Steamed Broccoli | Dinner: Multi-grain Chapati + Dal + Cucumber Water', NOW(), NOW()),
('teen', 'veg', 'Overweight', 'Day 4', 'Breakfast: Smoothie (Spinach + Apple + Water) + Oats | Lunch: Millet + Vegetable Curry + Salad | Dinner: Roti + Bottle Gourd Curry + Buttermilk', NOW(), NOW()),
('teen', 'veg', 'Overweight', 'Day 5', 'Breakfast: Green Tea + Mixed Fruits + Almonds (limited) | Lunch: Brown Rice + Moong Dal + Steamed Vegetables | Dinner: Chapati + Cabbage Curry + Lemon Water', NOW(), NOW()),
('teen', 'veg', 'Overweight', 'Day 6', 'Breakfast: Vegetable Upma + Green Tea + Tomatoes | Lunch: Quinoa Salad + Chickpeas + Cucumber | Dinner: Multi-grain Roti + Spinach Dal + Raw Vegetables', NOW(), NOW()),
('teen', 'veg', 'Overweight', 'Day 7', 'Breakfast: Dalia + Skimmed Milk + Berries + Green Tea | Lunch: Brown Rice + Rajma + Large Salad | Dinner: Roti + Mixed Vegetable Curry + Mint Water', NOW(), NOW());

-- Overweight Teen Non-Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('teen', 'nonveg', 'Overweight', 'Day 1', 'Breakfast: Boiled Eggs + Whole Grain Toast + Green Tea | Lunch: Brown Rice + Grilled Chicken + Salad | Dinner: Multi-grain Roti + Fish Curry + Cucumber', NOW(), NOW()),
('teen', 'nonveg', 'Overweight', 'Day 2', 'Breakfast: Egg White Omelette + Vegetables + Green Tea | Lunch: Quinoa + Chicken Breast + Steamed Vegetables | Dinner: Roti + Fish + Tomato Salad', NOW(), NOW()),
('teen', 'nonveg', 'Overweight', 'Day 3', 'Breakfast: Boiled Eggs + Spinach + Lemon Water | Lunch: Brown Rice + Grilled Fish + Raw Salad | Dinner: Chapati + Chicken Soup + Cucumber Water', NOW(), NOW()),
('teen', 'nonveg', 'Overweight', 'Day 4', 'Breakfast: Protein Smoothie (Egg White + Berries) | Lunch: Millet + Lean Chicken + Vegetables | Dinner: Roti + Fish Curry + Mint Water', NOW(), NOW()),
('teen', 'nonveg', 'Overweight', 'Day 5', 'Breakfast: Scrambled Egg Whites + Toast + Green Tea | Lunch: Brown Rice + Chicken Salad + Lemon Dressing | Dinner: Multi-grain Chapati + Grilled Fish + Salad', NOW(), NOW()),
('teen', 'nonveg', 'Overweight', 'Day 6', 'Breakfast: Boiled Eggs + Green Vegetables + Water | Lunch: Quinoa + Turkey/Chicken + Steamed Broccoli | Dinner: Roti + Fish + Raw Vegetables', NOW(), NOW()),
('teen', 'nonveg', 'Overweight', 'Day 7', 'Breakfast: Egg White Scramble + Vegetables + Green Tea | Lunch: Brown Rice + Grilled Chicken + Large Salad | Dinner: Chapati + Fish Curry + Cucumber Mint Water', NOW(), NOW());

-- Overweight Adult Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('adult', 'veg', 'Overweight', 'Day 1', 'Breakfast: Green Smoothie + Oats + Chia Seeds + Green Tea | Lunch: Quinoa + Dal + Large Mixed Salad | Dinner: Multi-grain Roti + Vegetable Soup + Cucumber Water', NOW(), NOW()),
('adult', 'veg', 'Overweight', 'Day 2', 'Breakfast: Vegetable Juice + Whole Grain Toast + Green Tea | Lunch: Brown Rice + Chickpea Curry + Raw Vegetables | Dinner: Millet Roti + Spinach + Lemon Water', NOW(), NOW()),
('adult', 'veg', 'Overweight', 'Day 3', 'Breakfast: Fruit Salad + Nuts (limited) + Green Tea | Lunch: Quinoa Salad + Moong Dal + Steamed Vegetables | Dinner: Multi-grain Chapati + Bottle Gourd + Mint Water', NOW(), NOW()),
('adult', 'veg', 'Overweight', 'Day 4', 'Breakfast: Vegetable Upma + Green Tea + Lemon Water | Lunch: Brown Rice + Sambar + Large Salad + Cucumber | Dinner: Roti + Dal + Raw Vegetable Salad', NOW(), NOW()),
('adult', 'veg', 'Overweight', 'Day 5', 'Breakfast: Green Tea + Sprouts + Tomatoes + Cucumber | Lunch: Millet + Vegetable Curry + Cabbage Salad | Dinner: Multi-grain Roti + Palak + Buttermilk (low-fat)', NOW(), NOW()),
('adult', 'veg', 'Overweight', 'Day 6', 'Breakfast: Smoothie Bowl + Berries + Green Tea | Lunch: Quinoa + Chickpeas + Mixed Vegetables | Dinner: Chapati + Vegetable Soup + Cucumber Mint Water', NOW(), NOW()),
('adult', 'veg', 'Overweight', 'Day 7', 'Breakfast: Dalia + Skimmed Milk + Fruits + Green Tea | Lunch: Brown Rice + Rajma + Large Raw Salad | Dinner: Roti + Mixed Vegetable Curry + Lemon Water', NOW(), NOW());

-- ==========================================
-- OBESE BMI CATEGORY DIET PLANS
-- ==========================================

-- Obese Teen Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('teen', 'veg', 'Obese', 'Day 1', 'Breakfast: Green Tea + Vegetable Juice + Small Bowl Oats | Lunch: Steamed Vegetables + Small Bowl Brown Rice + Dal | Dinner: Large Vegetable Salad + 1 Multi-grain Roti + Green Tea', NOW(), NOW()),
('teen', 'veg', 'Obese', 'Day 2', 'Breakfast: Lemon Water + Sprouts + Green Tea | Lunch: Large Salad + Steamed Broccoli + Small Bowl Quinoa | Dinner: Vegetable Soup + 1 Roti + Cucumber Water', NOW(), NOW()),
('teen', 'veg', 'Obese', 'Day 3', 'Breakfast: Green Smoothie + Chia Seeds + Water | Lunch: Steamed Vegetables + Moong Dal + Small Brown Rice | Dinner: Large Raw Salad + Vegetable Broth + Green Tea', NOW(), NOW()),
('teen', 'veg', 'Obese', 'Day 4', 'Breakfast: Green Tea + Vegetable Salad + Lemon Water | Lunch: Steamed Cabbage + Dal + Small Millet Portion | Dinner: Vegetable Soup + 1 Multi-grain Chapati + Mint Water', NOW(), NOW()),
('teen', 'veg', 'Obese', 'Day 5', 'Breakfast: Detox Water + Green Vegetables + Green Tea | Lunch: Large Salad + Steamed Spinach + Small Quinoa | Dinner: Clear Vegetable Broth + Raw Vegetables + Lemon Water', NOW(), NOW()),
('teen', 'veg', 'Obese', 'Day 6', 'Breakfast: Green Tea + Cucumber + Tomato Salad | Lunch: Steamed Mixed Vegetables + Small Dal + Brown Rice | Dinner: Large Salad + Vegetable Soup + Cucumber Mint Water', NOW(), NOW()),
('teen', 'veg', 'Obese', 'Day 7', 'Breakfast: Lemon Ginger Water + Green Salad + Green Tea | Lunch: Steamed Vegetables + Small Bowl Sambar + Minimal Rice | Dinner: Raw Vegetable Salad + Clear Soup + Herbal Tea', NOW(), NOW());

-- Obese Teen Non-Vegetarian Plans  
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('teen', 'nonveg', 'Obese', 'Day 1', 'Breakfast: Green Tea + Boiled Egg Whites + Cucumber | Lunch: Large Salad + Grilled Chicken Breast + Steamed Vegetables | Dinner: Clear Chicken Broth + Raw Salad + Green Tea', NOW(), NOW()),
('teen', 'nonveg', 'Obese', 'Day 2', 'Breakfast: Lemon Water + Egg White Omelette + Spinach | Lunch: Steamed Fish + Large Vegetable Salad + Small Brown Rice | Dinner: Grilled Chicken + Raw Vegetables + Mint Water', NOW(), NOW()),
('teen', 'nonveg', 'Obese', 'Day 3', 'Breakfast: Green Tea + Boiled Eggs + Tomatoes | Lunch: Large Salad + Grilled Fish + Steamed Broccoli | Dinner: Clear Fish Soup + Cucumber Salad + Lemon Water', NOW(), NOW()),
('teen', 'nonveg', 'Obese', 'Day 4', 'Breakfast: Detox Water + Egg Whites + Green Vegetables | Lunch: Chicken Salad + Steamed Vegetables + Small Quinoa | Dinner: Grilled Fish + Large Raw Salad + Green Tea', NOW(), NOW()),
('teen', 'nonveg', 'Obese', 'Day 5', 'Breakfast: Green Tea + Scrambled Egg Whites + Spinach | Lunch: Large Salad + Lean Chicken + Steamed Cabbage | Dinner: Clear Chicken Broth + Raw Vegetables + Cucumber Water', NOW(), NOW()),
('teen', 'nonveg', 'Obese', 'Day 6', 'Breakfast: Lemon Ginger Water + Boiled Eggs + Cucumber | Lunch: Grilled Fish + Mixed Vegetable Salad + Steamed Vegetables | Dinner: Chicken Soup + Raw Salad + Herbal Tea', NOW(), NOW()),
('teen', 'nonveg', 'Obese', 'Day 7', 'Breakfast: Green Tea + Egg White Scramble + Tomatoes | Lunch: Large Chicken Salad + Steamed Vegetables + Small Brown Rice | Dinner: Grilled Fish + Raw Vegetable Salad + Mint Water', NOW(), NOW());

-- ==========================================
-- NORMAL BMI CATEGORY DIET PLANS
-- (Balanced maintenance plans)
-- ==========================================

-- Normal Teen Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('teen', 'veg', 'Normal', 'Day 1', 'Breakfast: Balanced Oats + Milk + Fruits | Lunch: Rice + Dal + Vegetable Curry + Salad | Dinner: Chapati + Paneer + Mixed Vegetables + Yogurt', NOW(), NOW()),
('teen', 'veg', 'Normal', 'Day 2', 'Breakfast: Poha + Green Tea + Fruits | Lunch: Brown Rice + Sambar + Vegetable Curry | Dinner: Roti + Dal + Salad + Buttermilk', NOW(), NOW()),
('teen', 'veg', 'Normal', 'Day 3', 'Breakfast: Smoothie + Whole Grain Toast | Lunch: Rice + Rajma + Mixed Salad | Dinner: Chapati + Vegetable Curry + Yogurt', NOW(), NOW()),
('teen', 'veg', 'Normal', 'Day 4', 'Breakfast: Paratha + Yogurt + Fruits | Lunch: Rice + Chickpea Curry + Vegetables | Dinner: Roti + Dal + Salad + Milk', NOW(), NOW()),
('teen', 'veg', 'Normal', 'Day 5', 'Breakfast: Fruits + Nuts + Milk | Lunch: Rice + Vegetable Biryani + Raita | Dinner: Chapati + Paneer Curry + Salad', NOW(), NOW()),
('teen', 'veg', 'Normal', 'Day 6', 'Breakfast: Upma + Green Tea + Fruits | Lunch: Rice + Dal + Vegetable Curry + Papad | Dinner: Roti + Mixed Vegetables + Yogurt', NOW(), NOW()),
('teen', 'veg', 'Normal', 'Day 7', 'Breakfast: Dosa + Sambar + Coconut Chutney | Lunch: Rice + Chole + Salad | Dinner: Chapati + Dal + Vegetable Curry + Milk', NOW(), NOW());

-- Normal Teen Non-Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('teen', 'nonveg', 'Normal', 'Day 1', 'Breakfast: Eggs + Toast + Milk | Lunch: Rice + Chicken Curry + Salad | Dinner: Chapati + Fish Curry + Vegetables + Yogurt', NOW(), NOW()),
('teen', 'nonveg', 'Normal', 'Day 2', 'Breakfast: Omelette + Fruits + Green Tea | Lunch: Rice + Fish Curry + Dal | Dinner: Roti + Chicken + Mixed Salad + Milk', NOW(), NOW()),
('teen', 'nonveg', 'Normal', 'Day 3', 'Breakfast: Boiled Eggs + Toast + Juice | Lunch: Rice + Mutton Curry + Vegetables | Dinner: Chapati + Fish + Dal + Buttermilk', NOW(), NOW()),
('teen', 'nonveg', 'Normal', 'Day 4', 'Breakfast: Scrambled Eggs + Fruits + Milk | Lunch: Rice + Chicken Biryani + Raita | Dinner: Roti + Fish Curry + Salad + Yogurt', NOW(), NOW()),
('teen', 'nonveg', 'Normal', 'Day 5', 'Breakfast: Egg Sandwich + Green Tea + Fruits | Lunch: Rice + Prawn Curry + Vegetables | Dinner: Chapati + Chicken + Dal + Milk', NOW(), NOW()),
('teen', 'nonveg', 'Normal', 'Day 6', 'Breakfast: Protein Smoothie + Eggs + Toast | Lunch: Rice + Fish Curry + Mixed Salad | Dinner: Roti + Chicken Curry + Vegetables + Yogurt', NOW(), NOW()),
('teen', 'nonveg', 'Normal', 'Day 7', 'Breakfast: Omelette + Fruits + Milk | Lunch: Rice + Mutton Curry + Dal | Dinner: Chapati + Fish + Salad + Buttermilk', NOW(), NOW());

-- Underweight Senior Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('senior', 'veg', 'Underweight', 'Day 1', 'Breakfast: Warm Milk + Oats + Honey + Nuts | Lunch: Rice + Dal + Ghee + Soft Vegetables | Dinner: Soft Chapati + Paneer + Full-fat Yogurt + Dates', NOW(), NOW()),
('senior', 'veg', 'Underweight', 'Day 2', 'Breakfast: Banana Smoothie + Full-fat Milk + Almonds | Lunch: Rice + Sambar + Coconut + Ghee | Dinner: Soft Roti + Dal + Butter + Sweet Lassi', NOW(), NOW()),
('senior', 'veg', 'Underweight', 'Day 3', 'Breakfast: Soft Fruits + Cream + Honey + Nuts | Lunch: Rice + Vegetable Curry + Ghee + Soft Salad | Dinner: Chapati + Paneer + Full-fat Milk + Kheer', NOW(), NOW()),
('senior', 'veg', 'Underweight', 'Day 4', 'Breakfast: Warm Oats + Banana + Full-fat Milk + Dates | Lunch: Rice + Chole + Ghee + Soft Vegetables | Dinner: Soft Roti + Dal + Yogurt + Nuts', NOW(), NOW()),
('senior', 'veg', 'Underweight', 'Day 5', 'Breakfast: Smoothie + Mango + Milk + Honey + Nuts | Lunch: Rice + Rajma + Butter + Soft Curry | Dinner: Chapati + Paneer Curry + Sweet Milk', NOW(), NOW()),
('senior', 'veg', 'Underweight', 'Day 6', 'Breakfast: Soft Paratha + Full-fat Yogurt + Honey + Almonds | Lunch: Rice + Dal + Ghee + Soft Mixed Vegetables | Dinner: Roti + Vegetable Curry + Full-fat Milk + Dates', NOW(), NOW()),
('senior', 'veg', 'Underweight', 'Day 7', 'Breakfast: Warm Milk + Soft Fruits + Nuts + Cream | Lunch: Rice + Sambar + Coconut Chutney + Ghee | Dinner: Soft Chapati + Dal + Paneer + Kheer', NOW(), NOW());

-- Underweight Senior Non-Vegetarian Plans
INSERT INTO diet_plan (age_group, type, bmi_category, day, meal, created_at, updated_at) VALUES
('senior', 'nonveg', 'Underweight', 'Day 1', 'Breakfast: Soft Boiled Eggs + Milk + Toast + Butter | Lunch: Rice + Chicken Soup + Ghee + Soft Vegetables | Dinner: Soft Chapati + Fish Curry + Full-fat Yogurt', NOW(), NOW()),
('senior', 'nonveg', 'Underweight', 'Day 2', 'Breakfast: Scrambled Eggs + Cream + Soft Toast + Honey | Lunch: Rice + Fish Curry + Coconut Milk + Soft Salad | Dinner: Roti + Chicken + Sweet Milk', NOW(), NOW()),
('senior', 'nonveg', 'Underweight', 'Day 3', 'Breakfast: Egg Custard + Soft Fruits + Full-fat Milk | Lunch: Rice + Mutton Soup + Ghee + Soft Vegetables | Dinner: Soft Chapati + Fish + Yogurt + Nuts', NOW(), NOW()),
('senior', 'nonveg', 'Underweight', 'Day 4', 'Breakfast: Soft Omelette + Cheese + Milk + Honey | Lunch: Rice + Chicken Curry + Butter + Soft Curry | Dinner: Roti + Fish Soup + Full-fat Milk + Dates', NOW(), NOW()),
('senior', 'nonveg', 'Underweight', 'Day 5', 'Breakfast: Boiled Eggs + Banana + Cream + Nuts | Lunch: Rice + Fish + Coconut Oil + Soft Vegetables | Dinner: Soft Chapati + Chicken + Sweet Lassi', NOW(), NOW()),
('senior', 'nonveg', 'Underweight', 'Day 6', 'Breakfast: Egg Soup + Soft Toast + Butter + Milk | Lunch: Rice + Mutton Curry + Ghee + Soft Salad | Dinner: Roti + Fish Curry + Full-fat Yogurt + Almonds', NOW(), NOW()),
('senior', 'nonveg', 'Underweight', 'Day 7', 'Breakfast: Scrambled Eggs + Soft Fruits + Cream + Honey | Lunch: Rice + Chicken Soup + Coconut Milk + Ghee | Dinner: Soft Chapati + Fish + Sweet Milk + Kheer', NOW(), NOW());