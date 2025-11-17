package uniquindio.edu.co.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import uniquindio.edu.co.model.Gym;

public class AdminReportView {
    private Gym theGym;

    @FXML
    private TextArea reportArea;

    public void setContent(){
        /*
        Call the report fun from the gym here
        JavaFX does everything automatically
         */

        // String report = fun();
         reportArea.setText("test but replace with the report variable");
    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }
}

