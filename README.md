# 🔗 Mapping Demo Application

A Spring Boot application demonstrating various **JPA entity relationship mappings** including **One-to-One**, **One-to-Many**, and **Many-to-Many** relationships with practical examples.

---

## 📌 Project Overview

This project showcases different types of database relationship mappings using **Spring Boot** and **Jakarta Persistence API (JPA)**.  

It includes real-world models such as:

- Employee
- Passport
- Person
- Player
- Project
- Team

The application demonstrates how these entities are associated using proper ORM mapping strategies.

---

## 🚀 Technology Stack

- **Java:** 17
- **Spring Boot:** 4.0.3
- **Spring Data JPA:** ORM & database operations
- **MySQL:** Relational database
- **Maven:** Build tool
- **Jakarta Persistence API (JPA)**

---

## Project Structure

```
src/main/java/org/hartford/mappingdemo/
├── MappingDemoApplication.java      # Main Spring Boot application entry point
├── controller/                       # REST API controllers
│   ├── EmployeeController.java
│   ├── PassportController.java
│   ├── PersonController.java
│   ├── PlayerController.java
│   ├── ProjectController.java
│   └── TeamController.java
├── model/                            # JPA entity models
│   ├── Employee.java
│   ├── Passport.java
│   ├── Person.java
│   ├── Player.java
│   ├── Project.java
│   └── Team.java
├── repository/                       # Data access layer
│   ├── EmployeeRepository.java
│   ├── PassportRepository.java
│   ├── PersonRepository.java
│   ├── PlayerRepository.java
│   ├── ProjectRepository.java
│   └── TeamRepository.java
└── service/                          # Business logic layer
    ├── EmployeeService.java
    ├── PassportService.java
    ├── PersonService.java
    ├── PlayerService.java
    ├── ProjectService.java
    └── TeamService.java
```

## Entity Relationships

This application demonstrates the following JPA mapping types:

- **One-to-One (1:1)**: Person ↔ Passport
- **One-to-Many (1:N)**: Team ↔ Player
- **Many-to-Many (N:N)**: Project ↔ Employee

## Prerequisites

- Java 17 or higher
- MySQL Server running locally
- Maven 3.6+

## Configuration

The application uses MySQL for data persistence. Update the database connection settings in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/oto_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

> **Note**: Update the database credentials to match your MySQL setup before running the application.

## Building the Application

Using Maven wrapper:

```bash
./mvnw clean build
```

Or with Maven:

```bash
mvn clean build
```

## Running the Application

Using Maven wrapper:

```bash
./mvnw spring-boot:run
```

Or with Maven:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

The application provides RESTful API endpoints for managing the following entities:

- `/api/employees` - Employee management
- `/api/passports` - Passport management
- `/api/people` - Person management
- `/api/players` - Player management
- `/api/projects` - Project management
- `/api/teams` - Team management

## Development Tools

The project includes Spring Boot DevTools for enhanced development experience with automatic restart capabilities.

## Database Schema

The application automatically creates the database schema based on the entity definitions. The Hibernate DDL auto setting is configured to `update`, which will:
- Create new tables if they don't exist
- Add new columns to existing tables
- Preserve existing data

## Notes

- All entity relationships are configured with appropriate cascade types for data consistency
- The application uses Jakarta Persistence API (JPA) for ORM
- SQL queries are formatted and logged for debugging purposes

## Author

Hartford Java Assignments - Practice Project

## License

Educational use


