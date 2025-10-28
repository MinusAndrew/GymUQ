package uniquindio.edu.co.gymuq;
import java.util.Calendar;
import uniquindio.edu.co.gymuq.model.User;
import java.util.Scanner;
public class app {
    public static final Scanner scanner = new Scanner(System.in);
    void main() {

        System.out.println("Ingrese el nombre del veterinario");
        String name = scanner.nextLine();

        System.out.println("Ingrese la apellido del veterinario");
        String lastName = scanner.nextLine();

        System.out.println("Ingrese el cedula del veterinario");
        int personalID = scanner.nextInt();

        System.out.println("Ingrese el telefono del veterinario");
        String phoneNumber = scanner.nextLine();

        System.out.println("Ingrese el age del veterinario");
        int age = scanner.nextInt();


        Calendar calendar = Calendar.getInstance();

        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int anio = scanner.nextInt();

        calendar.set(anio,mes,dia);

        Calendar date = Calendar.getInstance();
        date.set(2025,10,18);

        User user = new User(name,lastName,personalID,phoneNumber,age,null,calendar);

        System.out.println("Veterinario registrado - OK");

    }


}