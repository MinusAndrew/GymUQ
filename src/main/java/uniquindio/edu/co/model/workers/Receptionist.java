package uniquindio.edu.co.model.workers;
import uniquindio.edu.co.model.Membership;
import uniquindio.edu.co.model.User;
import uniquindio.edu.co.model.Worker;

public class Receptionist extends Worker {
    /**
     *
     * @param name of the Receptionist
     * @param lastName of the Receptionist
     * @param personalId of the Receptionist
     * @param phoneNumber of the Receptionist
     * @param age of the Receptionist
     * @param theMembership of the Receptionist
     * @param password of the Receptionist
     */
    public Receptionist(String name, String lastName, int personalId, String phoneNumber, int age, Membership theMembership, String password) {
        super(name, lastName, personalId, phoneNumber, age, theMembership, password);
    }
    public void registrerUser(User user){

    }
}
