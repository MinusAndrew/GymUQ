package uniquindio.edu.co.viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uniquindio.edu.co.Controller.RegisterMenu;
import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.Session;
import uniquindio.edu.co.model.staffs.Trainer;

import java.lang.ref.PhantomReference;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class RegisterSessionView implements Initializable {
    private Gym theGym;

    @FXML
    private TableView<Trainer> trainerTable;
    @FXML
    private TableColumn<Trainer, String> trainerFirstNameColumn;
    @FXML
    private TableColumn<Trainer, String> trainerLastNameColumn;
    @FXML
    private TableColumn<Trainer, Integer> trainerAgeColumn;
    @FXML
    private TableColumn<Trainer, Integer> trainerPersonalIdColumn;
    @FXML
    private TableColumn<Trainer, String> trainerPhoneNumColumn;

    @FXML
    private TextField typeLabel;
    @FXML
    private TextField nameLabel;
    @FXML
    private TextField maxCapLabel;
    @FXML
    private TextField dayLabel;
    @FXML
    private TextField monthLabel;
    @FXML
    private TextField yearLabel;
    @FXML
    private TextField hourLabel;
    @FXML
    private TextField minuteLabel;

    @FXML
    private AnchorPane scenePane;

    Stage currentWindow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        trainerFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        trainerLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        trainerPersonalIdColumn.setCellValueFactory(new PropertyValueFactory<>("personalId"));
        trainerPhoneNumColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        trainerAgeColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

    }

    public void fillUpList(){
        trainerTable.getItems().addAll(theGym.getTrainersList());
    }


    public void createSessionB(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setContentText("No se ha registrado la clase, \nverifique que los datos dados sean correctos \no haya seleccionado un entrenador.");

        currentWindow = (Stage) scenePane.getScene().getWindow();

        try {
            RegisterMenu registerMenu = new RegisterMenu();
            registerMenu.setTheGym(theGym);

            String name = grabName();
            String type = grabType();
            int maxCap = grabMaxCap();
            int day = grabDay();
            int month = grabMonth();
            int year = grabYear();
            int hour = grabHourVal();
            int minute = grabMinuteVal();
            Trainer trainer = trainerTable.getSelectionModel().getSelectedItem();
            if (year >= 2020 && year <= 7272){
                Session session = new Session(maxCap, type, LocalDate.of(year, month, day), name, trainer, LocalTime.of(hour, minute));
                registerMenu.registerSessionToTrainer(trainer, session);
                registerMenu.registerSession(session);
                Alert succsessAlert = new Alert(Alert.AlertType.INFORMATION);
                succsessAlert.setContentText("La Clase se registró correctamente.");
                succsessAlert.show();
                currentWindow.close();
            }
            else {
                errorAlert.show();
            }
        } catch (Exception e) {
            errorAlert.show();
            System.out.println(e);
        }


    }

    public String grabName(){
        return nameLabel.getText();
    }

    public String grabType(){
        return typeLabel.getText();
    }

    public int grabYear(){
        return Integer.parseInt(yearLabel.getText());
    }

    public int grabMonth(){
        return Integer.parseInt(monthLabel.getText());
    }

    public int grabDay(){
        return Integer.parseInt(dayLabel.getText());
    }

    public int grabMaxCap(){
        return Integer.parseInt(maxCapLabel.getText());
    }

    public int grabHourVal(){
        return Integer.parseInt(hourLabel.getText());
    }

    public int grabMinuteVal(){
        return Integer.parseInt(minuteLabel.getText());
    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }
}
