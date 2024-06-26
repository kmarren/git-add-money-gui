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
    private TextField semesterFourOneField;
    @FXML
    private TextField semesterFourTwoField;
    @FXML
    private TextField semesterFourThreeField;
    @FXML
    private TextField semesterFourFourField;
    @FXML
    private TextField semesterFourFiveField;

    @FXML
    private Button logoutbutton;

    @FXML
    private Button next;

    private Student student;

    private App app;

    private DegreeCraft degreeCraft;

    public EightSemesterController() {
        degreeCraft = DegreeCraft.getInstance();
    }

    public void initialize() {
        app = App.getInstance();
        student = (Student) app.getCurrentUser();
        int curr = student.findCurrentSemester();
        if (degreeCraft.eightSemesterPlanGen() != null && degreeCraft.eightSemesterPlanGen().size() > 0) {
            if(student.getCompletedCourses().size()/2 < 5)
            {
                //semester 1
                semesterOneOneField.setText(degreeCraft.eightSemesterPlanGen().get(0).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(0).getCourseCode());
                semesterOneTwoField.setText(degreeCraft.eightSemesterPlanGen().get(1).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(1).getCourseCode());
                semesterOneThreeField.setText(degreeCraft.eightSemesterPlanGen().get(2).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(2).getCourseCode());
                semesterOneFourField.setText(degreeCraft.eightSemesterPlanGen().get(3).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(3).getCourseCode());
                semesterOneFiveField.setText(degreeCraft.eightSemesterPlanGen().get(4).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(4).getCourseCode());
                //semester 2
                semesterTwoOneField.setText(degreeCraft.eightSemesterPlanGen().get(5).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(5).getCourseCode());
                semesterTwoTwoField.setText(degreeCraft.eightSemesterPlanGen().get(6).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(6).getCourseCode());
                semesterTwoThreeField.setText(degreeCraft.eightSemesterPlanGen().get(7).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(7).getCourseCode());
                semesterTwoFourField.setText(degreeCraft.eightSemesterPlanGen().get(8).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(8).getCourseCode());
                semesterTwoFiveField.setText(degreeCraft.eightSemesterPlanGen().get(9).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(9).getCourseCode());
                //semester 3
                semesterThreeOneField.setText(degreeCraft.eightSemesterPlanGen().get(10).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(10).getCourseCode());
                semesterThreeTwoField.setText(degreeCraft.eightSemesterPlanGen().get(11).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(11).getCourseCode());
                semesterThreeThreeField.setText(degreeCraft.eightSemesterPlanGen().get(12).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(12).getCourseCode());
                semesterThreeFourField.setText(degreeCraft.eightSemesterPlanGen().get(13).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(13).getCourseCode());
                semesterThreeFiveField.setText(degreeCraft.eightSemesterPlanGen().get(14).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(14).getCourseCode());
                //semester 4
                semesterFourOneField.setText(degreeCraft.eightSemesterPlanGen().get(15).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(15).getCourseCode());
                semesterFourTwoField.setText(degreeCraft.eightSemesterPlanGen().get(16).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(16).getCourseCode());
                semesterFourThreeField.setText(degreeCraft.eightSemesterPlanGen().get(17).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(17).getCourseCode());
                semesterFourFourField.setText(degreeCraft.eightSemesterPlanGen().get(18).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(18).getCourseCode());
                semesterFourFiveField.setText(degreeCraft.eightSemesterPlanGen().get(19).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(19).getCourseCode());
            }
            else if(student.getCompletedCourses().size()/2 >= 5 && student.getCompletedCourses().size()/2 < 10)
            {
                //semester 1
                semesterOneOneField.setText(degreeCraft.eightSemesterPlanGen().get(0).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(0).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(0).getGrade());
                semesterOneTwoField.setText(degreeCraft.eightSemesterPlanGen().get(1).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(1).getCourseCode() +  "      " + degreeCraft.eightSemesterPlanGen().get(1).getGrade());
                semesterOneThreeField.setText(degreeCraft.eightSemesterPlanGen().get(2).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(2).getCourseCode() + "      " + degreeCraft.eightSemesterPlanGen().get(2).getGrade());
                semesterOneFourField.setText(degreeCraft.eightSemesterPlanGen().get(3).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(3).getCourseCode() + "      " + degreeCraft.eightSemesterPlanGen().get(3).getGrade());
                semesterOneFiveField.setText(degreeCraft.eightSemesterPlanGen().get(4).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(4).getCourseCode() + "      " + degreeCraft.eightSemesterPlanGen().get(4).getGrade());
                //semester 2
                semesterTwoOneField.setText(degreeCraft.eightSemesterPlanGen().get(5).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(5).getCourseCode());
                semesterTwoTwoField.setText(degreeCraft.eightSemesterPlanGen().get(6).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(6).getCourseCode());
                semesterTwoThreeField.setText(degreeCraft.eightSemesterPlanGen().get(7).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(7).getCourseCode());
                semesterTwoFourField.setText(degreeCraft.eightSemesterPlanGen().get(8).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(8).getCourseCode());
                semesterTwoFiveField.setText(degreeCraft.eightSemesterPlanGen().get(9).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(9).getCourseCode());
                //semester 3
                semesterThreeOneField.setText(degreeCraft.eightSemesterPlanGen().get(10).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(10).getCourseCode());
                semesterThreeTwoField.setText(degreeCraft.eightSemesterPlanGen().get(11).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(11).getCourseCode());
                semesterThreeThreeField.setText(degreeCraft.eightSemesterPlanGen().get(12).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(12).getCourseCode());
                semesterThreeFourField.setText(degreeCraft.eightSemesterPlanGen().get(13).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(13).getCourseCode());
                semesterThreeFiveField.setText(degreeCraft.eightSemesterPlanGen().get(14).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(14).getCourseCode());
                //semester 4
                semesterFourOneField.setText(degreeCraft.eightSemesterPlanGen().get(15).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(15).getCourseCode());
                semesterFourTwoField.setText(degreeCraft.eightSemesterPlanGen().get(16).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(16).getCourseCode());
                semesterFourThreeField.setText(degreeCraft.eightSemesterPlanGen().get(17).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(17).getCourseCode());
                semesterFourFourField.setText(degreeCraft.eightSemesterPlanGen().get(18).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(18).getCourseCode());
                semesterFourFiveField.setText(degreeCraft.eightSemesterPlanGen().get(19).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(19).getCourseCode());
            }
            else if(student.getCompletedCourses().size()/2 >= 10 && student.getCompletedCourses().size()/2 < 15)
            {
                //semester 1
                semesterOneOneField.setText(degreeCraft.eightSemesterPlanGen().get(0).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(0).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(0).getGrade());
                semesterOneTwoField.setText(degreeCraft.eightSemesterPlanGen().get(1).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(1).getCourseCode() +  "      " + degreeCraft.eightSemesterPlanGen().get(1).getGrade());
                semesterOneThreeField.setText(degreeCraft.eightSemesterPlanGen().get(2).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(2).getCourseCode() + "      " + degreeCraft.eightSemesterPlanGen().get(2).getGrade());
                semesterOneFourField.setText(degreeCraft.eightSemesterPlanGen().get(3).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(3).getCourseCode() + "      " + degreeCraft.eightSemesterPlanGen().get(3).getGrade());
                semesterOneFiveField.setText(degreeCraft.eightSemesterPlanGen().get(4).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(4).getCourseCode() + "      " + degreeCraft.eightSemesterPlanGen().get(4).getGrade());
                //semester 2
                semesterTwoOneField.setText(degreeCraft.eightSemesterPlanGen().get(5).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(5).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(5).getGrade());
                semesterTwoTwoField.setText(degreeCraft.eightSemesterPlanGen().get(6).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(6).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(6).getGrade());
                semesterTwoThreeField.setText(degreeCraft.eightSemesterPlanGen().get(7).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(7).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(7).getGrade());
                semesterTwoFourField.setText(degreeCraft.eightSemesterPlanGen().get(8).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(8).getCourseCode()+ "    " + degreeCraft.eightSemesterPlanGen().get(8).getGrade());
                semesterTwoFiveField.setText(degreeCraft.eightSemesterPlanGen().get(9).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(9).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(9).getGrade());
                //semester 3
                semesterThreeOneField.setText(degreeCraft.eightSemesterPlanGen().get(10).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(10).getCourseCode());
                semesterThreeTwoField.setText(degreeCraft.eightSemesterPlanGen().get(11).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(11).getCourseCode());
                semesterThreeThreeField.setText(degreeCraft.eightSemesterPlanGen().get(12).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(12).getCourseCode());
                semesterThreeFourField.setText(degreeCraft.eightSemesterPlanGen().get(13).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(13).getCourseCode());
                semesterThreeFiveField.setText(degreeCraft.eightSemesterPlanGen().get(14).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(14).getCourseCode());
                //semester 4
                semesterFourOneField.setText(degreeCraft.eightSemesterPlanGen().get(15).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(15).getCourseCode());
                semesterFourTwoField.setText(degreeCraft.eightSemesterPlanGen().get(16).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(16).getCourseCode());
                semesterFourThreeField.setText(degreeCraft.eightSemesterPlanGen().get(17).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(17).getCourseCode());
                semesterFourFourField.setText(degreeCraft.eightSemesterPlanGen().get(18).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(18).getCourseCode());
                semesterFourFiveField.setText(degreeCraft.eightSemesterPlanGen().get(19).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(19).getCourseCode());
            }
            else if(student.getCompletedCourses().size()/2 >= 15 && student.getCompletedCourses().size()/2 < 20)
            {
                //semester 1
                semesterOneOneField.setText(degreeCraft.eightSemesterPlanGen().get(0).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(0).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(0).getGrade());
                semesterOneTwoField.setText(degreeCraft.eightSemesterPlanGen().get(1).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(1).getCourseCode() +  "      " + degreeCraft.eightSemesterPlanGen().get(1).getGrade());
                semesterOneThreeField.setText(degreeCraft.eightSemesterPlanGen().get(2).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(2).getCourseCode() + "      " + degreeCraft.eightSemesterPlanGen().get(2).getGrade());
                semesterOneFourField.setText(degreeCraft.eightSemesterPlanGen().get(3).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(3).getCourseCode() + "      " + degreeCraft.eightSemesterPlanGen().get(3).getGrade());
                semesterOneFiveField.setText(degreeCraft.eightSemesterPlanGen().get(4).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(4).getCourseCode() + "      " + degreeCraft.eightSemesterPlanGen().get(4).getGrade());
                //semester 2
                semesterTwoOneField.setText(degreeCraft.eightSemesterPlanGen().get(5).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(5).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(5).getGrade());
                semesterTwoTwoField.setText(degreeCraft.eightSemesterPlanGen().get(6).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(6).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(6).getGrade());
                semesterTwoThreeField.setText(degreeCraft.eightSemesterPlanGen().get(7).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(7).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(7).getGrade());
                semesterTwoFourField.setText(degreeCraft.eightSemesterPlanGen().get(8).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(8).getCourseCode()+ "    " + degreeCraft.eightSemesterPlanGen().get(8).getGrade());
                semesterTwoFiveField.setText(degreeCraft.eightSemesterPlanGen().get(9).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(9).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(9).getGrade());
                //semester 3
                semesterThreeOneField.setText(degreeCraft.eightSemesterPlanGen().get(10).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(10).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(5).getGrade());
                semesterThreeTwoField.setText(degreeCraft.eightSemesterPlanGen().get(11).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(11).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(6).getGrade());
                semesterThreeThreeField.setText(degreeCraft.eightSemesterPlanGen().get(12).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(12).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(7).getGrade());
                semesterThreeFourField.setText(degreeCraft.eightSemesterPlanGen().get(13).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(13).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(8).getGrade());
                semesterThreeFiveField.setText(degreeCraft.eightSemesterPlanGen().get(14).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(14).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(9).getGrade());
                //semester 4
                semesterFourOneField.setText(degreeCraft.eightSemesterPlanGen().get(15).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(15).getCourseCode());
                semesterFourTwoField.setText(degreeCraft.eightSemesterPlanGen().get(16).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(16).getCourseCode());
                semesterFourThreeField.setText(degreeCraft.eightSemesterPlanGen().get(17).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(17).getCourseCode());
                semesterFourFourField.setText(degreeCraft.eightSemesterPlanGen().get(18).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(18).getCourseCode());
                semesterFourFiveField.setText(degreeCraft.eightSemesterPlanGen().get(19).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(19).getCourseCode());
            }
            else
            {
                //semester 1
                semesterOneOneField.setText(degreeCraft.eightSemesterPlanGen().get(0).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(0).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(0).getGrade());
                semesterOneTwoField.setText(degreeCraft.eightSemesterPlanGen().get(1).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(1).getCourseCode() +  "      " + degreeCraft.eightSemesterPlanGen().get(1).getGrade());
                semesterOneThreeField.setText(degreeCraft.eightSemesterPlanGen().get(2).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(2).getCourseCode() + "      " + degreeCraft.eightSemesterPlanGen().get(2).getGrade());
                semesterOneFourField.setText(degreeCraft.eightSemesterPlanGen().get(3).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(3).getCourseCode() + "      " + degreeCraft.eightSemesterPlanGen().get(3).getGrade());
                semesterOneFiveField.setText(degreeCraft.eightSemesterPlanGen().get(4).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(4).getCourseCode() + "      " + degreeCraft.eightSemesterPlanGen().get(4).getGrade());
                //semester 2
                semesterTwoOneField.setText(degreeCraft.eightSemesterPlanGen().get(5).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(5).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(5).getGrade());
                semesterTwoTwoField.setText(degreeCraft.eightSemesterPlanGen().get(6).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(6).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(6).getGrade());
                semesterTwoThreeField.setText(degreeCraft.eightSemesterPlanGen().get(7).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(7).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(7).getGrade());
                semesterTwoFourField.setText(degreeCraft.eightSemesterPlanGen().get(8).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(8).getCourseCode()+ "    " + degreeCraft.eightSemesterPlanGen().get(8).getGrade());
                semesterTwoFiveField.setText(degreeCraft.eightSemesterPlanGen().get(9).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(9).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(9).getGrade());
                //semester 3
                semesterThreeOneField.setText(degreeCraft.eightSemesterPlanGen().get(10).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(10).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(5).getGrade());
                semesterThreeTwoField.setText(degreeCraft.eightSemesterPlanGen().get(11).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(11).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(6).getGrade());
                semesterThreeThreeField.setText(degreeCraft.eightSemesterPlanGen().get(12).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(12).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(7).getGrade());
                semesterThreeFourField.setText(degreeCraft.eightSemesterPlanGen().get(13).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(13).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(8).getGrade());
                semesterThreeFiveField.setText(degreeCraft.eightSemesterPlanGen().get(14).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(14).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(9).getGrade());
                //semester 4
                semesterFourOneField.setText(degreeCraft.eightSemesterPlanGen().get(15).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(15).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(5).getGrade());
                semesterFourTwoField.setText(degreeCraft.eightSemesterPlanGen().get(16).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(16).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(6).getGrade());
                semesterFourThreeField.setText(degreeCraft.eightSemesterPlanGen().get(17).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(17).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(7).getGrade());
                semesterFourFourField.setText(degreeCraft.eightSemesterPlanGen().get(18).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(18).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(8).getGrade());
                semesterFourFiveField.setText(degreeCraft.eightSemesterPlanGen().get(19).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(19).getCourseCode()+ "     " + degreeCraft.eightSemesterPlanGen().get(9).getGrade());
            }
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

    @FXML
    private void nextButton(ActionEvent event) throws IOException{
        App.getInstance();
        App.setRoot("plan2");
    }
}