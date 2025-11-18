package uniquindio.edu.co.model.users;

import uniquindio.edu.co.model.Membership;
import uniquindio.edu.co.model.Session;
import uniquindio.edu.co.model.User;

public class Student extends User {
    /**
     * Student class Constructor
     *
     * @param name           of the Student
     * @param lastName       of the Student
     * @param personalId     of the Student
     * @param phoneNumber    of the Student
     * @param age            of the Student
     * @param theMembership  of the Student
     * @param theUserSession of the Student
     */
    public Student(String name, String lastName, int personalId, String phoneNumber, int age, String email, Membership theMembership, Session theUserSession) {
        super(name, lastName, personalId, phoneNumber, age, email, theMembership, theUserSession);
    }

    public Student(String name, String lastName, int personalId, String phoneNumber, int age, String email) {
        super(name, lastName, personalId, phoneNumber, age, email);
        assert email.contains("@");
    }


}
