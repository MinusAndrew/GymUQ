package uniquindio.edu.co.model;

import org.junit.jupiter.api.Test;
import uniquindio.edu.co.model.users.Student;

import static org.junit.jupiter.api.Assertions.*;

class GymTest {

    @Test
    void verifiyExistentUser() {
        //Gym Class
        Gym gym = new Gym("Uq",123);
        User user = new Student("Juan", "Castaño",109872,"311000000",18,"juan@gmail.com");
        User user1 = new Student("Esteban","Gutierrez",109872,"323000000",17,"esteban@gmail.com");
        gym.registerUser(user);
        assertThrows(Throwable.class, ()->gym.registerUser(user1));

    }

    @Test
    void login() {


    }
}