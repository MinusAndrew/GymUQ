package uniquindio.edu.co.model.staffs;
import uniquindio.edu.co.model.*;

public class Trainer extends Staff {

    //Relationships
    //private Session theTrainerSession;
    // not need it

    /**
     * Trainer class Constructor
     *
     * @param name           of the Trainer
     * @param lastName       of the Trainer
     * @param personalId     of the Trainer
     * @param phoneNumber    of the Trainer
     * @param age            of the Trainer
     * @param password       of the Trainer
     */
    public Trainer(String name, String lastName, int personalId, String phoneNumber, int age, String password) {
        super(name, lastName, personalId, phoneNumber, age, "T"+password);
    }


    /*
     * Get Trainer Session
     * @return Trainer Session

    public Session getTheTrainerSession() {
        return theTrainerSession;
    }

    /**
     * Set Trainer Session
     * @param theTrainerSession of the Trainer

    public void setTheTrainerSession(Session theTrainerSession) {
        this.theTrainerSession = theTrainerSession;
    }

    */



}
