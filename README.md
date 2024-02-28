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

Please run DB scripts to generate tables and data under path - 
src/main/resources


Endpoints
Endpoint: 
LOGIN/SIGNUP : http://localhost:8080/pickarestro/login/
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

CREATE NEW SESSION : http://localhost:8080/pickarestro/main/createSession
Method Type: POST
Request Body: {
    "sessionId": 0,
    "sessionType": "Office party",
    "sessionDesc" : "office party",
    "host" : "john123",
    "endDatetime": null,
    "startDatetime": 20240227231308
}
Response: {
    "status": "success",
    "message": "",
    "body": {
        "sessionId": 1,
        "sessionType": "Office party",
        "sessionDesc": "office party",
        "startDatetime": 20240227231308,
        "host": "john123"
    }
}

GET ALL RESTAURANTS : http://localhost:8080/pickarestro/main/restaurants
Method Type: GET
Request Body: {
}
Response: {
    "status": "success",
    "message": "",
    "body": [
        {
            "restaurantId": 1,
            "name": "Masala Bar",
            "address": "10 Siglap Road. Singapore - 450450"
        },
        {
            "restaurantId": 2,
            "name": "Wok connection",
            "address": "10 Buffalo Road. Singapore - 101010"
        },
        {
            "restaurantId": 3,
            "name": "Wine connection",
            "address": "I12 Katong. Singapore - 110011"
        },
        {
            "restaurantId": 4,
            "name": "Bakery charm",
            "address": "Little India"
        },
        {
            "restaurantId": 5,
            "name": "Arbit petty",
            "address": "Orchard Road"
        },
        {
            "restaurantId": 6,
            "name": "Murugan Idli Shop",
            "address": "Syde Alwi Road"
        }
    ]
}

GET USERS LIST EXCEPT CURRENT USER : http://localhost:8080/pickarestro/main/users?username=john123
Method Type : GET

Request Body: {
}
Response: {
    "status": "success",
    "message": "",
    "body": [
        {
            "name": "Johnny",
            "username": "johnny123",
            "password": null
        },
        {
            "name": "rahul",
            "username": "rahulshaw123",
            "password": null
        },
        {
            "name": "Li Ping",
            "username": "liping007",
            "password": null
        },
        {
            "name": "Md Jin",
            "username": "mdjin786",
            "password": null
        },
        {
            "name": "Raju",
            "username": "raju123",
            "password": null
        },
        {
            "name": "rani",
            "username": "rani123",
            "password": null
        },
        {
            "name": "akki",
            "username": "akki123",
            "password": null
        },
        {
            "name": "rahulji",
            "username": "rahu345",
            "password": null
        },
        {
            "name": "web",
            "username": "web1123",
            "password": null
        },
        {
            "name": "wick",
            "username": "wick1234",
            "password": null
        },
        {
            "name": "riju",
            "username": "riju123",
            "password": null
        },
        {
            "name": "ajay",
            "username": "ajay1234",
            "password": null
        },
        {
            "name": "wrench",
            "username": "wrench12",
            "password": null
        }
    ]
}

GET ALL ACTIVE SESSIONS BY USER : http://localhost:8080/pickarestro/main/activeSessionByUser?username=john123
Method Type: GET
Request Body: {
    
}
Response: {
    "status": "success",
    "message": "",
    "body": [
        {
            "sessionId": 1,
            "sessionType": "Office party",
            "sessionDesc": "office party",
            "host": "john123"
        },
        {
            "sessionId": 2,
            "sessionType": "Team Lunch",
            "sessionDesc": "",
            "host": "john123"
        }
    ]
}



Note:- Other API are commented due to shortage of time. I ran out of time because of PROD activities in my current company.
