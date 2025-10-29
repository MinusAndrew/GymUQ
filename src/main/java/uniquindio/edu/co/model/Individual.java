package uniquindio.edu.co.model;

public class Individual extends User {
    /**
     * User class Constructor
     *
     * @param name          of the user
     * @param lastName      of the user
     * @param personalId    of the user
     * @param phoneNumber   of the user
     * @param age           of the user
     * @param theMembership of the user
     */
    public Individual(String name, String lastName, int personalId, String phoneNumber, int age, Membership theMembership) {
        super(name, lastName, personalId, phoneNumber, age, theMembership);
    }
}
