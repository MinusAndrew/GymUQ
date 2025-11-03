package uniquindio.edu.co.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import uniquindio.edu.co.viewController.RegisterView;

public class MainMenu {

    @FXML

    public void registerUserC(ActionEvent event){
        RegisterView registerView = new RegisterView();
        Stage menuStage = new Stage();
        registerView.start(menuStage);
    }


    public void assignUserToSessionC(ActionEvent event){



    }

    public void assignMembershipC(ActionEvent event){




    }


}
