package uniquindio.edu.co.model.staffs;
import uniquindio.edu.co.model.*;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends Staff {

    //Relationships
    private List<Session> sessionTrainerList;

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
        this.sessionTrainerList = new ArrayList<>();
    }


    /**
     * Returns the list of sessions the Trainer is registered at.
     * @return list of sessions.
     */
    public List<Session> getSessionTrainerList() {
        return sessionTrainerList;
    }

    public void addSessionToTrainer(Session session){
        sessionTrainerList.add(session);

    }

}
