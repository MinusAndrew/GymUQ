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
         reportArea.setText("Hi teacher there's no report 4 ya but we have a snack.");
    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }
}

