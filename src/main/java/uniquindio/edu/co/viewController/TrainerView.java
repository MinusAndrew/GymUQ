package uniquindio.edu.co.viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.Session;
import uniquindio.edu.co.model.staffs.Trainer;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class TrainerView implements Initializable {
    private Gym theGym;
    private Trainer theTrainer;

    @FXML
    private TableView<Session> sessionTable;
    @FXML
    private TableColumn<Session, String> nameColumn;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        capacityColumn.setCellValueFactory(new PropertyValueFactory<>("maxCapacity"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("schedule"));
        hourColumn.setCellValueFactory(new PropertyValueFactory<>("hour"));
        trainerColumn.setCellValueFactory(new PropertyValueFactory<>("theTrainer"));

    }

    public void fillUpSessionList(){
        sessionTable.getItems().addAll(theTrainer.getSessionTrainerList());
    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }

    public void setTheTrainer(Trainer theTrainer) {
        this.theTrainer = theTrainer;
    }
}
