package uniquindio.edu.co.viewController;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.enums.MembershipPlan;
import uniquindio.edu.co.model.enums.MembershipType;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AssignView implements Initializable {

    private Gym theGym;

    @FXML
    private ChoiceBox<String> membershipBox;

    @FXML
    private ChoiceBox<String> membershipPlanBox;

    private final MembershipType[] membershipTypes = MembershipType.values();
    private final MembershipPlan[] membershipPlans = MembershipPlan.values();

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }


    public String[] getAllMembershipTypes(){
        String[] membershipNames = new String[membershipTypes.length];
        for (int i = 0; i <= membershipNames.length - 1; i++){
            String name = membershipTypes[i].name();
            membershipNames[i] = name;
        }
        return membershipNames;
    }

    public String[] getAllMembershipPlans(){
        String[] membershipPlanTypes = new String[membershipPlans.length];
        for (int i = 0; i <= membershipPlanTypes.length - 1; i++){
            String name = membershipPlans[i].name();
            membershipPlanTypes[i] = name;
        }
        return membershipPlanTypes;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        membershipBox.getItems().addAll(getAllMembershipTypes());
        membershipPlanBox.getItems().addAll(getAllMembershipPlans());
    }




}
