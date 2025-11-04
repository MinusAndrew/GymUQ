package uniquindio.edu.co.model;

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
    public Student(String name, String lastName, int personalId, String phoneNumber, int age, Membership theMembership, Session theUserSession) {
        super(name, lastName, personalId, phoneNumber, age, theMembership, theUserSession);
    }

    public Student(String name, String lastName, int personalId, String phoneNumber, int age) {
        super(name, lastName, personalId, phoneNumber, age);
    }


}
