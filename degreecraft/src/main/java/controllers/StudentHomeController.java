package controllers;

import java.io.IOException;

import gitaddmoney.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Student;
import model.DegreeCraft;

public class StudentHomeController {
    
    @FXML
    private TextField nameField;
    
    @FXML
    private TextField majorField;
    
    @FXML
    private TextField minorField;
    
    @FXML
    private TextField gpaField;
    
    @FXML
    private TextField advisorField;
    
    @FXML
    private TextField emailField;
    
    @FXML
    private TextField idField;
    
    @FXML
    private TextField degreeProgressionField;
    
    private Student student;

    private App app;

    private DegreeCraft facade;

    @FXML
    private Button viewSemesterPlanButton;
    
    public void initialize() {
        app = new App();
        facade = DegreeCraft.getInstance();
        student = (Student) app.getCurrentUser();
        
        nameField.setText(student.getFirstName() + " " + student.getLastName());
        majorField.setText(student.getMajor().toString());
        minorField.setText("true");
        gpaField.setText(String.valueOf(student.getGpa()));
        advisorField.setText(student.getAdvisor().getFirstName() + " " + student.getAdvisor().getLastName());
        emailField.setText(student.getEmail());
        idField.setText(student.getUserID().toString());
        degreeProgressionField.setText("working on it");
    }

    @FXML
    private void handleViewSemesterPlanAction(ActionEvent event) {
        try {
            app.goToDegreeProgression();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
