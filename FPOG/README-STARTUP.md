# FITNESS POINT MICROSERVICES - STARTUP GUIDE

## 🚀 Quick Start (Using Batch Files)

### Option 1: Start All Services at Once
1. **Double-click** `start-all-services.bat`
2. **Wait** for all services to start (about 1-2 minutes)
3. **Eureka Dashboard** and **Frontend** will open automatically

### Option 2: Manual Service Startup
1. **Start Eureka Server first:**
   ```bash
   cd eureka-server
   mvn spring-boot:run
   ```

2. **Start Diet Plan Service:**
   ```bash
   cd dietplan-service
   mvn spring-boot:run
   ```

3. **Start Fitness Point Application:**
   ```bash
   cd fitnesspoint
   mvn spring-boot:run
   ```

4. **Start API Gateway:**
   ```bash
   cd api-gateway
   mvn spring-boot:run
   ```

## 🌐 Frontend Access

### Main Application
- **URL:** http://localhost:9999
- **Features:**
  - User Registration & Login
  - BMI Calculator
  - Workout Plans
  - Diet Plans
  - User Dashboard

### Service Management
- **Eureka Dashboard:** http://localhost:8761
  - View all registered microservices
  - Monitor service health

### API Access
- **API Gateway:** http://localhost:8080
  - Central entry point for all APIs
  - Routes requests to appropriate services

## 📋 Service Ports

| Service | Port | URL |
|---------|------|-----|
| Eureka Server | 8761 | http://localhost:8761 |
| API Gateway | 8080 | http://localhost:8080 |
| Diet Plan Service | 8081 | http://localhost:8081 |
| Fitness Point App | 9999 | http://localhost:9999 |

## 🛠 Utility Scripts

1. **`start-all-services.bat`** - Start all microservices
2. **`stop-all-services.bat`** - Stop all running services
3. **`access-frontend.bat`** - Check status and open applications

## 📖 How to Use the Frontend

1. **Open Browser:** http://localhost:9999
2. **Register:** Create a new account or login
3. **Navigate:** Use the dashboard to access features:
   - **BMI Calculator:** Calculate Body Mass Index
   - **Workout Plans:** View exercise routines
   - **Diet Plans:** Access nutrition plans
   - **Profile:** Manage user settings

## 🔧 Troubleshooting

### If Services Don't Start:
1. **Check if ports are free:**
   ```bash
   netstat -an | find "8761"  # Eureka
   netstat -an | find "9999"  # Frontend
   ```

2. **Kill existing processes:**
   ```bash
   taskkill /f /im java.exe
   ```

3. **Restart services one by one**

### If Frontend is Not Accessible:
1. **Verify service is running:** Check terminal output
2. **Check database connection:** Ensure MySQL is running
3. **Check Eureka registration:** Visit http://localhost:8761

### Database Setup:
1. **MySQL must be running on port 3306**
2. **Databases required:**
   - `fitnesspoint` (for main app)
   - `fitnesstracker` (for user data)
3. **Credentials:** root/Anshi@090923

## 📱 Application Features

### 🏠 Home Page
- Welcome message
- Navigation to all features
- User authentication status

### 👤 User Management
- Registration with validation
- Secure login with JWT tokens
- Profile management

### 📊 BMI Calculator
- Input height and weight
- Calculate Body Mass Index
- Health category classification

### 💪 Workout Plans
- Browse exercise routines
- Categorized by difficulty
- Detailed instructions

### 🥗 Diet Plans
- Nutrition recommendations
- Meal planning
- Calorie tracking

### 🔒 Security
- JWT-based authentication
- Secure API endpoints
- User session management

---

**Note:** Make sure all services are running before accessing the frontend for full functionality!