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

public class EightSemester2Controller {

    @FXML
    private TextField semesterFiveOneField;
    @FXML
    private TextField semesterFiveTwoField;
    @FXML
    private TextField semesterFiveThreeField;
    @FXML
    private TextField semesterFiveFourField;
    @FXML
    private TextField semesterFiveFiveField;

    @FXML
    private TextField semesterSixOneField;
    @FXML
    private TextField semesterSixTwoField;
    @FXML
    private TextField semesterSixThreeField;
    @FXML
    private TextField semesterSixFourField;
    @FXML
    private TextField semesterSixFiveField;

    @FXML
    private TextField semesterSevenOneField;
    @FXML
    private TextField semesterSevenTwoField;
    @FXML
    private TextField semesterSevenThreeField;
    @FXML
    private TextField semesterSevenFourField;
    @FXML
    private TextField semesterSevenFiveField;

    @FXML
    private TextField semesterEightOneField;
    @FXML
    private TextField semesterEightTwoField;
    @FXML
    private TextField semesterEightThreeField;
    @FXML
    private TextField semesterEightFourField;
    @FXML
    private TextField semesterEightFiveField;

    @FXML
    private Button logoutbutton;

    @FXML
    private Button back;

    private Student student;

    private App app;

    private DegreeCraft degreeCraft;

    public EightSemester2Controller() {
        degreeCraft = DegreeCraft.getInstance();
    }

