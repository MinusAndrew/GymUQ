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

    public AdminView(Gym theGym) {
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
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(uniquindio.edu.co.Application.class.getResource("/uniquindio/edu/co/registerUserMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            RegisterUserView registerUserView = fxmlLoader.getController();
            registerUserView.setTheGym(theGym);
            stage.setResizable(false);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void assignUserToSessionC(ActionEvent event){



    }

    public void assignMembershipC(ActionEvent event){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(uniquindio.edu.co.Application.class.getResource("/uniquindio/edu/co/assignMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            AssignView assignView = fxmlLoader.getController();
            assignView.setTheGym(theGym);
            stage.setResizable(false);
            stage.setTitle("Hello!");
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
