package uniquindio.edu.co.model;

import org.junit.jupiter.api.Test;
import uniquindio.edu.co.model.users.Student;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {

    @Test
    void verifyFullSession(){
        //SessionClass
        Session session = new Session (2,"Yoga", LocalDate.of(2025,10,18),"Yoganda",null, LocalTime.of(15,0));
        User user = new Student("Juan", "Castaño",109872,"311000000",18,"xxx@gmail.com");
        User user1 = new Student("Esteban","Gutierrez",109802,"323000000",17,"xxx@gmail.com");
        User user2 = new Student("jaco","davila",1128,"324",18,"@");
        session.addUserToSession(user);
        session.addUserToSession(user1);
        assertThrows(Throwable.class, ()->session.addUserToSession(user2));
    }



}