package controllers;

import java.io.IOException;

import gitaddmoney.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Advisor;
import model.Student;
import model.DegreeCraft;

public class AdvisorHomeController {

    @FXML
    private TextField officeField;

    @FXML
    private TextField officeHoursField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField schoolOfFocusField;

    @FXML
    private TextField adviseeListField;

    @FXML
    private Button viewAdviseeProfileButton;

    @FXML
    private Button logoutbutton;

    private Advisor advisor;

    private App app;

    public void initialize() {
        app = App.getInstance();
        advisor = (Advisor) app.getCurrentUser();

        officeField.setText(advisor.getOffice() != null ? advisor.getOffice() : "Unknown");
        officeHoursField.setText(advisor.getOfficeHours() != null ? advisor.getOfficeHours() : "Unknown");
        phoneNumberField.setText(advisor.getPhoneNumber() != null ? advisor.getPhoneNumber() : "Unknown");
        schoolOfFocusField.setText(advisor.getSchoolOfFocus() != null ? advisor.getSchoolOfFocus() : "Unknown");
        if (advisor.getAdviseeList() != null && advisor.getAdviseeList().size() > 0) {
            int i = 0;
            StringBuilder adviseeList = new StringBuilder();
            for (Student advisee : advisor.getAdviseeList()) {
                adviseeList.append(advisee.getFirstName()).append(" ").append(advisee.getLastName());
                if (i != advisor.getAdviseeList().size() - 1) {
                    adviseeList.append(", ");
                }
                i++;
            }
            adviseeListField.setText(adviseeList.toString());
        }
    }

    @FXML
    private void handleViewAdviseeProfileAction(ActionEvent event) {
        // TODO: Implement this method
    }

    @FXML
    private void logoutButton(ActionEvent event) throws IOException {
        DegreeCraft.getInstance().logout();
        App.getInstance().logout();
    }
}
