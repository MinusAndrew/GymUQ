package uniquindio.edu.co.model;

import org.junit.jupiter.api.Test;
import uniquindio.edu.co.model.enums.MembershipPlan;
import uniquindio.edu.co.model.users.Student;

import static org.junit.jupiter.api.Assertions.*;

class MembershipTest {

    @Test
    void verifyMembershipType() {
        //Membership Class
        User user = new Student("Juan","Castaño",109872,"311000000",18,"juan@gmail.com");
        //Membership membership = new Membership(80000, user, MembershipPlan.BASIC, null);
        assertThrows(Throwable.class, ()-> new Membership(80000, user, MembershipPlan.BASIC, null));
    }

}