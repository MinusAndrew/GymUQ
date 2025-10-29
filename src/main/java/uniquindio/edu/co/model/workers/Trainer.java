package uniquindio.edu.co.model.workers;
import uniquindio.edu.co.model.*;

public class Trainer extends Worker {

    //Relationships
    private Session theTrainerSession;

    /**
     * Trainer class Constructor
     *
     * @param name           of the Trainer
     * @param lastName       of the Trainer
     * @param personalId     of the Trainer
     * @param phoneNumber    of the Trainer
     * @param age            of the Trainer
     * @param theMembership  of the Trainer
     * @param theUserSession of the Trainer
     * @param password       of the Trainer
     */
    public Trainer(String name, String lastName, int personalId, String phoneNumber, int age, Membership theMembership, Session theUserSession, String password, Session theTrainerSession) {
        super(name, lastName, personalId, phoneNumber, age, theMembership, theUserSession, password);
        this.theTrainerSession = theTrainerSession;
    }


    /**
     * Get Trainer Session
     * @return Trainer Session
     */
    public Session getTheTrainerSession() {
        return theTrainerSession;
    }

    /**
     * Set Trainer Session
     * @param theTrainerSession of the Trainer
     */
    public void setTheTrainerSession(Session theTrainerSession) {
        this.theTrainerSession = theTrainerSession;
    }
}
