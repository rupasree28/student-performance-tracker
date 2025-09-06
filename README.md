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

### Setup Steps
1. Clone the repository:
```bash
git clone https://github.com/yourusername/student-performance-tracker.git
cd student-performance-tracker

   git clone https://github.com/your-username/student-performance-tracker.git
