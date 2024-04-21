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
        app = App.getInstance();
        student = (Student) app.getCurrentUser();

        nameField.setText((student.getFirstName() != null ? student.getFirstName() : "cannot find") + " "
                + (student.getLastName() != null ? student.getLastName() : "cannot find"));
        //majorField.setText("Computer Science");
        majorField.setText((student.getMajor() != null ? student.getMajor().toString() : "cannot find"));
        minorField.setText((student.hasMinor() ? "true" : "false"));
        gpaField.setText((!Double.isNaN(student.getGpa()) ? String.valueOf(student.getGpa()) : "cannot find"));
        advisorField.setText((student.getAdvisor() != null
               ? student.getAdvisor().getFirstName() + " " + student.getAdvisor().getLastName()
                : "cannot find"));
        //advisorField.setText("Kevin Brown");
        emailField.setText((student.getEmail() != null ? student.getEmail() : "cannot find"));
        idField.setText((student.getUserID() != null ? student.getUserID().toString() : "cannot find"));
        degreeProgressionField.setText((student.getMajor() != null ? student.calculateProgressionAsPercentage()+" " : "no progression"));

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
