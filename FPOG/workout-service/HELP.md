# Workout Service

This is a microservice for managing workout plans and workout sessions in the Fitness Point application.

## Features

- Manage workout types and their calorie burn rates
- Track individual workout sessions
- REST API for workout-related operations
- Integration with Eureka for service discovery

## Endpoints

- GET /api/workouts - Get all workout types
- POST /api/workouts - Create a new workout type
- GET /api/workout-sessions - Get workout sessions for a user
- POST /api/workout-sessions - Record a new workout session

## Database

Uses MySQL database with the following tables:
- workout: Stores workout types and their calorie burn rates
- workout_session: Stores individual workout sessions by users