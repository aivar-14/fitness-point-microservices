const plans = {
      teen: {
        veg: [
          "Breakfast: Oats + Milk + Fruits | Lunch: Rice + Veg Curry + Dal | Dinner: Chapati + Paneer + Salad",
          "Breakfast: Poha + Juice | Lunch: Roti + Veg Curry + Salad | Dinner: Rice + Dal + Veg Curry",
          "Breakfast: Sprouts + Toast | Lunch: Rice + Rajma | Dinner: Roti + Veg + Yogurt",
          "Breakfast: Paratha + Yogurt | Lunch: Rice + Sambar | Dinner: Chapati + Veg Curry",
          "Breakfast: Fruits + Nuts | Lunch: Rice + Veg Curry | Dinner: Roti + Dal",
          "Breakfast: Smoothie | Lunch: Rice + Dal + Veg | Dinner: Chapati + Paneer Curry",
          "Breakfast: Idli/Dosa | Lunch: Rice + Sambar | Dinner: Roti + Veg Curry"
        ],
        nonveg: [
          "Breakfast: Oats + Milk + Eggs | Lunch: Rice + Chicken Curry | Dinner: Chapati + Fish Curry",
          "Breakfast: Poha + Eggs | Lunch: Roti + Chicken Curry | Dinner: Rice + Dal + Fish",
          "Breakfast: Eggs + Toast | Lunch: Rice + Rajma + Chicken | Dinner: Roti + Fish",
          "Breakfast: Paratha + Eggs | Lunch: Rice + Fish Curry | Dinner: Chapati + Chicken",
          "Breakfast: Fruits + Eggs | Lunch: Rice + Chicken Curry | Dinner: Roti + Fish Curry",
          "Breakfast: Smoothie + Boiled Egg | Lunch: Rice + Dal + Chicken | Dinner: Chapati + Chicken Curry",
          "Breakfast: Idli/Dosa + Egg | Lunch: Rice + Fish | Dinner: Roti + Chicken Curry"
        ]
      },
      adult: {
        veg: [
          "Breakfast: Oats + Green Tea | Lunch: Brown Rice + Veg Curry | Dinner: Roti + Paneer + Salad",
          "Breakfast: Smoothie | Lunch: Rice + Dal + Veg Curry | Dinner: Chapati + Veg Curry",
          "Breakfast: Oats + Nuts | Lunch: Roti + Paneer + Veg | Dinner: Rice + Veg Curry",
          "Breakfast: Poha | Lunch: Rice + Rajma | Dinner: Chapati + Salad + Veg",
          "Breakfast: Paratha + Yogurt | Lunch: Brown Rice + Veg Curry | Dinner: Roti + Paneer Curry",
          "Breakfast: Fruits + Green Tea | Lunch: Rice + Sambar | Dinner: Chapati + Veg Curry",
          "Breakfast: Idli/Dosa | Lunch: Rice + Dal + Veg | Dinner: Roti + Veg Curry"
        ],
        nonveg: [
          "Breakfast: Eggs + Green Tea | Lunch: Brown Rice + Grilled Chicken | Dinner: Roti + Fish Curry",
          "Breakfast: Smoothie | Lunch: Rice + Chicken Curry | Dinner: Chapati + Fish",
          "Breakfast: Oats + Eggs | Lunch: Roti + Chicken + Veg | Dinner: Rice + Fish Curry",
          "Breakfast: Poha + Boiled Eggs | Lunch: Rice + Rajma + Chicken | Dinner: Chapati + Chicken",
          "Breakfast: Paratha + Eggs | Lunch: Brown Rice + Chicken Curry | Dinner: Roti + Fish Curry",
          "Breakfast: Fruits + Eggs | Lunch: Rice + Sambar + Chicken | Dinner: Chapati + Chicken",
          "Breakfast: Idli/Dosa + Eggs | Lunch: Rice + Fish Curry | Dinner: Roti + Chicken Curry"
        ]
      },
      senior: {
        veg: [
          "Breakfast: Oats + Milk | Lunch: Rice + Dal + Veg | Dinner: Soft Chapati + Veg Curry",
          "Breakfast: Fruits + Green Tea | Lunch: Khichdi + Veg | Dinner: Roti + Dal + Veg",
          "Breakfast: Idli + Sambar | Lunch: Rice + Dal | Dinner: Chapati + Light Veg Curry",
          "Breakfast: Poha | Lunch: Dalia + Veg | Dinner: Roti + Paneer Curry",
          "Breakfast: Smoothie | Lunch: Rice + Rajma | Dinner: Chapati + Dal",
          "Breakfast: Paratha (low oil) + Yogurt | Lunch: Rice + Veg Curry | Dinner: Roti + Veg Curry",
          "Breakfast: Fruits + Oats | Lunch: Khichdi | Dinner: Chapati + Dal"
        ],
        nonveg: [
          "Breakfast: Oats + Eggs | Lunch: Rice + Chicken Curry | Dinner: Soft Chapati + Fish Curry",
          "Breakfast: Fruits + Eggs | Lunch: Khichdi + Chicken | Dinner: Roti + Dal + Fish",
          "Breakfast: Idli + Eggs | Lunch: Rice + Dal + Chicken | Dinner: Chapati + Fish Curry",
          "Breakfast: Poha + Eggs | Lunch: Dalia + Chicken | Dinner: Roti + Chicken",
          "Breakfast: Smoothie + Egg | Lunch: Rice + Rajma + Fish | Dinner: Chapati + Chicken Curry",
          "Breakfast: Paratha (low oil) + Egg | Lunch: Rice + Chicken Curry | Dinner: Roti + Fish",
          "Breakfast: Fruits + Oats + Egg | Lunch: Khichdi + Fish | Dinner: Chapati + Chicken Curry"
        ]
      }
    };

