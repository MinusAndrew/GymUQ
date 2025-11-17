package uniquindio.edu.co.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.staffs.Receptionist;

public class CheckMembershipView {
    private Gym theGym;
    private Receptionist theReceptionist;

    @FXML
    private TextField personalIdField;

    @FXML
    private AnchorPane checkPane;

    Stage currentWindow;

    public void checkMembershipB(){
        currentWindow = (Stage) checkPane.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        int id = grabPersonalId();
        String msg = theReceptionist.checkMembership(id, theGym);
        alert.setContentText(msg);
        alert.show();

        currentWindow.close();
    }


    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }

    public void setTheReceptionist(Receptionist theReceptionist) {
        this.theReceptionist = theReceptionist;
    }

    public int grabPersonalId(){
        return Integer.parseInt(personalIdField.getText());
    }
}
