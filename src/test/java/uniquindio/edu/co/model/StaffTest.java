package uniquindio.edu.co.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {
    @Test
    void verifyPasswdEncryption(){
        //StaffClass
        Staff trainer = new Staff("Jay", "ninjers", 7227, "888", 26, "hiiuwu");
        assertTrue(trainer.comparePasswords("hiiuwu"));
    }
}