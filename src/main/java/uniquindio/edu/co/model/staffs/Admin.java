package uniquindio.edu.co.model.staffs;
import uniquindio.edu.co.model.*;

public class Admin extends Staff {

    /**
     * Admin class Constructor
     *
     * @param name           of the Admin
     * @param lastName       of the Admin
     * @param personalId     of the Admin
     * @param phoneNumber    of the Admin
     * @param age            of the Admin
     * @param password       of the Admin
     */
    public Admin(String name, String lastName, int personalId, String phoneNumber, int age, String password) {
        super(name, lastName, personalId, phoneNumber, age, "A"+password);

    }


    /**
     * Adds the trainer to a Specified Gym
     * @param gym the gym which the trainer will be added.
     * @param trainer the trainer that will be added to the gym.
     */
    public void registerTrainer(Gym gym, Trainer trainer){
        gym.getTrainersList().add(trainer);
    }

    /**
     * Modifies a trainer's age.
     * @param trainer whose age will change
     * @param age new age of the trainer
     */
    public void modifyTrainerAge(Trainer trainer, int age){
        trainer.setAge(age);
    }

    /**
     * Modifies a trainer's name.
     * @param trainer whose name will change.
     * @param name new name of the trainer.
     */
    public void modifyTrainerName(Trainer trainer, String name){
        trainer.setName(name);
    }

    /**
     * Modifies a trainer's last name.
     * @param trainer whose last name will change.
     * @param lastName new last name of the trainer.
     */
    public void modifyTrainerLastName(Trainer trainer, String lastName){
        trainer.setLastName(lastName);
    }

    /**
     * Modifies a trainer's personal id.
     * @param trainer whose personal id will change.
     * @param personalId the trainer new personal id.
     */
    public void modifyTrainerPersonalId(Trainer trainer, int personalId){
        trainer.setPersonalId(personalId);
    }

    /**
     * Modifies a trainer's phone number.
     * @param trainer whose phone number will change
     * @param phoneNumber the new phone number of the trainer
     */
    public void modifyTrainerPhoneNumber(Trainer trainer, String phoneNumber){
        trainer.setPhoneNumber(phoneNumber);
    }

    /**
     * Removes a trainer from its gym's list.
     * @param gym the gym we are removing the trainer from.
     * @param trainer the trainer that will be removed.
     */
    public void removeTrainer(Gym gym, Trainer trainer){
        gym.getTrainersList().remove(trainer);
    }

    /**
     * Assigns a trainer to a Session (class).
     * @param session the session that will be assigned.
     * @param trainer the trainer that will be added to a class.
     */
    public void assignTrainer(Session session, Trainer trainer){
        session.setTheTrainer(trainer);
    }


    /**
     * This has to supposedly generate the AdminReport buttheresnosht.
     */
    public void reportAdmin(){
        //NOTHING!!! THERE'S NO DATA TO TEST OR EVEN IMAGINE IT!1!
    }


}
