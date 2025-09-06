# Student Performance Tracker

## Overview
Student Performance Tracker is a Spring Boot application that provides RESTful APIs for managing students and their marks. 
It allows users to perform CRUD operations on students, add marks, and retrieve performance-based analytics such as top/bottom performers, students in a marks range, or students with exact scores.  

The application uses **MySQL** for persistent storage, **Spring Data JPA** for ORM, and is fully tested with **JUnit 5** and **Mockito**. APIs are accessible via **Postman** or directly through a browser using Swagger UI.

---

## Features
- Create, read, update, and delete student records.
- Add marks to students and manage their marks list.
- Retrieve top-performing and bottom-performing students.
- Query students within a specific marks range.
- Query students with exact average marks.
- Global exception handling with meaningful error messages.
- API documentation available via Swagger UI.
- Fully tested using JUnit and Mockito.

---

## Technologies Used
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA / Hibernate**
- **MySQL 8**
- **SpringDoc OpenAPI (Swagger)**
- **JUnit 5 & Mockito for testing**
- Maven for project management

---

## Getting Started

### Prerequisites
- Java 17
- Maven
- MySQL Server
- Postman (optional, for API testing)

Project Structure
src/
├─ main/
│  ├─ java/com/example/demo/
│  │  ├─ config/      # Swagger configuration
│  │  ├─ controller/  # REST controllers
│  │  ├─ dto/         # Data Transfer Objects
│  │  ├─ exception/   # Global exception handling
│  │  ├─ model/       # JPA entities
│  │  ├─ repository/  # JPA repositories
│  │  └─ service/     # Business logic
│  └─ resources/
│     └─ application.properties
├─ test/               # JUnit & Mockito tests

### Setup Steps
1. Clone the repository:
bash
git clone https://github.com/yourusername/student-performance-tracker.git
cd student-performance-tracker

   git clone https://github.com/your-username/student-performance-tracker.git




Build and run the application:

mvn clean install
mvn spring-boot:run


Open Swagger UI at: http://localhost:8080/swagger-ui.html to test APIs.

Open Postman Tool and perform operations by passing in the form of JSON and visualize the changes everywhere

<img width="1594" height="843" alt="Screenshot 2025-09-06 164827" src="https://github.com/user-attachments/assets/33c91265-f2cb-48f7-aeb2-510435d60b79" />


API Endpoints
Students

GET /api/students - Retrieve all students

GET /api/students/{id} - Get student by ID

POST /api/students - Add new student

PUT /api/students/id/{id} - Update student

DELETE /api/students/{id} - Delete student

Marks

GET /api/marks/{studentId} - Get all marks for a student

POST /api/marks/{studentId} - Add a mark to a student

Performance Queries

GET /api/students/top?limit=5 - Top performing students

GET /api/students/bottom?limit=5 - Bottom performing students

GET /api/students/range?min=50&max=90 - Students in marks range

GET /api/students/exact?value=75 - Students with exact average marks

Testing

Unit tests written with JUnit 5.

Mocked dependencies with Mockito.

Run tests with:

mvn test



Contribution

Fork the repository

Create a new branch

Make your changes

Open a Pull Request
