package uniquindio.edu.co.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import uniquindio.edu.co.model.Gym;

import java.io.IOException;

public class MainView {
    private Gym theGym;

    public MainView(Gym theGym) {
        this.theGym = theGym;
    }
    @FXML
    public void registerUserC(ActionEvent event){
        /*

        WARCRIME DO NOT REPLACE

        RegisterView registerView = new RegisterView();
        Stage menuStage = new Stage();
        registerView.setTheGym(theGym);
        registerView.start(menuStage);

         */

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setContentText("No se ha registrado el usuario, \nverifique la informacion y el tipo de dato dado.");

        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(uniquindio.edu.co.Application.class.getResource("/uniquindio/edu/co/registerMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            RegisterView registerView = fxmlLoader.getController();
            registerView.setTheGym(theGym);
            stage.setResizable(false);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            errorAlert.show();
        }
    }


    public void assignUserToSessionC(ActionEvent event){



    }

    public void assignMembershipC(ActionEvent event){




    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }
}
