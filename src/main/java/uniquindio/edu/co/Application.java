package uniquindio.edu.co;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.Membership;
import uniquindio.edu.co.model.User;
import uniquindio.edu.co.model.enums.MembershipPlan;
import uniquindio.edu.co.model.enums.MembershipType;
import uniquindio.edu.co.model.staffs.Admin;
import uniquindio.edu.co.model.staffs.Receptionist;
import uniquindio.edu.co.model.staffs.Trainer;
import uniquindio.edu.co.model.users.Student;
import uniquindio.edu.co.viewController.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application extends javafx.application.Application {
    public static final Gym gym = new Gym("GymUQ", 727);
    public static final
    Runnable dailyTask = () ->  {
        gym.checkMemberships();
        System.out.println("Hallo");
        gym.dailyCheck.clear();
    };
    @Override
    public void start(Stage stage) throws IOException {
        try {
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(dailyTask, 0, 1, TimeUnit.DAYS);
            Receptionist receptionist = new Receptionist("Jacobo","Londono",1128,"3115314527",18,"Switch");
            User user = new Student("Juan","Castaño",109872,"311000000",17, "juancastañogmail.com");
            Membership membership = new Membership(80000,user, MembershipPlan.BASIC, MembershipType.MONTHLY);
            Admin admin1 = new Admin("andrew", "idfk", 727, "727", 18, "DOFAI");

            User user1 = new Student("Esteban","Gutierrez",109802,"323000000",17, "");

            Trainer trainer = new Trainer("Jay", "ninjers", 7227, "888", 26, "123");

            Membership membership1 = new Membership(40000,user1, MembershipPlan.VIP, MembershipType.ANNUALLY);
            membership1.setEndDate(LocalDate.of(2025,5,15));
            membership.setEndDate(LocalDate.of(2025,11,24));

            receptionist.assignMembership(user,membership);
            receptionist.assignMembership(user1,membership1);

            gym.getUsersList().add(user);
            gym.getUsersList().add(user1);
            gym.getStaffList().add(receptionist);
            gym.getStaffList().add(admin1);

            //Igottamakethisintothecontroller
            gym.getStaffList().add(trainer);
            gym.getTrainersList().add(trainer);



            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/uniquindio/edu/co/loginMenu.fxml"));
            //fxmlLoader.setControllerFactory(param -> new MainView(gym));
            Scene scene = new Scene(fxmlLoader.load());
            LoginView loginView = fxmlLoader.getController();
            loginView.setTheGym(gym);
            stage.setResizable(false);
            stage.setTitle("Login Screen");
            stage.setScene(scene);
            stage.show();
        }   catch (IOException e) {
            e.printStackTrace();
        }

    }

}
