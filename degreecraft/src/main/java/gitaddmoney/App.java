package gitaddmoney;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import model.DegreeCraft;

public class App extends Application {

    private static Scene scene;
    private DegreeCraft degreeCraft;

    @Override
    public void start(Stage stage) throws IOException {
        degreeCraft = DegreeCraft.getInstance();
        
        scene = new Scene(loadFXML("login"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    // Method to handle successful login and switch to the main application UI
    public void loginSuccessful() throws IOException {
        setRoot("homepage"); // this should work once homepage is made
    }
    
    // Method to handle logout and switch back to the login UI
    public void logout() throws IOException {
        setRoot("login"); 
    }
}
