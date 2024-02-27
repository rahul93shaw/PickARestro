PickARestro

Overview
PickARestro project is a Java-based application developed using the Spring Boot framework. The application is built using Spring Boot, JPA and Mysql.

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
Endpoint: http://localhost:8080/pickarestro/login/
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
