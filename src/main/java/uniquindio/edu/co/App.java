package uniquindio.edu.co;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import uniquindio.edu.co.model.*;
import uniquindio.edu.co.model.enums.MembershipPlan;
import uniquindio.edu.co.model.enums.MembershipType;
import uniquindio.edu.co.model.workers.Receptionist;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class App {
    public static void main(String[] args) {
        LocalDate day1 = LocalDate.of(2025,10,18);
        LocalDate day2 = LocalDate.of(2025,11,5);
        LocalDate day3 = LocalDate.of(2025,5,5);
        LocalDate day4 = LocalDate.of(2025,12,11);
        LocalDate day5 = LocalDate.of(2025,6,30);
        LocalDate day6 = LocalDate.of(2025,5,8);
        LocalDate day7 = LocalDate.of(2025,7,23);

        LocalDate hoy = LocalDate.now();

        List<LocalDate> listDates = new ArrayList<>();

        listDates.add(day1);
        listDates.add(day2);
        listDates.add(day3);
        listDates.add(day4);
        listDates.add(day5);
        listDates.add(day6);
        listDates.add(day7);

        //List<LocalDate> idk = getDateIDK(listDates, hoy);

        //System.out.println(idk);

        Receptionist receptionist = new Receptionist("jaco","londono",1128,"311",18,"Switch");
        User user = new User("Juan","Castaño",109872,"311000000",17);
        Membership membership = new Membership(80000,user, MembershipPlan.BASIC, MembershipType.MONTHLY);

        receptionist.assignMembership(user,membership);

        membership.setStartDate(membership.getStartDate().plusMonths(12));

        System.out.println(membership);

    }
    public static List<LocalDate> getDateIDK (List<LocalDate> listDates, LocalDate hoy){
        List<LocalDate>  idk = new ArrayList<>();
        for(LocalDate d : listDates){
            if(d.isAfter(hoy)){
                idk.add(d);
            }
        }
        return idk;
    }

}
