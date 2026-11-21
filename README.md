
# Recruitment and Placement Management System (RPMS)

## Project Overview
The Recruitment and Placement Management System is a web-based application designed to manage campus recruitment and placement activities.

## Technologies Used
- Java 21
- JDBC
- Spring Boot 3.5.7
- MySQL 8.0
- HTML
- CSS
- JavaScript
- Maven

## Main Modules
1. User Management
2. Candidate Management
3. Company Management
4. Job Management
5. Application Management
6. Eligibility Checking
7. Candidate Shortlisting
8. Interview Management
9. Interview Feedback
10. Offer Management
11. Placement Management
12. Placement Reports
13. Admin Login

## Database
Database Name: recruitment_placement_db

## How to Run the Project

1. Install JDK 21, Maven and MySQL.
2. Create the database named recruitment_placement_db.
3. Execute the SQL script from database/database.sql.
4. Configure MySQL settings in application.properties.
5. Set the DB_PASSWORD environment variable in PowerShell.
6. Open the project folder in VS Code.
7. Run:

   mvn compile

8. Start the application:

   mvn spring-boot:run

9. Open the application:

   http://localhost:8080/

## Login
Demo username: admin

Use the password configured for the admin account.

## API Endpoints
- GET /api/dashboard/stats
- GET /api/students
- GET /api/companies
- GET /api/jobs
- GET /api/applications
- GET /api/interviews
- GET /api/offers
- GET /api/placements
- GET /api/reports
- POST /api/auth/login

## Project Status
Core modules, database integration, REST APIs and frontend pages have been implemented and tested at a basic level.

## Future Enhancements
- Role-based access control
- Secure session/token authentication
- Add, update and delete operations through frontend
- Input validation and improved error handling
- Deployment to a cloud server
