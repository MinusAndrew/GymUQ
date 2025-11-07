package uniquindio.edu.co.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
        Session session = new Session (2,"Yoga", LocalDate.of(2025,10,18),"Yoganda");
    }
}