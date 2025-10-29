package uniquindio.edu.co.model.workers;
import uniquindio.edu.co.model.Membership;
import uniquindio.edu.co.model.Worker;

public class Admin extends Worker {
    /**
     *
     * @param name of the Admin
     * @param lastName of the Admin
     * @param personalId of the Admin
     * @param phoneNumber of the Admin
     * @param age of the Admin
     * @param theMembership of the Admin
     * @param password of the Admin
     */
    public Admin(String name, String lastName, int personalId, String phoneNumber, int age, Membership theMembership, String password) {
        super(name, lastName, personalId, phoneNumber, age, theMembership, password);
    }
}