    public void initialize() {
        app = App.getInstance();
        student = (Student) app.getCurrentUser();
        int curr = student.findCurrentSemester();
        if (degreeCraft.eightSemesterPlanGen() != null && degreeCraft.eightSemesterPlanGen().size() > 0) {
            //semester 1
            if(student.getCompletedCourses().size()/2 < 25)
            {
                semesterFiveOneField.setText(degreeCraft.eightSemesterPlanGen().get(20).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(20).getCourseCode());
                semesterFiveTwoField.setText(degreeCraft.eightSemesterPlanGen().get(21).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(21).getCourseCode());
                semesterFiveThreeField.setText(degreeCraft.eightSemesterPlanGen().get(22).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(22).getCourseCode());
                semesterFiveFourField.setText(degreeCraft.eightSemesterPlanGen().get(23).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(23).getCourseCode());
                semesterFiveFiveField.setText(degreeCraft.eightSemesterPlanGen().get(24).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(24).getCourseCode());
                //semester 2
                semesterSixOneField.setText(degreeCraft.eightSemesterPlanGen().get(25).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(25).getCourseCode());
                semesterSixTwoField.setText(degreeCraft.eightSemesterPlanGen().get(26).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(26).getCourseCode());
                semesterSixThreeField.setText(degreeCraft.eightSemesterPlanGen().get(27).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(27).getCourseCode());
                semesterSixFourField.setText(degreeCraft.eightSemesterPlanGen().get(28).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(28).getCourseCode());
                semesterSixFiveField.setText(degreeCraft.eightSemesterPlanGen().get(29).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(29).getCourseCode());
                //semester 3
                semesterSevenOneField.setText(degreeCraft.eightSemesterPlanGen().get(30).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(30).getCourseCode());
                semesterSevenTwoField.setText(degreeCraft.eightSemesterPlanGen().get(31).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(31).getCourseCode());
                semesterSevenThreeField.setText(degreeCraft.eightSemesterPlanGen().get(32).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(32).getCourseCode());
                semesterSevenFourField.setText(degreeCraft.eightSemesterPlanGen().get(33).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(33).getCourseCode());
                semesterSevenFiveField.setText(degreeCraft.eightSemesterPlanGen().get(34).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(34).getCourseCode());
                //semester 4
                semesterEightOneField.setText(degreeCraft.eightSemesterPlanGen().get(35).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(35).getCourseCode());
                semesterEightTwoField.setText(degreeCraft.eightSemesterPlanGen().get(36).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(36).getCourseCode());
                semesterEightThreeField.setText(degreeCraft.eightSemesterPlanGen().get(37).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(37).getCourseCode());
                semesterEightFourField.setText(degreeCraft.eightSemesterPlanGen().get(38).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(38).getCourseCode());
                semesterEightFiveField.setText(degreeCraft.eightSemesterPlanGen().get(39).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(39).getCourseCode());
            }
            else if(student.getCompletedCourses().size()/2 >= 25 && student.getCompletedCourses().size()/2 < 30)
            {
                semesterFiveOneField.setText(degreeCraft.eightSemesterPlanGen().get(20).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(20).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(20).getGrade());
                semesterFiveTwoField.setText(degreeCraft.eightSemesterPlanGen().get(21).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(21).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(21).getGrade());
                semesterFiveThreeField.setText(degreeCraft.eightSemesterPlanGen().get(22).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(22).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(22).getGrade());
                semesterFiveFourField.setText(degreeCraft.eightSemesterPlanGen().get(23).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(23).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(23).getGrade());
                semesterFiveFiveField.setText(degreeCraft.eightSemesterPlanGen().get(24).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(24).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(24).getGrade());
                //semester 2
                semesterSixOneField.setText(degreeCraft.eightSemesterPlanGen().get(25).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(25).getCourseCode());
                semesterSixTwoField.setText(degreeCraft.eightSemesterPlanGen().get(26).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(26).getCourseCode());
                semesterSixThreeField.setText(degreeCraft.eightSemesterPlanGen().get(27).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(27).getCourseCode());
                semesterSixFourField.setText(degreeCraft.eightSemesterPlanGen().get(28).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(28).getCourseCode());
                semesterSixFiveField.setText(degreeCraft.eightSemesterPlanGen().get(29).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(29).getCourseCode());
                //semester 3
                semesterSevenOneField.setText(degreeCraft.eightSemesterPlanGen().get(30).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(30).getCourseCode());
                semesterSevenTwoField.setText(degreeCraft.eightSemesterPlanGen().get(31).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(31).getCourseCode());
                semesterSevenThreeField.setText(degreeCraft.eightSemesterPlanGen().get(32).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(32).getCourseCode());
                semesterSevenFourField.setText(degreeCraft.eightSemesterPlanGen().get(33).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(33).getCourseCode());
                semesterSevenFiveField.setText(degreeCraft.eightSemesterPlanGen().get(34).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(34).getCourseCode());
                //semester 4
                semesterEightOneField.setText(degreeCraft.eightSemesterPlanGen().get(35).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(35).getCourseCode());
                semesterEightTwoField.setText(degreeCraft.eightSemesterPlanGen().get(36).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(36).getCourseCode());
                semesterEightThreeField.setText(degreeCraft.eightSemesterPlanGen().get(37).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(37).getCourseCode());
                semesterEightFourField.setText(degreeCraft.eightSemesterPlanGen().get(38).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(38).getCourseCode());
                semesterEightFiveField.setText(degreeCraft.eightSemesterPlanGen().get(39).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(39).getCourseCode());
            }
            else if(student.getCompletedCourses().size()/2 >= 30 && student.getCompletedCourses().size()/2 < 35)
            {
                semesterFiveOneField.setText(degreeCraft.eightSemesterPlanGen().get(20).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(20).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(20).getGrade());
                semesterFiveTwoField.setText(degreeCraft.eightSemesterPlanGen().get(21).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(21).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(21).getGrade());
                semesterFiveThreeField.setText(degreeCraft.eightSemesterPlanGen().get(22).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(22).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(22).getGrade());
                semesterFiveFourField.setText(degreeCraft.eightSemesterPlanGen().get(23).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(23).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(23).getGrade());
                semesterFiveFiveField.setText(degreeCraft.eightSemesterPlanGen().get(24).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(24).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(24).getGrade());
                //semester 2
                semesterSixOneField.setText(degreeCraft.eightSemesterPlanGen().get(25).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(25).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(25).getGrade());
                semesterSixTwoField.setText(degreeCraft.eightSemesterPlanGen().get(26).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(26).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(26).getGrade());
                semesterSixThreeField.setText(degreeCraft.eightSemesterPlanGen().get(27).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(27).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(27).getGrade());
                semesterSixFourField.setText(degreeCraft.eightSemesterPlanGen().get(28).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(28).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(28).getGrade());
                semesterSixFiveField.setText(degreeCraft.eightSemesterPlanGen().get(29).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(29).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(29).getGrade());
                //semester 3
                semesterSevenOneField.setText(degreeCraft.eightSemesterPlanGen().get(30).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(30).getCourseCode());
                semesterSevenTwoField.setText(degreeCraft.eightSemesterPlanGen().get(31).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(31).getCourseCode());
                semesterSevenThreeField.setText(degreeCraft.eightSemesterPlanGen().get(32).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(32).getCourseCode());
                semesterSevenFourField.setText(degreeCraft.eightSemesterPlanGen().get(33).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(33).getCourseCode());
                semesterSevenFiveField.setText(degreeCraft.eightSemesterPlanGen().get(34).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(34).getCourseCode());
                //semester 4
                semesterEightOneField.setText(degreeCraft.eightSemesterPlanGen().get(35).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(35).getCourseCode());
                semesterEightTwoField.setText(degreeCraft.eightSemesterPlanGen().get(36).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(36).getCourseCode());
                semesterEightThreeField.setText(degreeCraft.eightSemesterPlanGen().get(37).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(37).getCourseCode());
                semesterEightFourField.setText(degreeCraft.eightSemesterPlanGen().get(38).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(38).getCourseCode());
                semesterEightFiveField.setText(degreeCraft.eightSemesterPlanGen().get(39).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(39).getCourseCode());
            }
            else if(student.getCompletedCourses().size()/2 >= 35 && student.getCompletedCourses().size()/2 < 40)
            {
                semesterFiveOneField.setText(degreeCraft.eightSemesterPlanGen().get(20).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(20).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(20).getGrade());
                semesterFiveTwoField.setText(degreeCraft.eightSemesterPlanGen().get(21).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(21).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(21).getGrade());
                semesterFiveThreeField.setText(degreeCraft.eightSemesterPlanGen().get(22).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(22).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(22).getGrade());
                semesterFiveFourField.setText(degreeCraft.eightSemesterPlanGen().get(23).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(23).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(23).getGrade());
                semesterFiveFiveField.setText(degreeCraft.eightSemesterPlanGen().get(24).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(24).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(24).getGrade());
                //semester 2
                semesterSixOneField.setText(degreeCraft.eightSemesterPlanGen().get(25).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(25).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(25).getGrade());
                semesterSixTwoField.setText(degreeCraft.eightSemesterPlanGen().get(26).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(26).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(26).getGrade());
                semesterSixThreeField.setText(degreeCraft.eightSemesterPlanGen().get(27).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(27).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(27).getGrade());
                semesterSixFourField.setText(degreeCraft.eightSemesterPlanGen().get(28).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(28).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(28).getGrade());
                semesterSixFiveField.setText(degreeCraft.eightSemesterPlanGen().get(29).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(29).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(29).getGrade());
                //semester 3
                semesterSevenOneField.setText(degreeCraft.eightSemesterPlanGen().get(30).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(30).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(30).getGrade());
                semesterSevenTwoField.setText(degreeCraft.eightSemesterPlanGen().get(31).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(31).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(31).getGrade());
                semesterSevenThreeField.setText(degreeCraft.eightSemesterPlanGen().get(32).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(32).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(32).getGrade());
                semesterSevenFourField.setText(degreeCraft.eightSemesterPlanGen().get(33).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(33).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(33).getGrade());
                semesterSevenFiveField.setText(degreeCraft.eightSemesterPlanGen().get(34).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(34).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(34).getGrade());
                //semester 4
                semesterEightOneField.setText(degreeCraft.eightSemesterPlanGen().get(35).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(35).getCourseCode());
                semesterEightTwoField.setText(degreeCraft.eightSemesterPlanGen().get(36).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(36).getCourseCode());
                semesterEightThreeField.setText(degreeCraft.eightSemesterPlanGen().get(37).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(37).getCourseCode());
                semesterEightFourField.setText(degreeCraft.eightSemesterPlanGen().get(38).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(38).getCourseCode());
                semesterEightFiveField.setText(degreeCraft.eightSemesterPlanGen().get(39).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(39).getCourseCode());
            }
            else
            {
                semesterFiveOneField.setText(degreeCraft.eightSemesterPlanGen().get(20).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(20).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(20).getGrade());
                semesterFiveTwoField.setText(degreeCraft.eightSemesterPlanGen().get(21).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(21).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(21).getGrade());
                semesterFiveThreeField.setText(degreeCraft.eightSemesterPlanGen().get(22).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(22).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(22).getGrade());
                semesterFiveFourField.setText(degreeCraft.eightSemesterPlanGen().get(23).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(23).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(23).getGrade());
                semesterFiveFiveField.setText(degreeCraft.eightSemesterPlanGen().get(24).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(24).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(24).getGrade());
                //semester 2
                semesterSixOneField.setText(degreeCraft.eightSemesterPlanGen().get(25).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(25).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(25).getGrade());
                semesterSixTwoField.setText(degreeCraft.eightSemesterPlanGen().get(26).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(26).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(26).getGrade());
                semesterSixThreeField.setText(degreeCraft.eightSemesterPlanGen().get(27).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(27).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(27).getGrade());
                semesterSixFourField.setText(degreeCraft.eightSemesterPlanGen().get(28).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(28).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(28).getGrade());
                semesterSixFiveField.setText(degreeCraft.eightSemesterPlanGen().get(29).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(29).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(29).getGrade());
                //semester 3
                semesterSevenOneField.setText(degreeCraft.eightSemesterPlanGen().get(30).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(30).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(30).getGrade());
                semesterSevenTwoField.setText(degreeCraft.eightSemesterPlanGen().get(31).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(31).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(31).getGrade());
                semesterSevenThreeField.setText(degreeCraft.eightSemesterPlanGen().get(32).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(32).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(32).getGrade());
                semesterSevenFourField.setText(degreeCraft.eightSemesterPlanGen().get(33).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(33).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(33).getGrade());
                semesterSevenFiveField.setText(degreeCraft.eightSemesterPlanGen().get(34).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(34).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(34).getGrade());
                //semester 4
                semesterEightOneField.setText(degreeCraft.eightSemesterPlanGen().get(35).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(35).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(35).getGrade());
                semesterEightTwoField.setText(degreeCraft.eightSemesterPlanGen().get(36).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(36).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(36).getGrade());
                semesterEightThreeField.setText(degreeCraft.eightSemesterPlanGen().get(37).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(37).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(37).getGrade());
                semesterEightFourField.setText(degreeCraft.eightSemesterPlanGen().get(38).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(38).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(38).getGrade());
                semesterEightFiveField.setText(degreeCraft.eightSemesterPlanGen().get(39).getCourseName() + "      " + degreeCraft.eightSemesterPlanGen().get(39).getCourseCode()+ "      " + degreeCraft.eightSemesterPlanGen().get(39).getGrade());
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
    private void backButton(ActionEvent event) throws IOException{
        App.getInstance();
        App.setRoot("plan");
    }
}