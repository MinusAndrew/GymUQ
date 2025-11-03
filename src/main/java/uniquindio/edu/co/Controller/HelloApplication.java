package uniquindio.edu.co.Controller;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group rootNode = new Group();
        Scene scene = new Scene(rootNode, Color.CYAN);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
