package uniquindio.edu.co.model.workers;
import uniquindio.edu.co.model.Membership;
import uniquindio.edu.co.model.Worker;

public class Trainer extends Worker {
    /**
     *
     * @param name of the Trainer
     * @param lastName of the Trainer
     * @param personalId of the Trainer
     * @param phoneNumber of the Trainer
     * @param age of the Trainer
     * @param theMembership of the Trainer
     * @param password of the Trainer
     */
    public Trainer(String name, String lastName, int personalId, String phoneNumber, int age, Membership theMembership, String password) {
        super(name, lastName, personalId, phoneNumber, age, theMembership, password);
    }
}
