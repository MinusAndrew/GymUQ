package uniquindio.edu.co.model.workers;
import uniquindio.edu.co.model.*;
import java.util.List;

public class Admin extends Worker {
    /**
     * Admin class Constructor
     *
     * @param name           of the Admin
     * @param lastName       of the Admin
     * @param personalId     of the Admin
     * @param phoneNumber    of the Admin
     * @param age            of the Admin
     * @param theMembership  of the Admin
     * @param theUserSession of the Admin
     * @param password       of the Admin
     */
    public Admin(String name, String lastName, int personalId, String phoneNumber, int age, Membership theMembership, Session theUserSession, String password) {
        super(name, lastName, personalId, phoneNumber, age, theMembership, theUserSession, password);
    }

    /**
     * Method that add a trainer in the gym
     * @param trainer to add
     * @param gym
     */
    public void registerTrainer(Trainer trainer,Gym gym){
        List<User> userList = gym.getUsersList();
        userList.add(trainer);
        gym.setUsersList(userList);
    }

    public void modifyTrainer(Trainer trainer,Gym gym){

    }

    /**
     * Method that remove a Trainer from the gym
     * @param trainer to remove
     * @param gym
     */
    public void removeTrainer(Trainer trainer,Gym gym){
        List<User> userList = gym.getUsersList();
        userList.remove(trainer);
        gym.setUsersList(userList);
    }

    /**
     * Method that assign a Trainer in a Session
     * @param trainer to assign
     * @param session
     */
    public void assignTrainer(Trainer trainer,Session session){
        List<Trainer> trainerList = session.getTrainersList();
        trainerList.add(trainer);
        session.setTrainersList(trainerList);
    }
}
