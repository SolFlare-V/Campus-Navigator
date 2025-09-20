#Smart Campus Navigator Web Application
🗺️ Project Overview
The Smart Campus Navigator is a web-based application designed to help students, faculty, and staff easily navigate their university campus. It provides detailed, user-friendly directions to specific rooms and allows users to quickly check their own schedule to find their next class or event.

This project was built from a command-line Java application into a full-fledged web application using the Spring Boot framework, demonstrating core Object-Oriented Programming principles in a practical, real-world scenario.

✨ Features
Room Direction Finder: Enter a building name and room number to get detailed directions, including the building's address, description, floor number, and specific location hints.

Personal Schedule Checker: Enter a personal ID to instantly find the time and location of your next scheduled class for the day.

Modern User Interface: A clean, responsive, and visually appealing single-page application built with HTML, CSS, and JavaScript.

REST API Backend: A robust backend powered by Java and Spring Boot that serves data to the frontend.

💻 Tech Stack
Backend:

Java 17

Spring Boot 3

Spring Web

Maven (for dependency management)

Embedded Tomcat Server

Frontend:

HTML5

CSS3 (with modern features like Flexbox and Animations)

JavaScript (ES6+) with the fetch API for asynchronous calls.

Development Environment:

IntelliJ IDEA

📂 Project Structure
The project follows a standard Maven project structure, with the core logic organized into packages:

src/main/
├── java/campusnavigator/webapp/
│   ├── controller/         # Handles web requests and core logic
│   │   ├── CampusApiController.java
│   │   └── CampusNavigator.java
│   ├── model/              # Data classes (POJOs) for the application
│   │   ├── Person.java
│   │   ├── Room.java
│   │   └── ... (and all subclasses)
│   └── WebappApplication.java # Main entry point to start the server
│
└── resources/
    └── static/             # For all frontend files
        └── index.html      # The single HTML file for the UI

🚀 How to Run the Project
To run this application on your local machine, please follow these steps:

Prerequisites:

Java Development Kit (JDK) 17 or later.

Apache Maven.

An IDE like IntelliJ IDEA (recommended).

Steps:

Clone or Download: Get the project files onto your local machine.

Open in IDE: Open the project folder as a Maven project in IntelliJ. The IDE will automatically download the necessary dependencies.

Run the Application:

Navigate to the WebappApplication.java file.

Right-click on the file and select "Run 'WebappApplication.main()'".

Verify Server Start: Check the "Run" console at the bottom of the IDE. Wait for the log message that says Tomcat started on port(s): 8080 (http).

Access in Browser: Open your web browser and go to the following address:

http://localhost:8080

📋 How to Use
The application has two main functions, accessible via tabs. All the data is currently hardcoded for demonstration purposes.

1. Find a Room
Click on the "Find a Room" tab.

Enter a valid building and room number from the list below.

Building Name

Room Number(s)

Technology Center

101, 102, 210

Science Hall

201, 105

2. My Schedule
Click on the "My Schedule" tab.

Enter a valid Person ID from the list below to find their next class.

Person ID

Name

Role

S001

John Doe

Student

F101

Dr. Ada Lovelace

Faculty

💡 Key Java Concepts Used
This project serves as a practical example of several key Object-Oriented Programming (OOP) principles:

Encapsulation: All model classes have private fields and public getter methods.

Inheritance: The Person and Room hierarchies use extends to create specialized subclasses.

Polymorphism: The Building class holds a List<Room> that can contain any type of Room subclass.

Abstraction: Person and Room are abstract base classes.
