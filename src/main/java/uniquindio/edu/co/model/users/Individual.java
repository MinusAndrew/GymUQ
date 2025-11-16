package uniquindio.edu.co.model.users;

import uniquindio.edu.co.model.Membership;
import uniquindio.edu.co.model.Session;
import uniquindio.edu.co.model.User;

public class Individual extends User {
    /**
     * User class Constructor
     *
     * @param name           of the user
     * @param lastName       of the user
     * @param personalId     of the user
     * @param phoneNumber    of the user
     * @param age            of the user
     * @param theMembership  of the user
     * @param theUserSession of the user
     */

    public Individual(String name, String lastName, int personalId, String phoneNumber, int age, String email, Membership theMembership, Session theUserSession) {
        super(name, lastName, personalId, phoneNumber, age, email, theMembership, theUserSession);
    }

    public Individual(String name, String lastName, int personalId, String phoneNumber, int age) {
        super(name, lastName, personalId, phoneNumber, age);
    }

}
