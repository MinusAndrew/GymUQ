package uniquindio.edu.co;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import uniquindio.edu.co.model.*;
import uniquindio.edu.co.model.enums.*;
import uniquindio.edu.co.model.staffs.*;

public class App {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


        Gym gym = new Gym("Uq",122);

        Receptionist receptionist = new Receptionist("jaco","londono",1128,"311",18,"Switch");
        User user = new User("Juan","Castaño",109872,"311000000",17);
        Membership membership = new Membership(80000,user, MembershipPlan.BASIC, MembershipType.MONTHLY);

        User user1 = new User("Esteban","Gutierrez",109802,"323000000",17);

        Membership membership1 = new Membership(40000,user1, MembershipPlan.VIP, MembershipType.ANNUALLY);
        membership1.setEndDate(LocalDate.of(2024,5,15));
        membership.setEndDate(LocalDate.of(2027,1,24));

        receptionist.assignMembership(user,membership);
        receptionist.assignMembership(user1,membership1);

        gym.registerUser(user);
        gym.registerUser(user1);

        //membership.setStartDate(membership.getStartDate().plusMonths(12));

        //System.out.println(receptionist);
        gym.registerStaff(receptionist);
        boolean yes = gym.login("jaco","RSwitch");
        boolean no = gym.login("jaco","Switch");


        List<Membership> list = new ArrayList<>();
        list.add(membership);
        list.add(membership1);


        Runnable dailyTask = () ->  {
            gym.checkMemberships();
            System.out.println("Hallo");
        };


        //scheduler.scheduleAtFixedRate(dailyTask, 0, 1, TimeUnit.DAYS);
        gym.checkMemberships();
        System.out.println(receptionist.checkMembership(109802,gym));


        //System.out.println(reporteMembresias(list));

        //System.out.println(receptionist.getPassword() +"\n"+yes+"\n"+no);

        //System.out.println(membership);



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
        return "Membresias por caducar: \n" + reportePorExpirar + "Membresias caducadas: \n" + reporteExpirados.toString();
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
