package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import model.DegreeCraft;
import gitaddmoney.App;

public class HomepageController {

    private Stage stage;

    // Method to set the stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void handleLogoutButtonAction(ActionEvent event) throws IOException {
        DegreeCraft degreeCraft = DegreeCraft.getInstance();
        degreeCraft.logout();
        App app = new App();
        app.logout();
    }
}
