package uniquindio.edu.co.viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import uniquindio.edu.co.Controller.AssignMenu;
import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.User;
import uniquindio.edu.co.model.enums.MembershipPlan;
import uniquindio.edu.co.model.enums.MembershipType;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyTrainerView implements Initializable {

    private Gym theGym;

    @FXML
    private ChoiceBox<String> membershipBox;

    @FXML
    private ChoiceBox<String> membershipPlanBox;

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
    private TableColumn<User, String> userMembershipColumn;


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

        userFirstNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        userLastNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));
        userPersonalIdColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("personalId"));
        userPhoneNumColumn.setCellValueFactory(new PropertyValueFactory<User, String>("phoneNumber"));
        userAgeColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("age"));
        userEmailColumn.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        userMembershipColumn.setCellValueFactory(new PropertyValueFactory<User, String>("theMembership"));


        /*
        userTable.getColumns().add(userFirstNameColumn);
        userTable.getColumns().add(userLastNameColumn);
        userTable.getColumns().add(userPersonalIdColumn);
        userTable.getColumns().add(userPhoneNumColumn);
        userTable.getColumns().add(userAgeColumn);
        userTable.getColumns().add(userEmailColumn);
        userTable.getColumns().add(userMembershipColumn);
         */

       //

    }

    public void fillUpList(){
        userTable.getItems().addAll(theGym.getUsersList());
    }

    public void assignMembershipB(){
        AssignMenu assignMenu = new AssignMenu();
        assignMenu.setTheGym(theGym);
        User user = userTable.getSelectionModel().getSelectedItem();

        MembershipPlan planOption = MembershipPlan.valueOf(membershipPlanBox.getValue());
        MembershipType typeOption = MembershipType.valueOf(membershipBox.getValue());

        assignMenu.assignMembershipToUser(user.getPersonalId(), planOption, typeOption);
        userTable.refresh();
    }

}
