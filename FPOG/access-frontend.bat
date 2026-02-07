@echo off
echo =========================================
echo    FITNESS POINT - QUICK START GUIDE
echo =========================================
echo.
echo This script will check service status and provide access links.
echo.

echo Checking service status...
echo.

REM Check if ports are in use
echo [Eureka Server - Port 8761]
netstat -an | find "8761" >nul
if %errorlevel% == 0 (
    echo ✓ RUNNING
) else (
    echo ✗ NOT RUNNING
)

echo [Diet Plan Service - Port 8081]
netstat -an | find "8081" >nul
if %errorlevel% == 0 (
    echo ✓ RUNNING
) else (
    echo ✗ NOT RUNNING
)

echo [Fitness Point App - Port 9999]
netstat -an | find "9999" >nul
if %errorlevel% == 0 (
    echo ✓ RUNNING
) else (
    echo ✗ NOT RUNNING
)

echo [API Gateway - Port 8080]
netstat -an | find "8080" >nul
if %errorlevel% == 0 (
    echo ✓ RUNNING
) else (
    echo ✗ NOT RUNNING
)

echo.
echo =========================================
echo    ACCESS YOUR APPLICATION
echo =========================================
echo.
echo 1. FRONTEND APPLICATION:
echo    URL: http://localhost:9999
echo    Features: Login, Registration, BMI Calculator, 
echo             Workout Plans, Diet Plans
echo.
echo 2. EUREKA SERVICE REGISTRY:
echo    URL: http://localhost:8761
echo    View: All registered microservices
echo.
echo 3. API GATEWAY:
echo    URL: http://localhost:8080
echo    Purpose: Central entry point for all APIs
echo.
echo Choose an option:
echo [1] Open Frontend Application
echo [2] Open Eureka Dashboard  
echo [3] Open Both
echo [4] Exit
echo.
set /p choice="Enter your choice (1-4): "

if "%choice%"=="1" (
    start "" "http://localhost:9999"
    echo Frontend opened in browser.
) else if "%choice%"=="2" (
    start "" "http://localhost:8761"
    echo Eureka Dashboard opened in browser.
) else if "%choice%"=="3" (
    start "" "http://localhost:9999"
    start "" "http://localhost:8761"
    echo Both applications opened in browser.
) else if "%choice%"=="4" (
    exit
) else (
    echo Invalid choice. Exiting...
)

echo.
pause