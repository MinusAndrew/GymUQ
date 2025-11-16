package uniquindio.edu.co.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import uniquindio.edu.co.model.enums.MembershipPlan;
import uniquindio.edu.co.model.users.Student;

import java.time.LocalDate;

class AppTest {

    @Test
    public void verificarEdadNegativa() {
        assertThrows(Throwable.class, ()-> new Student("Juan","Castaño",109872,"311000000",-1));
    }

    @Test
    public void verifificarUsuarioExistenteId() {
        Gym gym = new Gym("Uq",123);
        User user = new User("Juan", "Castaño",109872,"311000000",18);
        User user1 = new User("Esteban","Gutierrez",109872,"323000000",17);
        gym.registerUser(user);
        assertThrows(Throwable.class, ()->gym.registerUser(user1));

    }

    @Test
    public void verificarSiLaSesionEstaLlena(){
        Session session = new Session (2,"Yoga", LocalDate.of(2025,10,18),"Yoganda",null);
        User user = new User("Juan", "Castaño",109872,"311000000",18);
        User user1 = new User("Esteban","Gutierrez",109802,"323000000",17);
        User user2 = new User("jaco","davila",1128,"324",18);
        session.addUserToSession(user);
        session.addUserToSession(user1);
        assertThrows(Throwable.class, ()->session.addUserToSession(user2));

    }

    @Test
    public void verificarTipoMembresia() {
        User user = new User("Juan","Castaño",109872,"311000000",18);
        Membership membership = new Membership(80000, user, MembershipPlan.BASIC, null);
        assertNotNull(membership.getType());
    }
}