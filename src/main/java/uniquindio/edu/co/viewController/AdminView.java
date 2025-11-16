package uniquindio.edu.co.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uniquindio.edu.co.model.Gym;

import java.io.IOException;

public class AdminView {
    private Gym theGym;

    @FXML
    public void registerTrainerB(ActionEvent event){
        /*

        WARCRIME DO NOT REPLACE

        RegisterView registerView = new RegisterView();
        Stage menuStage = new Stage();
        registerView.setTheGym(theGym);
        registerView.start(menuStage);

         */
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


    public void assignUserToSessionC(ActionEvent event){




    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }
}
