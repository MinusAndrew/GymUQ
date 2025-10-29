package uniquindio.edu.co.model.workers;
import uniquindio.edu.co.model.*;
import uniquindio.edu.co.model.enums.*;
import java.util.List;

public class Receptionist extends Worker {
    /**
     * Receptionist class Constructor
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

    /**
     * Method that registers a user inside the Gym usersList
     * @param user to add
     * @param gym which we are going to add the user
     */
    public void registerUser(User user,Gym gym){
        List<User> userlist = gym.getUserList();
        userlist.add(user);
        gym.setUserList(userlist);
    }

    /**
     * Method that assign a Membership to a User
     * @param user which we are going to assign the Membership
     * @param membershipType to add
     */
    public void assignMembership(User user, MembershipType membershipType){
        Membership membership = user.getTheMembership();
        membership.setType(membershipType);
        user.setTheMembership(membership);
    }
}
