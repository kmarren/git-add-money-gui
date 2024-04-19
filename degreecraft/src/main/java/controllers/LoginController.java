package controllers;

import java.io.IOException;
import java.util.ArrayList;

import gitaddmoney.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Advisor;
import model.DegreeCraft;
import model.Faculty;
import model.Student;
import model.User;
import model.UserList;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    private DegreeCraft degreeCraft;

    public LoginController() {
        degreeCraft = DegreeCraft.getInstance();
    }

    @FXML
    private void initialize() {
        // idk what would go here
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        App app = App.getInstance();
        User loggedInUser = UserList.getInstance().getUser(username, password);

        if (loggedInUser != null) {
            if (loggedInUser instanceof Student) {
                degreeCraft.login(username, password); 
                degreeCraft.setStudent((Student)loggedInUser);
                app.setCurrentUser(loggedInUser);
                app.loginStudentSuccessful();
            } else if (loggedInUser instanceof Advisor || loggedInUser instanceof Faculty) {
                degreeCraft.login(username, password);
                app.setCurrentUser(loggedInUser);
                app.loginAdvisorSuccessful();
            }
        } else {
            // Display error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid username or password");
            alert.setContentText("Please check your credentials and try again.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleSignUpButtonAction(ActionEvent event) throws IOException {
        App app = App.getInstance();
        app.signUpInstead();
    }
}
