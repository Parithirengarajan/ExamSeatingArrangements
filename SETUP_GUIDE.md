# Exam Seating Arrangement System - Setup Guide

## Prerequisites
- Java 17+
- Node.js 16+
- MySQL 8.0+
- Maven 3.6+

## Step-by-Step Setup in VS Code

### 1. Database Setup
```bash
# Install MySQL and create database
mysql -u root -p
CREATE DATABASE exam_seating_db;
# Run the init.sql script from database folder
```

### 2. Backend Setup (Spring Boot)
```bash
cd backend
mvn clean install
mvn spring-boot:run
# API will be available at http://localhost:8080
```

### 3. Frontend Web Setup (React)
```bash
cd frontend-web
npm install
npm start
# Web app will be available at http://localhost:3000
```

### 4. Desktop App Setup (JavaFX)
```bash
cd frontend-desktop
mvn clean compile
mvn javafx:run
```

## Key Features Implemented

### AI-Based Seating Algorithm
- **Anti-cheating optimization**: Students from same department are separated
- **Checkerboard pattern**: Maximum distance between adjacent students
- **Randomization**: Prevents predictable seating patterns
- **Capacity optimization**: Efficient use of available seats

### REST API Endpoints
- `GET /api/students` - Get all students
- `POST /api/students` - Add new student
- `POST /api/seating/allocate` - Allocate seats with AI
- `GET /api/seating/allocations` - Get seat allocations

### Frontend Features
- **Web Interface**: Modern React.js with Bootstrap
- **Desktop App**: JavaFX with native look and feel
- **Real-time updates**: Dynamic seat allocation display
- **Responsive design**: Works on all screen sizes

## Usage Instructions

### Adding Students
1. Use the REST API or web interface
2. Provide: Roll Number, Name, Department, Semester

### Allocating Seats
1. Select exam date and subject
2. Choose students for the exam
3. Click "Allocate Seats with AI"
4. System automatically optimizes seating to prevent cheating

### Viewing Results
- Web interface shows table with seat assignments
- Desktop app provides detailed seating chart
- Export functionality for printing

## Deployment Options

### Local Development
```bash
# Run the start-system.bat file
./start-system.bat
```

### Docker Deployment
```bash
cd deployment
docker-compose up -d
```

### AWS/Heroku Deployment
- Backend: Deploy Spring Boot JAR
- Frontend: Build React and deploy static files
- Database: Use RDS MySQL instance

## AI Algorithm Details

The seating allocation uses a sophisticated algorithm that:

1. **Groups students by department** to identify potential collaborators
2. **Shuffles student order** to add randomization
3. **Applies checkerboard pattern** for maximum separation
4. **Considers hall capacity** and layout constraints
5. **Optimizes for anti-cheating** while maintaining efficiency

## Technology Stack Summary

- **Backend**: Java 17, Spring Boot 3.2, JPA/Hibernate
- **Frontend Web**: React 18, Bootstrap 5, Axios
- **Frontend Desktop**: JavaFX 19
- **Database**: MySQL 8.0
- **Build Tools**: Maven, npm
- **Deployment**: Docker, AWS-ready configuration

## Next Steps for Enhancement

1. **Advanced AI Features**:
   - Machine learning for pattern recognition
   - Historical data analysis for better allocation
   - Predictive modeling for cheating prevention

2. **Additional Features**:
   - QR code generation for seat tickets
   - Mobile app for students
   - Real-time monitoring dashboard
   - Integration with university systems

3. **Scalability**:
   - Microservices architecture
   - Redis caching
   - Load balancing
   - Multi-tenant support