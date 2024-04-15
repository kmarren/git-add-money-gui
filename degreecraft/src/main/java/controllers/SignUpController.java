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

public class SignUpController {
    @FXML
    private TextField userTypeField;
    
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;

    private DegreeCraft degreeCraft;

    public SignUpController() {
        degreeCraft = DegreeCraft.getInstance();
    }

    @FXML
    private void initialize() {
        // idk what would go here
    }

    @FXML
    private void handleSignedUpButtonAction(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String userType = userTypeField.getText();
        degreeCraft.signUp(username, password, userType);
        App app = new App();
        app.signedUp();
    }
}
