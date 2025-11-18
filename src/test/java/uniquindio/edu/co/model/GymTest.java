package uniquindio.edu.co.model;

import org.junit.jupiter.api.Test;
import uniquindio.edu.co.model.staffs.Receptionist;
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
    void verifylogin() {
        Gym gym = new Gym("Uq",123);
        Receptionist receptionist = new Receptionist("Jacobo","Londono",1128,"3115314527",18,"Switch");
        gym.registerStaff(receptionist);
        String username = "Jacobo";
        String passwd = "RSwitch";
        assertTrue(gym.login(username, passwd));
    }

    @Test
    void getReceptionistFromName() {
        Gym gym = new Gym("Uq",123);
        Receptionist receptionist = new Receptionist("Jacobo","Londono",1128,"3115314527",18,"Switch");
        String name = "Jacobo";
        gym.registerStaff(receptionist);
        assertEquals(receptionist, gym.getReceptionistFromName(name));

    }

    @Test
    void searchUserByPersonalId() {
        Gym gym = new Gym("Uq",123);
        User user = new Student("Juan", "Castaño",109872,"311000000",18,"juan@gmail.com");
        gym.registerUser(user);
        int personalId = 109872;
        assertEquals(user, gym.searchUserByPersonalId(personalId));

    }

    @Test
    void verifyUserIsOnList() {
        Gym gym = new Gym("Uq",123);
        User user = new Student("Juan", "Castaño",109872,"311000000",18,"juan@gmail.com");
        gym.registerUser(user);
        assertTrue(gym.verifyUserPersonalId(user));
    }
}