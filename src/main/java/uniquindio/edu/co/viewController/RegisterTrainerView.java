package uniquindio.edu.co.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uniquindio.edu.co.Controller.RegisterMenu;
import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.Individual;
import uniquindio.edu.co.model.Student;
import uniquindio.edu.co.model.User;
import uniquindio.edu.co.model.staffs.Trainer;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterTrainerView {

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
    private PasswordField trainerPasswdField;

    @FXML
    private AnchorPane scenePane;

    Stage currentWindow;

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

            String passwd = grabPasswd();

            Trainer newTrainer;

            Alert succsessAlert = new Alert(Alert.AlertType.INFORMATION);
            succsessAlert.setContentText("El Usuario se registró correctamente.");

            newTrainer = new Trainer(name, lastName, personalId, phoneNumber, age, passwd);
            registerMenu.registerTrainer(newTrainer);
            currentWindow.close();

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

    public String grabPasswd(){
        return trainerPasswdField.getText();
    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }



}
