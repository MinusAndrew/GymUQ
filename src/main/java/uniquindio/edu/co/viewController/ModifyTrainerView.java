package uniquindio.edu.co.viewController;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import uniquindio.edu.co.Controller.AssignMenu;
import uniquindio.edu.co.Controller.ModifyTrainerMenu;
import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.User;
import uniquindio.edu.co.model.enums.MembershipPlan;
import uniquindio.edu.co.model.enums.MembershipType;
import uniquindio.edu.co.model.staffs.Trainer;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ModifyTrainerView implements Initializable {

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
    private TextField nameLabel;
    @FXML
    private TextField lastNameLabel;
    @FXML
    private TextField ageLabel;
    @FXML
    private TextField personalIdLabel;
    @FXML
    private TextField phoneNumLabel;


    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }


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

    
    public void getDataOnMouseClick(){
        Trainer trainer = trainerTable.getSelectionModel().getSelectedItem();
        nameLabel.setText(trainer.getName());
        lastNameLabel.setText(trainer.getLastName());
        ageLabel.setText(Integer.toString(trainer.getAge()));
        personalIdLabel.setText(Integer.toString(trainer.getPersonalId()));
        phoneNumLabel.setText(trainer.getPhoneNumber());


    }

   // permizokenoez variablesindeklarar.funzionknoexicste(datokenoez);

    public void modifyTrainerDataB(){
        ModifyTrainerMenu modifyTrainerMenu = new ModifyTrainerMenu();
        modifyTrainerMenu.setTheGym(theGym);

        Trainer trainer = trainerTable.getSelectionModel().getSelectedItem();

        int trainerAge = Integer.parseInt(ageLabel.getText());
        int trainerPersonalId = Integer.parseInt(personalIdLabel.getText());
        String trainerName = nameLabel.getText();
        String trainerLastName = lastNameLabel.getText();
        String trainerPhoneNumber = phoneNumLabel.getText();

        modifyTrainerMenu.setTrainerAge(trainerAge, trainer);
        modifyTrainerMenu.setTrainerPersonalId(trainerPersonalId, trainer);
        modifyTrainerMenu.setTrainerName(trainerName, trainer);
        modifyTrainerMenu.setTrainerLastName(trainerLastName, trainer);
        modifyTrainerMenu.setTrainerPhoneNumber(trainerPhoneNumber, trainer);

        trainerTable.refresh();
    }

    public void deleteTrainerB(){
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        ModifyTrainerMenu modifyTrainerMenu = new ModifyTrainerMenu();
        modifyTrainerMenu.setTheGym(theGym);
        Trainer trainer = trainerTable.getSelectionModel().getSelectedItem();
        confirmAlert.setContentText("Seguro que quiere eliminar el Entrenador?");
        Optional<ButtonType> result = confirmAlert.showAndWait();
        if(result.get() == ButtonType.OK){
        modifyTrainerMenu.removeTrainerFromGym(trainer);
        trainerTable.getItems().remove(trainer);
        }
        else {
            trainerTable.refresh();
        }
    }



}
