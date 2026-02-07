@echo off
echo =========================================
echo    FITNESS POINT MICROSERVICES STARTER
echo =========================================
echo.
echo Starting all services...
echo.

REM Create a logs directory if it doesn't exist
if not exist "logs" mkdir logs

echo [1/5] Starting Eureka Server...
start "Eureka Server" cmd /k "cd eureka-server && mvn spring-boot:run"
echo Waiting for Eureka Server to start...
timeout /t 15 /nobreak >nul

echo [2/5] Starting Diet Plan Service...
start "Diet Plan Service" cmd /k "cd dietplan-service && mvn spring-boot:run"
echo Waiting for Diet Plan Service to start...
timeout /t 10 /nobreak >nul

echo [3/5] Starting Workout Service...
start "Workout Service" cmd /k "cd workout-service && mvn spring-boot:run"
echo Waiting for Workout Service to start...
timeout /t 10 /nobreak >nul

echo [4/5] Starting Fitness Point Application...
start "Fitness Point App" cmd /k "cd fitnesspoint && mvn spring-boot:run"
echo Waiting for Fitness Point App to start...
timeout /t 10 /nobreak >nul

echo [5/5] Starting API Gateway...
start "API Gateway" cmd /k "cd api-gateway && mvn spring-boot:run"
echo Waiting for API Gateway to start...
timeout /t 10 /nobreak >nul

echo.
echo =========================================
echo    ALL SERVICES STARTED SUCCESSFULLY!
echo =========================================
echo.
echo Service URLs:
echo - Eureka Server Dashboard: http://localhost:8761
echo - Fitness Point Frontend: http://localhost:9999
echo - Diet Plan Service API:  http://localhost:8081
echo - Workout Service API:    http://localhost:8083
echo - API Gateway:            http://localhost:8080
echo.
echo Opening Eureka Dashboard and Frontend...
timeout /t 5 /nobreak >nul

REM Open Eureka Dashboard
start "" "http://localhost:8761"

REM Open Frontend Application
start "" "http://localhost:9999"

echo.
echo =========================================
echo    SETUP COMPLETE!
echo =========================================
echo.
echo To stop all services:
echo 1. Close all the command windows that opened
echo 2. Or run: stop-all-services.bat
echo.
pause