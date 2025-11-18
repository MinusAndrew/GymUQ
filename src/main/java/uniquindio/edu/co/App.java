package uniquindio.edu.co;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import uniquindio.edu.co.model.*;
import uniquindio.edu.co.model.enums.*;
import uniquindio.edu.co.model.staffs.*;
import uniquindio.edu.co.model.users.Student;

public class App {
    public static final Gym gym = new Gym("Uq",122);
    public static final
    Runnable dailyTask = () ->  {
        gym.checkMemberships();
        System.out.println("Hallo");
        gym.dailyCheck.clear();
    };


    void main() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


        Receptionist receptionist = new Receptionist("jaco","londono",1128,"311",18,"Switch");

        User user = new Student("Juan","Castaño",109872,"311000000",17,null);
        User user1 = new Student("Esteban","Gutierrez",109802,"323000000",17,null);
        Membership membership = new Membership(80000,user, MembershipPlan.BASIC, MembershipType.MONTHLY);
        Membership membership1 = new Membership(40000,user1, MembershipPlan.VIP, MembershipType.ANNUALLY);

        Trainer trainer = new Trainer("andres","camilo",1093,"322000000",18,"horriblekids");

        //Session session = new Session(2,"Yoga",LocalDate.of(2025,11,17),"Relajacion yoquese",trainer);


        //membership1.setEndDate(LocalDate.of(2024,5,15));
        membership.setEndDate(LocalDate.of(2027,1,24));

        receptionist.assignMembership(user,membership);
        receptionist.assignMembership(user1,membership1);

        gym.registerUser(user);
        gym.registerUser(user1);

       // gym.registerSession(session);

        //membership.setStartDate(membership.getStartDate().plusMonths(12));

        //System.out.println(receptionist);
        gym.registerStaff(receptionist);
        boolean yes = gym.login("jaco","RSwitch");
        boolean no = gym.login("jaco","Switch");


        List<Membership> list = new ArrayList<>();
        list.add(membership);
        list.add(membership1);


        scheduler.scheduleAtFixedRate(dailyTask, 0, 1, TimeUnit.DAYS);
        gym.checkMemberships();

        System.out.println(receptionist.checkMembership(109802,gym));

        //System.out.println(receptionist.getPassword() +"\n"+yes+"\n"+no);

        //System.out.println(reporte);



    }
}
