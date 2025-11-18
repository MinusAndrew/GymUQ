package uniquindio.edu.co.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import uniquindio.edu.co.model.enums.MembershipPlan;
import uniquindio.edu.co.model.users.Student;

import java.time.LocalDate;
import java.time.LocalTime;

class AppTest {

    @Test
    void verificarEdadNegativa() {
        assertThrows(Throwable.class, ()-> new Student("Juan","Castaño",109872,"311000000",-1,"juan@gmail.com"));
    }

    @Test
    void verifificarUsuarioExistenteId() {
        Gym gym = new Gym("Uq",123);
        User user = new Student("Juan", "Castaño",109872,"311000000",18,"juan@gmail.com");
        User user1 = new Student("Esteban","Gutierrez",109872,"323000000",17,"esteban@gmail.com");
        gym.registerUser(user);
        assertThrows(Throwable.class, ()->gym.registerUser(user1));

    }

    @Test
    void verificarSiLaSesionEstaLlena(){
        Session session = new Session (2,"Yoga", LocalDate.of(2025,10,18),"Yoganda",null, LocalTime.of(15,0));
        User user = new Student("Juan", "Castaño",109872,"311000000",18,"juan@gmail.com");
        User user1 = new Student("Esteban","Gutierrez",109802,"323000000",17,"esteban@gmail.com");
        User user2 = new Student("jaco","davila",1128,"324",18,"");
        session.addUserToSession(user);
        session.addUserToSession(user1);
        assertThrows(Throwable.class, ()->session.addUserToSession(user2));

    }

    @Test
    void verificarTipoMembresia() {
        User user = new Student("Juan","Castaño",109872,"311000000",18,"juan@gmail.com");
        Membership membership = new Membership(80000, user, MembershipPlan.BASIC, null);
        assertNotNull(membership.getType());
    }

    @Test
    void verificarCorreo() {
        assertThrows(Throwable.class, ()-> new Student("Juan","Castaño",109872,"311000000",18,"juangmail.com"));
    }
}