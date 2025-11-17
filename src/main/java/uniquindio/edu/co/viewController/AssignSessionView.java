package uniquindio.edu.co.viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uniquindio.edu.co.Controller.AssignMenu;
import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.Session;
import uniquindio.edu.co.model.User;
import uniquindio.edu.co.model.staffs.Trainer;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AssignSessionView implements Initializable {
    private Gym theGym;

    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, String> userFirstNameColumn;
    @FXML
    private TableColumn<User, String> userLastNameColumn;
    @FXML
    private TableColumn<User, Integer> userAgeColumn;
    @FXML
    private TableColumn<User, Integer> userPersonalIdColumn;
    @FXML
    private TableColumn<User, String> userPhoneNumColumn;
    @FXML
    private TableColumn<User, String> userEmailColumn;

    @FXML
    private TableView<Session> sessionTable;
    @FXML
    private TableColumn <Session, String> nameColumn;
    @FXML
    private TableColumn <Session, String> typeColumn;
    @FXML
    private TableColumn <Session, String> capacityColumn;
    @FXML
    private TableColumn <Session, LocalDate> dateColumn;
    @FXML
    private TableColumn <Session, Trainer> trainerColumn;
    @FXML
    private TableColumn <Session, LocalTime> hourColumn;

    @FXML
    private AnchorPane scenePane;

    Stage currentWindow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        userLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        userPersonalIdColumn.setCellValueFactory(new PropertyValueFactory<>("personalId"));
        userPhoneNumColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        userAgeColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        userEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("maxCapacity"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("schedule"));
        hourColumn.setCellValueFactory(new PropertyValueFactory<>("hour"));
        trainerColumn.setCellValueFactory(new PropertyValueFactory<>("theTrainer"));

    }

    public void fillUpUserList(){
        userTable.getItems().addAll(theGym.getUsersList());
    }

    public void fillUpSessionList(){
        sessionTable.getItems().addAll(theGym.getSessionList());
    }

    public void assignSessionB(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        Alert errorAlert2 = new Alert(Alert.AlertType.ERROR);
        errorAlert.setContentText("No se ha asignado el usuario.\nVerifique que haya seleccionado a los dos.");
        currentWindow = (Stage) scenePane.getScene().getWindow();
        Alert succsessAlert = new Alert(Alert.AlertType.INFORMATION);
        succsessAlert.setContentText("El Usuario se asignó correctamente.");
        try {
            AssignMenu assignMenu = new AssignMenu();
            User user = userTable.getSelectionModel().getSelectedItem();
            Session session = sessionTable.getSelectionModel().getSelectedItem();
            if (checkSessionMaxCapacity(session)){
                assignMenu.assignSessionToUser(user, session);
                succsessAlert.show();
                currentWindow.close();
            }
            else {
                errorAlert2.setContentText("No se hay Cupo en la clase asignada.");
                errorAlert2.show();
            }
        } catch (Exception e) {
            errorAlert.show();
            throw new RuntimeException(e);
        }

    }

    public boolean checkSessionMaxCapacity(Session session){
        boolean flag;
        flag = session.getSessionUsersList().size() < session.getMaxCapacity();
        return flag;
    }


    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }
}
