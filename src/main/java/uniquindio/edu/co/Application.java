package uniquindio.edu.co;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uniquindio.edu.co.model.*;
import uniquindio.edu.co.model.enums.*;
import uniquindio.edu.co.model.staffs.*;
import uniquindio.edu.co.model.users.*;
import uniquindio.edu.co.viewController.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
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
            //Staff

            Admin admin1 = new Admin("andrew", "idfk", 727, "727", 18, "DOFAI");
            Receptionist receptionist = new Receptionist("Jacobo","Londono",1128,"3115314527",18,"Switch");
            Trainer trainer = new Trainer("Jay", "ninjers", 7227, "888", 26, "123");
            gym.registerStaff(receptionist);
            gym.registerStaff(admin1);
            gym.registerTrainer(trainer);
            gym.registerStaff(trainer);

            //Users

            Student user = new Student("Juan","Castaño",112342,"311000000",17, "juancastaño@gmail.com");
            Student user1 = new Student("Esteban","Gutierrez",109802,"323000000",18, "estebangutierrez@gmail.com");
            Individual individual = new Individual("Jose","Perez",109872,"314000000",20, "joseperez@gmail.com");
            Worker worker = new Worker("Erik","Martinez",18492511,"321000000",19, "erikmartinez@gmail.com");
            gym.registerUser(user);
            gym.registerUser(user1);
            gym.registerUser(individual);
            gym.registerUser(worker);



            //Memberships

            Membership membership = new Membership(20000, user, MembershipPlan.BASIC, MembershipType.MONTHLY);
            Membership membership1 = new Membership(100000, user1, MembershipPlan.VIP, MembershipType.ANNUALLY);
            Membership membershipInd = new Membership(70000, individual, MembershipPlan.PREMIUM, MembershipType.QUARTERLY);
            Membership membershipWork = new Membership(100000, worker, MembershipPlan.PREMIUM, MembershipType.MONTHLY);
            gym.registerMembership(membership);
            gym.registerMembership(membership1);
            gym.registerMembership(membershipInd);
            gym.registerMembership(membershipWork);
            receptionist.assignMembership(user,membership);
            receptionist.assignMembership(user1,membership1);
            receptionist.assignMembership(individual,membershipInd);
            receptionist.assignMembership(worker,membershipWork);

            /*
            Worker profesor = new Worker("Raul","Rivera", ,"", , "");
            gym.registerUser(profesor);
            Membership membershipTest = new Membership(50000, null, MembershipPlan.PREMIUM, MembershipType.MONTHLY);
            gym.registerMembership(membershipTest);
            receptionist.assignMembership(profesor,membershipTest);
            membershipTest.setEndDate(LocalDate.of(2025,5,15));
            */

            //Sessions

            Session session = new Session(2,"Yoga",LocalDate.of(2025,11,20),"Yoga Quincenal",trainer, LocalTime.of(15,0));
            gym.registerSession(session);

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
