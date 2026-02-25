WEATHER APPLICATION(SPRING BOOT)

PROJECT OVERVIEW

This is a Spring Boot REST API for managing and retrieving weather data.
The application allows users to:

1. Fetch all weather records
2. Filter weather data by date
3. Filter by month and year
4. Filter by weather condition

The project follows a layered architecture:

1. Controller Layer → Handles HTTP requests
2. Repository Layer → Handles database operations
3. Entity Layer → Represents Weather data model

BASE URL:
http://localhost:8085/weather

SETUP AND INSTRUCTIONS

1. Clone the Repository

git clone https://github.com/<your-username>/Weather_Application.git
cd Weather_Application

2. Build the Project using Maven

mvn clean install

3. Run the Application

mvn spring-boot:run
Or run the WeatherApplication.java file from your IDE.

4. Access the API

Server runs on:
http://localhost:8085

Base endpoint:
http://localhost:8085/weather

API DETAILS

1. Get All Weather Records

Endpoint
GET /weather
http://localhost:8085/weather

Response
<img width="2564" height="1845" alt="image" src="https://github.com/user-attachments/assets/ebac84a9-d320-47d0-9183-32c033d1ee7b" />

2. Get Weather by Date

Endpoint
GET /weather/date?date=YYYY-MM-DD
http://localhost:8085/weather/date?date=2023-03-05

Response
<img width="2370" height="445" alt="image" src="https://github.com/user-attachments/assets/a046042e-0cc7-42b9-aed3-420584b8190a" />

3. Get Weather by Month

Endpoint
GET /weather/month?year=YYYY&month=MM
http://localhost:8085/weather/month?year=2023&month=3

Response
<img width="2705" height="654" alt="image" src="https://github.com/user-attachments/assets/65bc13c0-b7bb-4edc-b3ca-aaf170d203cf" />

4. Get Weather by Condition

Endpoint
GET /weather/condition?value=Sunny
http://localhost:8085/weather/condition?value=Sunny

Response
<img width="2643" height="1024" alt="image" src="https://github.com/user-attachments/assets/549f4185-3eca-4722-9e89-4693c31fd7fc" />

REPOSITORY METHODS USED

1. findAll()
2. findByDate(LocalDate date)
3. findByDateBetween(LocalDate start, LocalDate end)
4. findByCondition(String value)
