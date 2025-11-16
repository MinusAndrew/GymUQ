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

        User user = new User("Juan","Castaño",109872,"311000000",17,null);
        User user1 = new User("Esteban","Gutierrez",109802,"323000000",17,null);
        Membership membership = new Membership(80000,user, MembershipPlan.BASIC, MembershipType.MONTHLY);
        Membership membership1 = new Membership(40000,user1, MembershipPlan.VIP, MembershipType.ANNUALLY);

        Trainer trainer = new Trainer("andres","camilo",1093,"322000000",18,"horriblekids");

        Session session = new Session(2,"Yoga",LocalDate.of(2025,11,17),"Relajacion yoquese",trainer);


        //membership1.setEndDate(LocalDate.of(2024,5,15));
        membership.setEndDate(LocalDate.of(2027,1,24));

        receptionist.assignMembership(user,membership);
        receptionist.assignMembership(user1,membership1);

        gym.registerUser(user);
        gym.registerUser(user1);

        gym.registerSession(session);

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

        //Estos dos metodos deben de ir juntos
        gym.dailyCheck.add(gym.searchUserByPersonalId(109802));
        System.out.println(receptionist.checkMembership(109802,gym));



        String reporte = activeUsers() + "\n" + reporteMembresias(list);



        //System.out.println(receptionist.getPassword() +"\n"+yes+"\n"+no);

        System.out.println(reporte);



    }
    public static boolean expiredMembership (Membership memb){
        LocalDate hoy = LocalDate.now();
        return memb.getEndDate().isBefore(hoy);
    }

    public static boolean toExpireMembership (Membership memb){
        LocalDate hoy = LocalDate.now();
        LocalDate toExp = LocalDate.now().plusDays(15);
        return memb.getEndDate().isBefore(toExp) && memb.getEndDate().isAfter(hoy);
    }

    public static String reporteMembresias(List<Membership> list){
        LocalDate hoy = LocalDate.now();

        StringBuilder reporteExpirados = new StringBuilder();
        StringBuilder reportePorExpirar = new StringBuilder();

        for(Membership memb : list){
            User usuario = memb.getTheUser();
            String nombreUsario = usuario.getName();
            int idUsuario = usuario.getPersonalId();
            LocalDate fechaFinal = memb.getEndDate();
            if (toExpireMembership(memb)){
                long caducaEn = ChronoUnit.DAYS.between(hoy,fechaFinal);
                reportePorExpirar.append("La membresia del usuario: ").append(nombreUsario).append(" con documento ").append(idUsuario).append(" caduca en ").append(caducaEn).append(" dias\n");
            }
            if (expiredMembership(memb)) {
                long caducoHace = ChronoUnit.DAYS.between(fechaFinal,hoy);
                reporteExpirados.append("La membresia del usuario: ").append(nombreUsario).append(" con documento ").append(idUsuario).append(" caduco hace ").append(caducoHace).append(" dias\n");
            }
        }
        return "Membresias por caducar: \n" + reportePorExpirar + "Membresias caducadas: \n" + reporteExpirados;
    }

    public static String activeUsers(){
        StringBuilder s = new StringBuilder();
        for(User u : gym.dailyCheck){
            s.append(u.getName()).append(" ").append(u.getLastName()).append("   ").append(u.getPersonalId()).append("\n");
        }
        return s.toString();
    }





    /*
     * LocalDate day1 = LocalDate.of(2025,10,18);
     *         LocalDate day2 = LocalDate.of(2025,11,5);
     *         LocalDate day3 = LocalDate.of(2025,5,5);
     *         LocalDate day4 = LocalDate.of(2025,12,11);
     *         LocalDate day5 = LocalDate.of(2025,6,30);
     *         LocalDate day6 = LocalDate.of(2025,5,8);
     *         LocalDate day7 = LocalDate.of(2025,7,23);
     *
     *         LocalDate hoy = LocalDate.now();
     *
     *         List<LocalDate> listDates = new ArrayList<>();
     *
     *         listDates.add(day1);
     *         listDates.add(day2);
     *         listDates.add(day3);
     *         listDates.add(day4);
     *         listDates.add(day5);
     *         listDates.add(day6);
     *         listDates.add(day7);
     *
     *         //List<LocalDate> idk = getDateIDK(listDates, hoy);
     *
     *         //System.out.println(idk);
     */


    /*try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();

            Cipher desCipher = Cipher.getInstance("DES");

            byte[] password = "RSwitch".getBytes(StandardCharsets.UTF_8);

            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            byte[] textEncrypted = desCipher.doFinal(password);

            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        */
}
