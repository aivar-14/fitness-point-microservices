
const menuBtn = document.getElementById("menu-btn");
const navLinks = document.getElementById("nav-links");
const menuBtnIcon = menuBtn.querySelector("i");

menuBtn.addEventListener("click", () => {
  navLinks.classList.toggle("open");
  const isOpen = navLinks.classList.contains("open");
  menuBtnIcon.setAttribute("class", isOpen ? "ri-close-line" : "ri-menu-line");
});

navLinks.addEventListener("click", () => {
  navLinks.classList.remove("open");
  menuBtnIcon.setAttribute("class", "ri-menu-line");
});

// ================= WATER INTAKE =================
let waterCount = parseInt(localStorage.getItem("waterCount")) || 0;
const maxGlasses = 8;
const waterDisplay = document.getElementById("water-count");
const water = document.getElementById("water");
const addWaterBtn = document.getElementById("add-water");
const resetWaterBtn = document.getElementById("reset-water");

addWaterBtn.addEventListener("click", () => {
  if (waterCount < maxGlasses) {
    waterCount++;
    updateJar();
    localStorage.setItem("waterCount", waterCount);
  } else {
    // overflow animation
    water.classList.add("overflow");
    setTimeout(() => water.classList.remove("overflow"), 800);
  }
});

resetWaterBtn.addEventListener("click", () => {
  waterCount = 0;
  updateJar();
  localStorage.setItem("waterCount", waterCount);
});

function updateJar() {
  waterDisplay.textContent = waterCount;
  const fillHeight = (waterCount / maxGlasses) * 100;
  water.style.height = fillHeight + "%";
}
updateJar(); // Load saved value on page load

// ================= SLEEP HOURS =================
let sleepHours = parseInt(localStorage.getItem("sleepHours")) || 0;
const sleepCount = document.getElementById("sleep-count");
const addSleepBtn = document.getElementById("add-sleep");
const resetSleepBtn = document.getElementById("reset-sleep");

addSleepBtn.addEventListener("click", () => {
  sleepHours++;
  sleepCount.textContent = sleepHours;
  localStorage.setItem("sleepHours", sleepHours);
});

resetSleepBtn.addEventListener("click", () => {
  sleepHours = 0;
  sleepCount.textContent = sleepHours;
  localStorage.setItem("sleepHours", sleepHours);
});

sleepCount.textContent = sleepHours; // Load saved value on page load

// ================= BMI TRACKER =================
const bmiForm = document.getElementById("bmi-form");
const bmiResult = document.getElementById("bmi-result");
const bmiAdvice = document.getElementById("bmi-advice");

function calculateBMI(weight, height) {
  const bmi = (weight / (height * height)).toFixed(1);
  return parseFloat(bmi);
}

bmiForm?.addEventListener("submit", (e) => {
  e.preventDefault();
  const weight = parseFloat(document.getElementById("weight").value);
  const height = parseFloat(document.getElementById("height").value) / 100; // cm → m

  if (!weight || !height) return;

  const bmi = calculateBMI(weight, height);
  let advice = "";

  if (bmi < 18.5) advice = "Underweight - Eat more nutritious food.";
  else if (bmi < 24.9) advice = "Normal weight - Keep it up!";
  else if (bmi < 29.9) advice = "Overweight - Exercise regularly.";
  else advice = "Obese - Consult a doctor.";

  bmiResult.textContent = bmi;
  bmiAdvice.textContent = advice;

  // Save to localStorage
  localStorage.setItem("bmiValue", bmi);
  localStorage.setItem("bmiAdvice", advice);
});

// Load saved BMI on page load
const savedBMI = localStorage.getItem("bmiValue");
const savedAdvice = localStorage.getItem("bmiAdvice");
if (savedBMI && savedAdvice) {
  bmiResult.textContent = savedBMI;
  bmiAdvice.textContent = savedAdvice;
}

// ================= SCROLL REVEAL (unchanged) =================
const scrollRevealOption = {
  origin: "bottom",
  distance: "50px",
  duration: 1000,
};

ScrollReveal().reveal(".header__image img", { ...scrollRevealOption, origin: "right" });
ScrollReveal().reveal(".header__content h1", { ...scrollRevealOption, delay: 500 });
ScrollReveal().reveal(".header__content h2", { ...scrollRevealOption, delay: 1000 });
ScrollReveal().reveal(".header__content p", { ...scrollRevealOption, delay: 1500 });
ScrollReveal().reveal(".header__btn", { ...scrollRevealOption, delay: 2000 });

ScrollReveal().reveal(".about__image img", { ...scrollRevealOption, origin: "left" });
ScrollReveal().reveal(".about__content .section__header", { ...scrollRevealOption, delay: 500 });
ScrollReveal().reveal(".about__content p", { ...scrollRevealOption, delay: 1000 });
ScrollReveal().reveal(".about__btn", { ...scrollRevealOption, delay: 1500 });

ScrollReveal().reveal(".service__card", { duration: 1000, interval: 500 });
ScrollReveal().reveal(".facility__content .section__header", { ...scrollRevealOption });
ScrollReveal().reveal(".facility__content p", { ...scrollRevealOption, delay: 500 });
ScrollReveal().reveal(".mentor__card", { ...scrollRevealOption, interval: 500 });
ScrollReveal().reveal(".banner__content h2", { ...scrollRevealOption });
ScrollReveal().reveal(".banner__content p", { ...scrollRevealOption, delay: 500 });
