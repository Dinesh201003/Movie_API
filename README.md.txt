# Movie Management REST API

## Description
A simple Spring Boot REST API to manage movies using in-memory storage.
This project demonstrates basic backend development using Java and REST principles.

## Technologies Used
- Java 17
- Spring Boot
- Maven
- Postman

## How to Run the Application
1. Clone the repository
2. Open the project in VS Code
3. Run the command:
   .\mvnw spring-boot:run
4. Server runs on:
   http://localhost:8080

## API Endpoints

### Add Movie
POST /api/movies

Request Body:
```json
{
  "name": "Inception",
  "description": "Sci-fi thriller",
  "genre": "Sci-Fi",
  "rating": 9.0
}
