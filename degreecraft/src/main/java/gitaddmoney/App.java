package gitaddmoney;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.UUID;

import model.DegreeCraft;
import model.User;

public class App extends Application {

    private static App instance;
    private static Scene scene;
    private DegreeCraft degreeCraft;
    private User currentUser;

    public App() {
        DegreeCraft.getInstance().loadAll();
    }

    // Static method to retrieve the single instance of App
    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    @Override
    public void start(Stage stage) throws IOException {
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
    public void loginStudentSuccessful() throws IOException {
        // currentUser = degreeCraft.getCurrentUser();
        setRoot("studenthome");
    }

    public void loginAdvisorSuccessful() throws IOException {
        setRoot("advisorhome");
    }

    public void goToDegreeProgression() throws IOException {
        setRoot("homepage");
        // setRoot("degreeProgression");
    }

    public void signedUp() throws IOException {
        setRoot("login"); 
    }
    
    // Method to handle logout and switch back to the login UI
    public void logout() throws IOException {
        setRoot("login"); 
    }

    public void signUpInstead() throws IOException {
        setRoot("signup"); // this should work once homepage is made
    }
    
    public User getCurrentUser() {
        // System.out.println(degreeCraft.getCurrentUser().toString());
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        if(currentUser != null){
            this.currentUser = currentUser;
        }
    }
}
