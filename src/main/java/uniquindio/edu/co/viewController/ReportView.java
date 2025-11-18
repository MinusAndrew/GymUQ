package uniquindio.edu.co.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.staffs.Receptionist;

public class ReportView {
    private Gym theGym;
    private Receptionist theReceptionist;

    @FXML
    private TextArea reportArea;

    public void setContent(){
        String report = theReceptionist.report(theGym);
        reportArea.setText(report);
    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }

    public void setTheReceptionist(Receptionist theReceptionist) {
        this.theReceptionist = theReceptionist;
    }
}