// Helper: Mark diet as completed (call from UI)
function markDietCompleted(dietPlanId, userId) {
  console.log("Marking diet completed - dietPlanId:", dietPlanId, "userId:", userId);
  
  fetch('/api/diet/complete', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ dietPlanId, userId })
  })
    .then(res => {
      console.log("Response status:", res.status);
      if (res.ok) {
        alert('Diet marked as completed!');
      } else {
        alert('Failed to mark as completed. Status: ' + res.status);
      }
    })
    .catch(error => {
      console.error('Error marking diet as completed:', error);
      alert('Error saving completion status: ' + error.message);
    });
}

// Example: Add a button for each plan in your JS-rendered plan list (call this in your render logic)
// <button onclick="markDietCompleted(DIET_PLAN_ID, USER_ID)">✔️</button>
    function generatePlan() {
      console.log("generatePlan function called");
      const age = document.getElementById("ageInput").value;
      const dietType = document.getElementById("dietType").value;
      const dietPlanDiv = document.getElementById("dietPlan");
      
      console.log("Age:", age, "Diet Type:", dietType);
      
      // Check if BMI information is available
      const bmiCategory = window.bmiCategory;
      const bmiValue = window.bmiValue;
      
      if (bmiCategory) {
        console.log("Using BMI-based plan generation. BMI Category:", bmiCategory, "BMI Value:", bmiValue);
        generateBMIBasedPlan(age, dietType, bmiCategory);
        return;
      }
      
      dietPlanDiv.innerHTML = "";

      if (!age) {
        dietPlanDiv.innerHTML = "<p>Please enter your age.</p>";
        return;
      }

      if (age < 10) {
        alert("For children under 10, please consult a doctor or nutritionist before following a diet plan.");
        return;
      }

      let selectedPlan;

      if (age < 18) {
        selectedPlan = plans.teen[dietType];
        console.log("Selected teen plan for", dietType);
      } else if (age >= 18 && age <= 50) {
        selectedPlan = plans.adult[dietType];
        console.log("Selected adult plan for", dietType);
      } else {
        selectedPlan = plans.senior[dietType];
        console.log("Selected senior plan for", dietType);
      }

      console.log("Selected plan:", selectedPlan);

      if (!selectedPlan) {
        dietPlanDiv.innerHTML = "<p>No diet plans found for this selection.</p>";
        return;
      }

      selectedPlan.forEach((meal, index) => {
        const dayDiv = document.createElement("div");
        dayDiv.classList.add("day");
        dayDiv.innerHTML = `
          <div>
            <h3>Day ${index + 1}</h3>
            <p>${meal}</p>
          </div>
          <button class="completed-btn" onclick="markCompleted(this)">Completed</button>
        `;
        dietPlanDiv.appendChild(dayDiv);
      });
      
      console.log("Diet plan displayed successfully");
    }

    function markCompleted(button) {
      button.classList.toggle("completed");
      if (button.classList.contains("completed")) {
        const userId = window.currentUserId || 1;
        // Generate a more realistic dietPlanId based on the day and content
        const dayText = button.parentNode.querySelector('h3').textContent; // e.g., "Day 1"
        const dayNumber = dayText.replace('Day ', '');
        const mealContent = button.parentNode.querySelector('p').textContent;
        
        // Create a simple hash-based ID from the meal content
        const dietPlanId = Math.abs(mealContent.split('').reduce((a, b) => {
          a = ((a << 5) - a) + b.charCodeAt(0);
          return a & a;
        }, 0)) + parseInt(dayNumber);
        
        console.log("Generated dietPlanId:", dietPlanId, "for day:", dayNumber);
        markDietCompleted(dietPlanId, userId);
        button.style.background = 'green';
        button.style.color = 'white';
        button.textContent = 'Completed ✓';
      } else {
        button.style.background = '';
        button.style.color = '';
        button.textContent = 'Completed';
      }
    }

    // BMI-based diet plan generation
    function generateBMIBasedPlan(age, dietType, bmiCategory) {
      console.log("Generating BMI-based plan for category:", bmiCategory);
      const dietPlanDiv = document.getElementById("dietPlan");
      dietPlanDiv.innerHTML = "";
      
      // Add BMI-specific recommendations header
      const bmiHeader = document.createElement("div");
      bmiHeader.innerHTML = `
        <div style="background: linear-gradient(135deg, #6366f1, #a855f7); color: white; padding: 15px; border-radius: 10px; margin-bottom: 20px;">
          <h3 style="margin: 0 0 10px 0;">🎯 BMI-Optimized Diet Plan</h3>
          <p style="margin: 0; opacity: 0.9;">Specially tailored for ${bmiCategory} category</p>
        </div>
      `;
      dietPlanDiv.appendChild(bmiHeader);

      // Get age group
      let ageGroup;
      if (age < 18) ageGroup = "teen";
      else if (age >= 18 && age <= 50) ageGroup = "adult";
      else ageGroup = "senior";

      // Get BMI-specific modifications to base plans
      let selectedPlan = plans[ageGroup][dietType];
      if (!selectedPlan) {
        dietPlanDiv.innerHTML += "<p>No diet plans found for this selection.</p>";
        return;
      }

      // Apply BMI-specific modifications
      selectedPlan = applyBMIModifications(selectedPlan.slice(), bmiCategory);

      selectedPlan.forEach((meal, index) => {
        const dayDiv = document.createElement("div");
        dayDiv.classList.add("day");
        dayDiv.innerHTML = `
          <div>
            <h3>Day ${index + 1}</h3>
            <p>${meal}</p>
            <div style="font-size: 12px; color: #6b7280; margin-top: 5px; font-style: italic;">
              ${getBMITip(bmiCategory, index)}
            </div>
          </div>
          <button class="completed-btn" onclick="markCompleted(this)">Completed</button>
        `;
        dietPlanDiv.appendChild(dayDiv);
      });
    }

    // Apply BMI-specific modifications to meal plans
    function applyBMIModifications(basePlans, bmiCategory) {
      const modifications = {
        "Underweight": {
          additions: [
            " + Nuts",
            " + Avocado",
            " + Extra Ghee",
            " + Protein Shake",
            " + Dates",
            " + Full-fat Yogurt",
            " + Banana"
          ]
        },
        "Overweight": {
          replacements: [
            ["Rice", "Brown Rice"],
            ["Chapati", "Multi-grain Roti"],
            ["Paratha", "Oats"],
            ["Full-fat", "Low-fat"]
          ],
          additions: [
            " + Green Tea",
            " + Cucumber",
            " + Extra Salad",
            " + Lemon Water"
          ]
        },
        "Obese": {
          replacements: [
            ["Rice", "Quinoa"],
            ["Chapati", "Multi-grain Roti"],
            ["Paratha", "Vegetable Poha"],
            ["Curry", "Steamed Vegetables"],
            ["Full-fat", "Fat-free"]
          ],
          additions: [
            " + Green Tea",
            " + Raw Vegetables",
            " + Fiber supplements"
          ]
        }
      };

      const mods = modifications[bmiCategory];
      if (!mods) return basePlans; // Normal category or no modifications

      return basePlans.map(plan => {
        let modifiedPlan = plan;
        
        // Apply replacements
        if (mods.replacements) {
          mods.replacements.forEach(([from, to]) => {
            modifiedPlan = modifiedPlan.replace(new RegExp(from, 'gi'), to);
          });
        }
        
        // Apply additions (randomly add one addition per plan)
        if (mods.additions) {
          const randomAddition = mods.additions[Math.floor(Math.random() * mods.additions.length)];
          modifiedPlan += randomAddition;
        }
        
        return modifiedPlan;
      });
    }

    // Get BMI-specific tips for each day
    function getBMITip(bmiCategory, dayIndex) {
      const tips = {
        "Underweight": [
          "Focus on calorie-dense, nutrient-rich foods",
          "Add healthy fats like nuts and seeds",
          "Eat frequent, smaller meals throughout the day",
          "Include protein with every meal",
          "Stay hydrated but don't drink too much before meals",
          "Consider adding a bedtime snack",
          "Include strength training exercises"
        ],
        "Normal": [
          "Maintain your current healthy eating habits",
          "Continue with balanced portions",
          "Stay active with regular exercise",
          "Keep hydrated throughout the day",
          "Include variety in your meals",
          "Listen to your body's hunger cues",
          "Maintain a consistent meal schedule"
        ],
        "Overweight": [
          "Focus on portion control",
          "Choose whole grains over refined ones",
          "Increase vegetable intake",
          "Limit sugary drinks and snacks",
          "Include more fiber in your diet",
          "Stay active with cardio exercises",
          "Drink water before meals"
        ],
        "Obese": [
          "Prioritize vegetables and lean proteins",
          "Avoid processed and fried foods",
          "Practice mindful eating",
          "Control portion sizes strictly",
          "Increase physical activity gradually",
          "Consider consulting a nutritionist",
          "Track your food intake"
        ]
      };
      
      const categoryTips = tips[bmiCategory] || tips["Normal"];
      return categoryTips[dayIndex % categoryTips.length];
    }


