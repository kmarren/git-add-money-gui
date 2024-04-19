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
    private TextField semesterOneField;

    @FXML
    private Button logoutbutton;

    private Student student;

    private App app;

    public void initialize() {
        app = App.getInstance();
        student = (Student) app.getCurrentUser();
        if (student.getMajor().getRequiredCourses() != null && student.getMajor().getRequiredCourses().size() > 0) {
            int i = 0;
            StringBuilder courseList = new StringBuilder();
            for (Course course : student.getMajor().getRequiredCourses()) 
            {
                courseList.append(course.getCourseName()).append(" ").append(course.getCourseCode()).append(" ").append(course.getCreditWorth()).append("\n");
                if (i != student.getMajor().getRequiredCourses().size() - 1) {
                    courseList.append(", ");
                }
                i++;
            }
            semesterOneField.setText(courseList.toString());
        }
    }

    @FXML
    private void logoutButton(ActionEvent event) throws IOException {
        DegreeCraft.getInstance().logout();
        App.getInstance().logout();
    }
}