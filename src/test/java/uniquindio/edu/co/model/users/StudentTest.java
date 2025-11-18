package uniquindio.edu.co.model.users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {



    @Test
    void verifyEmail() {
        //Student Class
        assertThrows(Throwable.class, ()-> new Student("Juan","Castaño",109872,"311000000",18,"juangmail.com"));
    }

    @Test
    void verifyNegativeAge() {
        //Student Class
        assertThrows(Throwable.class, ()-> new Student("Juan","Castaño",109872,"311000000",-1,"juan@gmail.com"));
    }

}