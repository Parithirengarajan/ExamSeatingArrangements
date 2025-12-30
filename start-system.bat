@echo off
echo Starting Exam Seating Arrangement System...

echo.
echo 1. Starting MySQL Database...
cd database
echo Please run the init.sql script in your MySQL server

echo.
echo 2. Starting Backend API...
cd ..\backend
start cmd /k "mvn spring-boot:run"

echo.
echo 3. Starting React Frontend...
cd ..\frontend-web
start cmd /k "npm start"

echo.
echo System is starting up...
echo Backend API: http://localhost:8080
echo Frontend Web: http://localhost:3000
echo.
echo To run JavaFX Desktop App:
echo cd frontend-desktop
echo mvn javafx:run

pause