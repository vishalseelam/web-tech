
A web application designed to support senior design or capstone projects where students work in teams. The goal is to create a structured and transparent environment for students and instructors. By encouraging frequent reporting and peer evaluation, the platform aims to foster collaboration, accountability, and productive team dynamics throughout the project. 

## Features

### 1. Weekly Activity Submission

Students participating in computer science senior design or capstone courses can submit a weekly activity report detailing their contribution to the team project. The activities are categorized to help both the student and the instructor track the type of work being done by each team member. Available categories include:

- **Development**
- **Testing**
- **Bug Fix**
- **Communication**
- **Documentation**
- **Design**
- **Planning**
- **Learning**
- **Deployment**
- **Support**
- **Miscellaneous**

This feature ensures transparency and helps the team and instructor assess progress accurately.

### 2. Peer Evaluations Submission

In addition to reporting their own contributions, students can submit weekly peer evaluations to assess the performance of their teammates. This feature is designed to address issues like:

- **Social loafing** (students doing less than their share)
- **Free-riding** (students who take credit for the team's success without contributing)
- **Undesirable team dynamics** (conflicts, communication breakdowns, etc.)

Peer evaluations provide a way to identify and address these issues early, enabling the instructor to intervene and promote better team collaboration.

### 3. Instructor Dashboard

Instructors can view the weekly activity reports and peer evaluations submitted by students. The dashboard provides a way to monitor the progress of each team and identify potential issues that need to be addressed. Instructors can also use the data to provide feedback to students and help them improve their performance.

## Repository Structure
   ```bash
   web-tech/
    ├── .github/                     # GitHub Actions workflows
    ├── backend/                     # Spring Boot backend (Maven)
    ├── docker/                      # Folder containing configuration files for grafana and prometheus
    ├── frontend/                    # Vue.js frontend (Vite)
    ├── .gitignore                   # Git ignore rules for both frontend and backend
    ├── Dockerfile                   # Dockerfile for building the Spring Boot application
    ├── LICENSE                      # License information
    ├── NOTICE                       # Attribution and licensing information
    ├── README.md                    # Project documentation
    └── docker-compose.yml           # Docker Compose file for MySQL, Mailpit, and other services
   ```

## Technologies

Spring Boot, Vue.js, MySQL, Docker, Microsoft Azure, etc.

## Documentation

### Project Use Cases

🔗 [Use Cases](https://docs.google.com/document/d/14_S35LY8Fu9pPpNU8m3cB8XM4O2CCzFu-15TJJBATls/edit?usp=sharing)

### UML Class Diagram

🔗 [UML Class Diagram](https://www.mermaidchart.com/raw/1f4be78a-0597-4fc4-8986-1ceb8937250e?theme=dark&version=v0.1&format=svg)

## Getting Started

### 1. Clone the repository

   ```bash
   git clone https://github.com/vishalseelam/web-tech.git
   ```
### 2. Start MySQL and Mailpit using Docker Compose

The application requires MySQL for the database and Mailpit for handling emails in development. You can start these services using Docker Compose. This configuration also includes Prometheus, Grafana, and Zipkin for monitoring and tracing, but those are optional for local development.
To start the services, run:

   ```bash
   docker-compose up -d # Start the services in detached mode
   ```

This will start the following services:
- MySQL (port 3306)
- Mailpit (SMTP on port 1025, web interface on port 8025)
- Prometheus (port 9090)
- Grafana (port 3000)
- Zipkin (port 9411)

You can check the status of the services by running:

   ```bash
   docker-compose ps # Check the status of the services
   ```

### 3. Set up the backend (Spring Boot)

Navigate to the backend/ directory and follow the steps to run the backend using Maven.
   ```bash
    cd backend/
    ./mvnw spring-boot:run # Run the Spring Boot application
   ```
The backend will be running on http://localhost:80 by default.

### 4. Set up the frontend (Vue.js)

Navigate to the frontend/ directory and follow the steps to run the frontend using npm.
   ```bash
    cd frontend/
    npm install # Install dependencies
    npm run dev # Run the development server
   ```
The frontend will be running on http://localhost:5173 by default.

### 5. Access the application

You can access the application by visiting http://localhost:5173 in your browser. Mailpit is available at http://localhost:8025, and you can use it to view emails sent by the application.

Here are some default credentials you can use to log in:

As a student:
- **Username:** student
- **Password:** 123456

As an instructor:
- **Username:** instructor
- **Password:** 123456

