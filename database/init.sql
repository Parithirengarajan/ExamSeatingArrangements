-- Create Database
CREATE DATABASE IF NOT EXISTS exam_seating_db;
USE exam_seating_db;

-- Create Students Table
CREATE TABLE IF NOT EXISTS students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    roll_number VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(50),
    semester VARCHAR(10)
);

-- Create Exam Halls Table
CREATE TABLE IF NOT EXISTS exam_halls (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    hall_name VARCHAR(100) NOT NULL,
    total_rows INT NOT NULL,
    seats_per_row INT NOT NULL,
    total_capacity INT NOT NULL
);

-- Create Seat Allocations Table
CREATE TABLE IF NOT EXISTS seat_allocations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT,
    hall_id BIGINT,
    row_number INT NOT NULL,
    seat_number INT NOT NULL,
    exam_date VARCHAR(20) NOT NULL,
    exam_subject VARCHAR(100) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (hall_id) REFERENCES exam_halls(id)
);

-- Sample Data
INSERT INTO students (roll_number, name, department, semester) VALUES
('CS001', 'John Doe', 'Computer Science', '6'),
('CS002', 'Jane Smith', 'Computer Science', '6'),
('EE001', 'Mike Johnson', 'Electrical Engineering', '4'),
('ME001', 'Sarah Wilson', 'Mechanical Engineering', '8');

INSERT INTO exam_halls (hall_name, total_rows, seats_per_row, total_capacity) VALUES
('Hall A', 10, 6, 60),
('Hall B', 8, 8, 64),
('Main Auditorium', 15, 10, 150);