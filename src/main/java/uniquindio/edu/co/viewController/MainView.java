package uniquindio.edu.co.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.staffs.Receptionist;

import java.io.IOException;

public class MainView {
    private Gym theGym;
    private Receptionist theReceptionist;

    @FXML
    public void registerUserC(ActionEvent event){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(uniquindio.edu.co.Application.class.getResource("/uniquindio/edu/co/registerUserMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            RegisterUserView registerUserView = fxmlLoader.getController();
            registerUserView.setTheGym(theGym);
            stage.setResizable(false);
            stage.setTitle("Menú Registrar Usuario: ");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

         /*

        WARCRIME DO NOT REPLACE

        RegisterView registerView = new RegisterView();
        Stage menuStage = new Stage();
        registerView.setTheGym(theGym);
        registerView.start(menuStage);

         */

    }

    public void openStaffStageB(){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(uniquindio.edu.co.Application.class.getResource("/uniquindio/edu/co/miniLoginMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            MiniLoginView miniLoginView = fxmlLoader.getController();
            miniLoginView.setTheGym(theGym);
            stage.setResizable(false);
            stage.setTitle("Menú Registrar Usuario: ");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void assignUserToSessionB(ActionEvent event){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(uniquindio.edu.co.Application.class.getResource("/uniquindio/edu/co/assignSessionMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            AssignSessionView assignSessionView = fxmlLoader.getController();
            assignSessionView.setTheGym(theGym);
            assignSessionView.fillUpSessionList();
            assignSessionView.fillUpUserList();
            stage.setResizable(false);
            stage.setTitle("Menu: Asignar Clase");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkMembershipB(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setContentText("No se ha podido acceder a la funcionalidad.\nverifique que esté iniciado sesión como Recepcionista.");
        if (theReceptionist == null){
            errorAlert.show();
        }
        else {
            try {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(uniquindio.edu.co.Application.class.getResource("/uniquindio/edu/co/checkMembershipMenu.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                CheckMembershipView checkMembershipView = fxmlLoader.getController();
                checkMembershipView.setTheGym(theGym);
                checkMembershipView.setTheReceptionist(theReceptionist);
                stage.setResizable(false);
                stage.setTitle("Menú: Chequear Membrecia ");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void assignMembershipC(ActionEvent event){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(uniquindio.edu.co.Application.class.getResource("/uniquindio/edu/co/assignMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            AssignMembershipView assignMembershipView = fxmlLoader.getController();
            assignMembershipView.setTheGym(theGym);
            assignMembershipView.fillUpList();
            stage.setResizable(false);
            stage.setTitle("Menú: Asignar Membrecia");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void receptionistReportB(){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(uniquindio.edu.co.Application.class.getResource("/uniquindio/edu/co/reportMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            ReportView reportView = fxmlLoader.getController();
            reportView.setTheGym(theGym);
            reportView.setContent();
            stage.setResizable(false);
            stage.setTitle("Reporte Recepcionista");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }

    public void setTheReceptionist(Receptionist theReceptionist) {
        this.theReceptionist = theReceptionist;
    }
}
