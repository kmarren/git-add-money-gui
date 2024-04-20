package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StudentHomepageController {

    // Fields corresponding to FXML fx:id
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
    
    // This method is called when the "View Semester Plan" button is clicked
    @FXML
    private void handleViewSemesterPlanAction() {
        // Add your action handling logic here
        System.out.println("View Semester Plan button clicked");
        // this is not the reel thing just there for fill will change later
        System.out.println("Name: " + nameField.getText());
    }

    // Initialize method, if needed, for setting up anything before the UI is presented
    @FXML
    public void initialize() {
        // Initialization logic here not sure if this is right
        System.out.println("Student Homepage Controller initialized");
    }
}
