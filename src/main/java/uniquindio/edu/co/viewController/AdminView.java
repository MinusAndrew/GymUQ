package uniquindio.edu.co.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uniquindio.edu.co.Controller.ModifyTrainerMenu;
import uniquindio.edu.co.model.Gym;

import java.io.IOException;

public class AdminView {
    private Gym theGym;

    @FXML
    public void registerTrainerB(ActionEvent event){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(uniquindio.edu.co.Application.class.getResource("/uniquindio/edu/co/registerTrainerMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            RegisterTrainerView registerTrainerView = fxmlLoader.getController();
            registerTrainerView.setTheGym(theGym);
            stage.setResizable(false);
            stage.setTitle("Registrar Entrenador");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void modifyTrainerB(ActionEvent event){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(uniquindio.edu.co.Application.class.getResource("/uniquindio/edu/co/modifyTrainerMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ModifyTrainerView modifyTrainerView = fxmlLoader.getController();
            modifyTrainerView.setTheGym(theGym);
            modifyTrainerView.fillUpList();
            stage.setResizable(false);
            stage.setTitle("Registrar Entrenador");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }
}
