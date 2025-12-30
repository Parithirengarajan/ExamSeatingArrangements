package com.examseating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class ExamSeatingApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ExamSeatingApplication.class, args);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String home() {
        return "Exam Seating System Working!";
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/api/students")
    public String students() {
        return "[{\"id\":1,\"rollNumber\":\"CS001\",\"name\":\"John Doe\",\"department\":\"Computer Science\",\"semester\":\"6\"},{\"id\":2,\"rollNumber\":\"CS002\",\"name\":\"Jane Smith\",\"department\":\"Computer Science\",\"semester\":\"6\"},{\"id\":3,\"rollNumber\":\"EE001\",\"name\":\"Mike Johnson\",\"department\":\"Electrical Engineering\",\"semester\":\"4\"},{\"id\":4,\"rollNumber\":\"ME001\",\"name\":\"Sarah Wilson\",\"department\":\"Mechanical Engineering\",\"semester\":\"8\"}]";
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/api/seating/allocate")
    public String allocate() {
        return "[{\"id\":1,\"student\":{\"id\":1,\"rollNumber\":\"CS001\",\"name\":\"John Doe\"},\"rowNumber\":1,\"seatNumber\":1},{\"id\":2,\"student\":{\"id\":3,\"rollNumber\":\"EE001\",\"name\":\"Mike Johnson\"},\"rowNumber\":1,\"seatNumber\":3},{\"id\":3,\"student\":{\"id\":2,\"rollNumber\":\"CS002\",\"name\":\"Jane Smith\"},\"rowNumber\":2,\"seatNumber\":2}]";
    }
}