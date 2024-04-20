package controllers;

import java.io.IOException;

import gitaddmoney.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Student;
import model.DegreeCraft;
import model.Course;

public class EightSemesterController {

    @FXML
    private TextField semesterOneOneField;
    @FXML
    private TextField semesterOneTwoField;
    @FXML
    private TextField semesterOneThreeField;
    @FXML
    private TextField semesterOneFourField;
    @FXML
    private TextField semesterOneFiveField;

    @FXML
    private TextField semesterTwoOneField;
    @FXML
    private TextField semesterTwoTwoField;
    @FXML
    private TextField semesterTwoThreeField;
    @FXML
    private TextField semesterTwoFourField;
    @FXML
    private TextField semesterTwoFiveField;

    @FXML
    private TextField semesterThreeOneField;
    @FXML
    private TextField semesterThreeTwoField;
    @FXML
    private TextField semesterThreeThreeField;
    @FXML
    private TextField semesterThreeFourField;
    @FXML
    private TextField semesterThreeFiveField;

    @FXML
    private Button logoutbutton;

    private Student student;

    private App app;

    private DegreeCraft degreeCraft;

    public EightSemesterController() {
        degreeCraft = DegreeCraft.getInstance();
    }

    public void initialize() {
        app = App.getInstance();
        student = (Student) app.getCurrentUser();
        if (degreeCraft.eightSemesterPlanGen() != null && degreeCraft.eightSemesterPlanGen().size() > 0) {
            String classOne = degreeCraft.eightSemesterPlanGen().get(0).getCourseName();
            semesterOneOneField.setText(classOne);
            String classTwo = degreeCraft.eightSemesterPlanGen().get(1).getCourseName();
            semesterOneTwoField.setText(classTwo);
            String classThree = degreeCraft.eightSemesterPlanGen().get(2).getCourseName();
            semesterOneThreeField.setText(classThree);
            String classFour = degreeCraft.eightSemesterPlanGen().get(3).getCourseName();
            semesterOneFourField.setText(classFour);
            String classFive = degreeCraft.eightSemesterPlanGen().get(4).getCourseName();
            semesterOneFiveField.setText(classFive);

            String classOne2 = degreeCraft.eightSemesterPlanGen().get(5).getCourseName();
            semesterTwoOneField.setText(classOne2);
            String classTwo2 = degreeCraft.eightSemesterPlanGen().get(6).getCourseName();
            semesterTwoTwoField.setText(classTwo2);
            String classThree2 = degreeCraft.eightSemesterPlanGen().get(7).getCourseName();
            semesterTwoThreeField.setText(classThree2);
            String classFour2 = degreeCraft.eightSemesterPlanGen().get(8).getCourseName();
            semesterTwoFourField.setText(classFour2);
            String classFive2 = degreeCraft.eightSemesterPlanGen().get(9).getCourseName();
            semesterTwoFiveField.setText(classFive2);
        }
    }

    @FXML
    private void logoutButton(ActionEvent event) throws IOException {
        DegreeCraft.getInstance().logout();
        App.getInstance().logout();
    }

    @FXML
    private void backToProfileButton(ActionEvent event) throws IOException{
        App.getInstance();
        App.setRoot("studenthome");
    }
}