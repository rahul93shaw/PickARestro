Bite Buddies - API
A backend application for lunch planner.

Overview
The BiteBuddies project is a Java-based application developed using the Spring Boot framework. It provides a foundation for building a web application with data persistence using Spring Data JPA, Flyway for database migration, and includes tools like Lombok and MapStruct for simplified development.

Prerequisites
Java 17
Spring Boot 3.2.1
Mysql Database for runtime database
Getting Started
Clone the repository:

git clone https://github.com/PremRanjanDev/PickARestro.git
cd PickARestro
Build the project:

maven build

The application will be accessible at http://localhost:8080

Configuration
The main configuration file is application.yml in the src/main/resources directory. Customize it according to your requirements.


Endpoints
Endpoint: /login
Method Type: POST
Request Body: {
    "name": "Md Jin1",
    "username": "mdjin786",
    "password": "12345"
}
Response: {
    "status": "failure",
    "message": "Username already exists. Please try login with different username.",
    "body": null
}

Note:- Other API are commented due to shortage of time. I ran out of time because of PROD activities in my current company.
