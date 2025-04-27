# RestAssured API Testing Project

This project is a simple API testing framework built using RestAssured and JUnit. It provides a structured way to test various API endpoints, including GET, POST, and PUT requests.

## Project Structure

```
restassured-api-testing
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── example
│   │               └── api
│   │                   └── BaseTest.java
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── api
│                       ├── GetApiTest.java
│                       ├── PostApiTest.java
│                       └── PutApiTest.java
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd restassured-api-testing
   ```

2. **Build the project:**
   Ensure you have Maven installed. Run the following command to build the project:
   ```
   mvn clean install
   ```

3. **Run the tests:**
   You can run the tests using the following command:
   ```
   mvn test
   ```

## Overview of API Endpoints

This project includes tests for the following API endpoints:

- **GET API**: Tests for retrieving resources.
- **POST API**: Tests for creating new resources.
- **PUT API**: Tests for updating existing resources.

## Dependencies

This project uses the following dependencies:

- RestAssured: For API testing.
- JUnit: For running the tests.

## Contribution

Feel free to contribute to this project by submitting issues or pull requests.