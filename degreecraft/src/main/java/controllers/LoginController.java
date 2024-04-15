package controllers;

import java.io.IOException;

import gitaddmoney.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.DegreeCraft;

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

        if (degreeCraft.canLogin(username, password)) {
            // Perform login
            degreeCraft.login(username, password);
            App app = new App();
            app.loginSuccessful();
        } else {
            // Display error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NO LOGIN 4 U");
            alert.setHeaderText("YOUR PASSWORD OR USERNAME WAS WRONG");
            alert.setContentText("PASSWORD WRONG BUDDY");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleSignUpButtonAction(ActionEvent event) throws IOException {
        App app = new App();
        app.signUpInstead();
    }
}
