package uniquindio.edu.co.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uniquindio.edu.co.Application;
import uniquindio.edu.co.model.Gym;

import java.io.IOException;

public class LoginView {
    private Gym theGym;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwdField;

    @FXML
    private AnchorPane loginPane;

    Stage currentWindow;


    public void loginFX() throws IOException {

        currentWindow = (Stage) loginPane.getScene().getWindow();

        String name = grabUser();
        String passwd = grabPasswd();

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setContentText("No se ha ingresado, \nverifique que los datos dados sean correctos");

        if (theGym.login(name, passwd)){
            Stage stage = new Stage();
            switch (passwd.charAt(0)){
                case ('R'):
                    FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/uniquindio/edu/co/mainMenu.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    MainView mainView = fxmlLoader.getController();
                    mainView.setTheGym(theGym);
                    stage.setResizable(false);
                    stage.setTitle("Main Menu");
                    stage.setScene(scene);
                    stage.show();
                    break;
                case ('A'):
                    Stage stage1 = new Stage();
                    FXMLLoader fxmlLoader1 = new FXMLLoader(Application.class.getResource("/uniquindio/edu/co/mainMenu.fxml"));
                    Scene scene1 = new Scene(fxmlLoader1.load());
                    MainView mainView1 = fxmlLoader1.getController();
                    mainView1.setTheGym(theGym);
                    stage.setResizable(false);
                    stage.setTitle("Main Menu");
                    stage.setScene(scene1);
                    stage.show();

                    FXMLLoader fxmlLoader2 = new FXMLLoader(Application.class.getResource("/uniquindio/edu/co/adminMenu.fxml"));
                    Scene scene2 = new Scene(fxmlLoader2.load());
                    AdminView adminView = fxmlLoader2.getController();
                    adminView.setTheGym(theGym);
                    stage1.setResizable(false);
                    stage1.setTitle("Admin Menu");
                    stage1.setScene(scene2);
                    stage1.show();
                    break;
                case ('T'):
                    FXMLLoader fxmlLoader3 = new FXMLLoader(Application.class.getResource("/uniquindio/edu/co/trainerMenu.fxml"));
                    Scene scene3 = new Scene(fxmlLoader3.load());
                    TrainerView trainerView = fxmlLoader3.getController();
                    trainerView.setTheGym(theGym);
                    stage.setResizable(false);
                    stage.setTitle("Hello!");
                    stage.setScene(scene3);
                    stage.show();
                }
                currentWindow.close();
            }
            else {
                errorAlert.show();
        }

        }


    public String grabUser(){
        return usernameField.getText();
    }

    public String grabPasswd(){
        return passwdField.getText();
    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }

}