// ✅ NEW function to fetch data from the backend
function fetchAndDisplayDietPlans() {
    const age = document.getElementById("ageInput").value;
    const dietType = document.getElementById("dietType").value;
    const dietPlanDiv = document.getElementById("dietPlan");
    dietPlanDiv.innerHTML = "";

    if (!age || age < 10) {
        // Your original validation
        if (!age) {
            dietPlanDiv.innerHTML = "<p>Please enter your age.</p>";
        } else {
            alert("For children under 10, please consult a doctor or nutritionist before following a diet plan.");
        }
        return;
    }

    let ageGroup;
    if (age < 18) {
        ageGroup = "teen";
    } else if (age >= 18 && age <= 50) {
        ageGroup = "adult";
    } else {
        ageGroup = "senior";
    }

    // This is the fetch call to your new microservice API via the Gateway
    fetch(`/api/dietplan-service/api/diet?ageGroup=${ageGroup}&type=${dietType}`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to fetch diet plans.');
        }
        return response.json();
    })
    .then(plans => {
        if (plans.length === 0) {
            dietPlanDiv.innerHTML = "<p>No diet plans found for this selection.</p>";
            return;
        }

        plans.forEach(plan => {
            const dayDiv = document.createElement("div");
            dayDiv.classList.add("day");
            dayDiv.innerHTML = `
                <div>
                    <h3>${plan.day}</h3>
                    <p>${plan.meal}</p>
                </div>
                <button class="completed-btn" onclick="markCompletedFromApi(${plan.id})">Completed</button>
            `;
            dietPlanDiv.appendChild(dayDiv);
        });
    })
    .catch(error => {
        console.error('Error fetching diet plans:', error);
        dietPlanDiv.innerHTML = "<p>An error occurred. Please try again later.</p>";
    });
}

// ✅ NEW function to handle completion when fetching from the API
function markCompletedFromApi(dietPlanId) {
    const userId = window.currentUserId || 1; // Get userId from the Thymeleaf variable

    if (!userId) {
        alert("User is not logged in. Cannot mark as completed.");
        return;
    }

    markDietCompleted(dietPlanId, userId);

    // Optional: Update the button's appearance (you can copy your original logic here)
    const button = event.target;
    button.classList.toggle("completed");
    if (button.classList.contains("completed")) {
        button.style.background = 'green';
        button.style.color = 'white';
    } else {
        button.style.background = '';
        button.style.color = '';
    }
}