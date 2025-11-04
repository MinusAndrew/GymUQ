package uniquindio.edu.co.model;

public class Worker extends User {

    //Attributes
    private String password;

    /**
     * Worker class Constructor
     *
     * @param name           of the Worker
     * @param lastName       of the Worker
     * @param personalId     of the Worker
     * @param phoneNumber    of the Worker
     * @param age            of the Worker
     * @param theMembership  of the Worker
     * @param theUserSession of the Worker
     * @param password       of the Worker
     */
    public Worker(String name, String lastName, int personalId, String phoneNumber, int age, Membership theMembership, Session theUserSession, String password) {
        super(name, lastName, personalId, phoneNumber, age, theMembership, theUserSession);
        this.password = password;
    }

    public Worker(String name, String lastName, int personalId, String phoneNumber, int age) {
        super(name, lastName, personalId, phoneNumber, age);
    }

    /**
     * VERY SAFE AND ABSOLUTELY SECURE METHOD
     * @return returns the worker's password LMAO.
     */
    public String getPassword() {
        return password;
    }


    /**
     * Safer than the last one is for sure
     * @param password the password given by the Worker.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
