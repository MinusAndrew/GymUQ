package uniquindio.edu.co;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        List<LocalDate> idk = getDateIDK(listDates, hoy);

        System.out.println(idk);

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
