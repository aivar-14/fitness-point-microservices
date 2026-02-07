 let timer, seconds = 0, isRunning = false;

    const calorieRates = {
      running: 0.12,       // cal/min/kg
      cycling: 0.10,
      yoga: 0.05,
      weightlifting: 0.08,
      hiit: 0.14
    };

    function showTimer() {
      const weight = document.getElementById("weight").value;
      const workout = document.getElementById("workout").value;

      if (!weight || weight <= 0) {
        alert("⚠️ Please enter a valid weight.");
        return;
      }
      if (!workout) {
        alert("⚠️ Please select a workout type.");
        return;
      }

      document.getElementById("timer-section").style.display = "block";
    }

    function updateDisplay() {
      let mins = String(Math.floor(seconds / 60)).padStart(2, '0');
      let secs = String(seconds % 60).padStart(2, '0');
      document.getElementById("display").textContent = `${mins}:${secs}`;
    }

    function startTimer() {
      if (!isRunning) {
        isRunning = true;
        timer = setInterval(() => {
          seconds++;
          updateDisplay();
        }, 1000);
      }
    }

    function stopTimer() {
      if (isRunning) {
        clearInterval(timer);
        isRunning = false;

        const weight = parseFloat(document.getElementById("weight").value);
        const workout = document.getElementById("workout").value;
        let minutes = seconds / 60;
        let calories = minutes * weight * calorieRates[workout];

          document.getElementById("result").textContent =
            `🔥 You burned ~${calories.toFixed(2)} calories in ${minutes.toFixed(1)} min of ${workout}.`;

          // Save workout session automatically
          // TODO: Replace userId with actual logged-in user id if available
          const userId = window.currentUserId || 1;
          fetch('/api/workout/session', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
              userId: userId,
              workoutName: workout,
              caloriesBurned: calories,
              minutes: minutes
            })
          }).then(res => {
            if (res.ok) {
              // Optionally show a confirmation
              // alert('Workout session saved!');
            } else {
              alert('Failed to save workout session.');
            }
          });
      }
    }

    function resetTimer() {
      clearInterval(timer);
      seconds = 0;
      isRunning = false;
      updateDisplay();
      document.getElementById("result").textContent = "";
    }

    // Initialize
    updateDisplay();