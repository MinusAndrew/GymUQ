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
                    mainView.setTheReceptionist(theGym.getReceptionistFromName(name));
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

                      /*
                    stage.setOnCloseRequest(e -> {
                        System.out.println("puta vida");
                        Stage stage9 = new Stage();
                        FXMLLoader fxmlLoader9 = new FXMLLoader(Application.class.getResource("/uniquindio/edu/co/loginMenu.fxml"));
                        Scene scene9 = null;
                        try {
                            scene9 = new Scene(fxmlLoader9.load());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        LoginView loginView = fxmlLoader9.getController();
                        loginView.setTheGym(theGym);
                        stage9.setResizable(false);
                        stage9.setTitle("Main Menu");
                        stage9.setScene(scene9);
                        stage9.show();

                    } );

                    Will Comeback to this prob

                     */
                    break;
                case ('T'):
                    FXMLLoader fxmlLoader3 = new FXMLLoader(Application.class.getResource("/uniquindio/edu/co/trainerMenu.fxml"));
                    Scene scene3 = new Scene(fxmlLoader3.load());
                    TrainerView trainerView = fxmlLoader3.getController();
                    trainerView.setTheGym(theGym);
                    trainerView.setTheTrainer(theGym.getTrainerFromName(name));
                    trainerView.fillUpSessionList();
                    stage.setResizable(false);
                    stage.setTitle("Trainer Menu");
                    stage.setScene(scene3);
                    stage.show();

                    Stage stage4 = new Stage();
                    FXMLLoader fxmlLoader4 = new FXMLLoader(Application.class.getResource("/uniquindio/edu/co/mainMenu.fxml"));
                    Scene scene4 = new Scene(fxmlLoader4.load());
                    MainView mainView4 = fxmlLoader4.getController();
                    mainView4.setTheGym(theGym);
                    stage4.setResizable(false);
                    stage4.setTitle("Main Menu");
                    stage4.setScene(scene4);
                    stage4.show();
                }
                currentWindow.close();
            }
            else {
                errorAlert.show();
        }

        }

    public void createLoginMenu() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/uniquindio/edu/co/loginMenu.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load());
        LoginView loginView = fxmlLoader.getController();
        loginView.setTheGym(theGym);
        stage.setResizable(false);
        stage.setTitle("Main Menu");
        stage.setScene(scene1);
        stage.show();
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
