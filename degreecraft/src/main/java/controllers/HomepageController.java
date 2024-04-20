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

    private DegreeCraft degreeCraft;

    public HomepageController() {
        degreeCraft = DegreeCraft.getInstance();
    }

    @FXML
    private void handleLogoutButtonAction(ActionEvent event) throws IOException {
        degreeCraft.logout();
        App app = App.getInstance();
        app.logout();
    }
}
