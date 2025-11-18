package uniquindio.edu.co.model;

import org.junit.jupiter.api.Test;
import uniquindio.edu.co.model.users.Student;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void verifyName() {
        User user = new Student("Juan","Castaño",109872,"311000000",1,"juan@gmail.com");
        String name = "Juan";
        assertEquals(name, user.getName());
    }
}