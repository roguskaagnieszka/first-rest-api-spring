# First Rest API Spring Application

## Overview

This is a **Spring Boot** application designed as a simple REST API for managing products. The application demonstrates the use of modern Java frameworks and tools, including **Spring Boot**, **H2 Database**, and **Swagger** for API documentation.

---

## Features

- RESTful API for managing products:
    - Create, read, update, delete (CRUD) operations.
    - Error handling for missing resources.
- **Swagger Integration** for interactive API documentation.
- **H2 In-Memory Database** for fast and lightweight development and testing.
- **SQL Logging** to debug and monitor database interactions.
- Clean architecture using distinct layers: `Controller`, `Service`, `Repository`, and `Domain` (for data representation).

---

## Technologies Used

### Spring Boot
- **Spring Web** for building RESTful services.
- **Spring Data JPA** for data persistence.
- **Spring Boot Actuator** for monitoring and management.

### Swagger/OpenAPI
Swagger provides an interactive web-based interface to explore the API, enabling easier testing and understanding of endpoints. **OpenAPI 3.0** is used to generate API documentation automatically.

### H2 Database
H2 is an in-memory SQL database, ideal for development and testing. It allows you to run the application without additional database setup. It can be accessed via a web console for debugging purposes.

---

## API Endpoints

### Base URL
http://localhost:8080/api/v1/products


### Endpoints

| HTTP Method | Endpoint            | Description                     | Request Body                     |
|-------------|---------------------|---------------------------------|----------------------------------|
| **POST**    | `/`                 | Create a new product            | `{"name": "Product Name"}`       |
| **GET**     | `/{id}`             | Fetch a product by ID           | -                                |
| **GET**     | `/`                 | Fetch all products              | -                                |
| **PUT**     | `/{id}`             | Update a product by ID          | `{"name": "Updated Name"}`       |
| **DELETE**  | `/{id}`             | Delete a product by ID          | -                                |

---

## Application Configuration

### `application.properties`
Key configuration settings for the application:

```properties
spring.application.name=first-rest-api-spring
spring.h2.console.enabled=true
spring.h2.console.path=/console/
spring.datasource.url=jdbc:h2:mem:testdb

logging.level.org.hibernate.sql=DEBUG
```
- **spring.h2.console.enabled=true:** Enables the H2 database web console.
- **spring.h2.console.path=/console/:** Specifies the path to access the H2 console (http://localhost:8080/console/).
- **spring.datasource.url=jdbc:h2:mem:testdb:** Configures an in-memory H2 database named testdb.
- **logging.level.org.hibernate.sql=DEBUG:** Logs SQL queries executed by Hibernate for debugging.
---

## Swagger Integration

### Swagger UI
Swagger UI is available at:
http://localhost:8080/swagger-ui.html

### OpenAPI Configuration
The application uses `@OpenAPIDefinition` to specify API metadata, which is displayed in Swagger UI. The metadata includes:

- **Title**: Products API for Vistula
- **Version**: 1.0
- **Description**: Products Information

Here is the configuration in the main application file:

```java
@OpenAPIDefinition(info = @Info(
        title = "Products API for Vistula", 
        version = "1.0", 
        description = "Products Information"
))
```
This ensures that Swagger UI provides a clear and concise description of the API, making it easy for developers to understand the available endpoints and their functionality.

---

## Database Details

### H2 Database
The application uses **H2**, an embedded, in-memory SQL database. This database is ideal for testing and development as it requires no external setup and operates entirely in memory.

### Key Features
- **In-memory storage**: Data is stored temporarily and cleared when the application stops.
- **Embedded web console**: Inspect and manage the database using a web interface.

### Accessing the H2 Console
You can access the H2 console in your browser at:
http://localhost:8080/console/

### Default Credentials
Use the following details to log in to the console:
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: *(leave this blank)*

### How to View Data
1. After logging in to the H2 console, click the **Connect** button.
2. Once connected, you can execute SQL queries in the query editor.
3. To display all products stored in the database, run the following query:
   ```sql
   SELECT * FROM PRODUCTS;

The results will be displayed in the table below the query editor.

### Usage Notes
- A `products` table is created dynamically at runtime to store product data.
- H2 simplifies development and testing but is not suitable for production environments.

---

## Running the Application

### Prerequisites
Before running the application, ensure you have the following installed:
- **Java 17+**
- **Maven**

### Steps to Run

1. **Clone the repository:**

Clone the project repository to your local machine using the following command:
```bash
git clone https://github.com/roguskaagnieszka/first-rest-api-spring.git
```

2. **Navigate to the project directory:** 

Move into the project's root directory:
```bash
cd first-rest-api-spring
```
   
3. **Start the application:**

Use Maven to build and run the application:
    
```bash
mvn spring-boot:run
```
