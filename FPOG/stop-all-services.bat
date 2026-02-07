@echo off
echo =========================================
echo    STOPPING FITNESS POINT SERVICES
echo =========================================
echo.

echo Stopping all Java processes for Spring Boot applications...

REM Kill Java processes running Spring Boot applications
for /f "tokens=2" %%i in ('tasklist /fi "imagename eq java.exe" /fo table /nh') do (
    echo Stopping process %%i
    taskkill /pid %%i /f >nul 2>&1
)

REM Alternative: Kill processes by window title
taskkill /fi "windowtitle eq Eureka Server*" /f >nul 2>&1
taskkill /fi "windowtitle eq Diet Plan Service*" /f >nul 2>&1
taskkill /fi "windowtitle eq Workout Service*" /f >nul 2>&1
taskkill /fi "windowtitle eq Fitness Point App*" /f >nul 2>&1
taskkill /fi "windowtitle eq API Gateway*" /f >nul 2>&1

echo.
echo All services have been stopped.
echo.
pause