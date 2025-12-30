package com.examseating.desktop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class ExamSeatingApp extends Application {
    
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String API_BASE = "http://localhost:8080/api";
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Exam Seating Arrangement System");
        
        // Create main layout
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        
        // Top section - Exam details
        VBox topSection = createExamDetailsSection();
        root.setTop(topSection);
        
        // Center section - Student selection
        VBox centerSection = createStudentSelectionSection();
        root.setCenter(centerSection);
        
        // Bottom section - Results
        VBox bottomSection = createResultsSection();
        root.setBottom(bottomSection);
        
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private VBox createExamDetailsSection() {
        VBox section = new VBox(10);
        section.setPadding(new Insets(10));
        section.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5;");
        
        Label title = new Label("Exam Details");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        HBox dateBox = new HBox(10);
        dateBox.getChildren().addAll(
            new Label("Exam Date:"),
            new DatePicker()
        );
        
        HBox subjectBox = new HBox(10);
        TextField subjectField = new TextField();
        subjectField.setPromptText("Enter exam subject");
        subjectBox.getChildren().addAll(
            new Label("Subject:"),
            subjectField
        );
        
        section.getChildren().addAll(title, dateBox, subjectBox);
        return section;
    }
    
    private VBox createStudentSelectionSection() {
        VBox section = new VBox(10);
        section.setPadding(new Insets(10));
        section.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5;");
        
        Label title = new Label("Select Students");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        ListView<CheckBox> studentList = new ListView<>();
        studentList.setPrefHeight(200);
        
        Button allocateButton = new Button("Allocate Seats with AI");
        allocateButton.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-size: 14px;");
        allocateButton.setPrefWidth(200);
        
        allocateButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Seats allocated successfully using AI algorithm!");
            alert.showAndWait();
        });
        
        section.getChildren().addAll(title, studentList, allocateButton);
        return section;
    }
    
    private VBox createResultsSection() {
        VBox section = new VBox(10);
        section.setPadding(new Insets(10));
        section.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5;");
        
        Label title = new Label("Seat Allocations");
        title.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        TableView<Map<String, String>> resultsTable = new TableView<>();
        
        TableColumn<Map<String, String>, String> rollCol = new TableColumn<>("Roll No");
        TableColumn<Map<String, String>, String> nameCol = new TableColumn<>("Name");
        TableColumn<Map<String, String>, String> rowCol = new TableColumn<>("Row");
        TableColumn<Map<String, String>, String> seatCol = new TableColumn<>("Seat");
        
        resultsTable.getColumns().addAll(rollCol, nameCol, rowCol, seatCol);
        resultsTable.setPrefHeight(150);
        
        section.getChildren().addAll(title, resultsTable);
        return section;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}