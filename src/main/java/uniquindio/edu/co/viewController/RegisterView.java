package uniquindio.edu.co.viewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(uniquindio.edu.co.Application.class.getResource("/uniquindio/edu/co/registerMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setResizable(false);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}
