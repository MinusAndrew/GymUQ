package uniquindio.edu.co.viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

public class AssignMembershipView implements Initializable {

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

        userFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        userLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        userPersonalIdColumn.setCellValueFactory(new PropertyValueFactory<>("personalId"));
        userPhoneNumColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        userAgeColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        userEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        userMembershipColumn.setCellValueFactory(new PropertyValueFactory<>("theMembership"));

    }

    public void fillUpList(){
        userTable.getItems().addAll(theGym.getUsersList());
    }

    public void assignMembershipB(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setContentText("No se ha asignado, \nverifique que haya seleccionado todos los datos.");
        try {
            AssignMenu assignMenu = new AssignMenu();
            assignMenu.setTheGym(theGym);
            User user = userTable.getSelectionModel().getSelectedItem();

            MembershipPlan planOption = MembershipPlan.valueOf(membershipPlanBox.getValue());
            MembershipType typeOption = MembershipType.valueOf(membershipBox.getValue());

            assignMenu.assignMembershipToUser(user.getPersonalId(), planOption, typeOption);
            userTable.refresh();
        } catch (Exception e) {
            errorAlert.show();
            throw new RuntimeException(e);
        }
    }

}
