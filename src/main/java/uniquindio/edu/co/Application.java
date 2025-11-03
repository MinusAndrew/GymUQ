package uniquindio.edu.co;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/uniquindio/edu/co/mainMenu.fxml"));
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
