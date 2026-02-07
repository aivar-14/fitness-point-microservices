// Toggle feature for login/register on login.html
document.addEventListener("DOMContentLoaded", function() {
  const container = document.getElementById("container");
  const registerBtn = document.getElementById("register");
  const loginBtn = document.getElementById("login");

  if (registerBtn && loginBtn && container) {
    registerBtn.addEventListener("click", () => {
      container.classList.add("active");
    });
    loginBtn.addEventListener("click", () => {
      container.classList.remove("active");
    });
  }
});
document.getElementById('bmiForm').addEventListener('submit', function(e) {
      e.preventDefault();
      let height = parseFloat(document.getElementById('height').value);
      let weight = parseFloat(document.getElementById('weight').value);
      if (height > 0 && weight > 0) {
        let bmi = weight / ((height / 100) ** 2);
        let bmiRounded = bmi.toFixed(2);
        document.getElementById('bmiResult').textContent = bmiRounded;

        let advice = '';
        if (bmi < 18.5) {
          advice = 'Underweight: Focus on nutrient-rich foods and strength building.';
        } else if (bmi < 25) {
          advice = 'Normal: Keep up your balanced routine!';
        } else if (bmi < 30) {
          advice = 'Overweight: Try regular cardio and healthy eating.';
        } else {
          advice = 'Obese: Consult a health professional for personalized advice.';
        }
        document.getElementById('bmiAdvice').textContent = advice;
      } else {
        document.getElementById('bmiResult').textContent = '';
        document.getElementById('bmiAdvice').textContent = 'Please enter valid height and weight.';
      }
    });

    document.getElementById('bmiForm').addEventListener('reset', function() {
      document.getElementById('bmiResult').textContent = '';
      document.getElementById('bmiAdvice').textContent = '';
    });