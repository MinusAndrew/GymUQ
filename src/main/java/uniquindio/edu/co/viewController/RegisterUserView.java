package uniquindio.edu.co.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uniquindio.edu.co.Controller.RegisterMenu;
import uniquindio.edu.co.model.*;


import java.net.URL;
import java.util.ResourceBundle;

public class RegisterUserView implements Initializable {
    private Gym theGym;
    @FXML
    private Button registerButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField personalIdField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField ageField;
    @FXML
    private ChoiceBox<String> userType;

    @FXML
    private AnchorPane scenePane;

    Stage currentWindow;

    private final String[] userTypes = {"Estudiante", "Trabajador", "Externo"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userType.getItems().addAll(userTypes);
    }

    public void pressRegisterButton(ActionEvent event){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setContentText("No se ha registrado el usuario, \nverifique que los datos dados sean correctos");


        currentWindow = (Stage) scenePane.getScene().getWindow();

        try {
            int age = grabAge();
            int personalId = grabPersonalId();
            String name = grabName();
            String lastName = grabLastName();
            String phoneNumber = grabPhoneNum();
            RegisterMenu registerMenu = new RegisterMenu();
            registerMenu.setTheGym(theGym);

            String option = userType.getValue();

            User newUser;

            Alert succsessAlert = new Alert(Alert.AlertType.INFORMATION);
            succsessAlert.setContentText("El Usuario se registró correctamente.");

            switch (option){
                case ("Estudiante"):
                    newUser = new Student(name, lastName, personalId, phoneNumber, age);
                    registerMenu.registerUser(newUser);
                    currentWindow.close();
                    break;
                case ("Trabajador"):
                 //   newUser = new Worker(name, lastName, personalId, phoneNumber, age);
                    //registerMenu.registerUser(newUser);
                    currentWindow.close();
                    break;
                case ("Externo"):
                    newUser = new Individual(name, lastName, personalId, phoneNumber, age);
                    registerMenu.registerUser(newUser);
                    currentWindow.close();
                    break;
            }
            succsessAlert.show();
        }
        catch (Throwable e){
            errorAlert.show();
        }
    }

    public int grabAge(){
        return Integer.parseInt(ageField.getText());
    }

    public String grabName(){
        return nameField.getText();
    }

    public String grabLastName(){
        return lastNameField.getText();
    }

    public int grabPersonalId(){
        return Integer.parseInt(personalIdField.getText());
    }

    public String grabPhoneNum(){
        return phoneNumberField.getText();
    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }
}
