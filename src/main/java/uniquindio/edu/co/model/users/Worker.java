package uniquindio.edu.co.model.users;

import uniquindio.edu.co.model.Membership;
import uniquindio.edu.co.model.Session;
import uniquindio.edu.co.model.User;

public class Worker extends User {

    public Worker(String name, String lastName, int personalId, String phoneNumber, int age, String email, Membership theMembership, Session theUserSession) {
        super(name, lastName, personalId, phoneNumber, age, email, theMembership, theUserSession);
    }

    public Worker(String name, String lastName, int personalId, String phoneNumber, int age, String email) {
        super(name, lastName, personalId, phoneNumber, age, email);
    }
}
