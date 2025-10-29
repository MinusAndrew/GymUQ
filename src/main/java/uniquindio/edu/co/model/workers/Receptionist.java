package uniquindio.edu.co.model.workers;
import uniquindio.edu.co.model.*;
import uniquindio.edu.co.model.enums.*;
import java.util.List;

public class Receptionist extends Worker {
    /**
     * Receptionist class Constructor
     *
     * @param name           of the Receptionist
     * @param lastName       of the Receptionist
     * @param personalId     of the Receptionist
     * @param phoneNumber    of the Receptionist
     * @param age            of the Receptionist
     * @param theMembership  of the Receptionist
     * @param theUserSession of the Receptionist
     * @param password       of the Receptionist
     */
    public Receptionist(String name, String lastName, int personalId, String phoneNumber, int age, Membership theMembership, Session theUserSession, String password) {
        super(name, lastName, personalId, phoneNumber, age, theMembership, theUserSession, password);
    }

    /**
     * Method that registers a user inside the Gym usersList
     * @param user to add
     * @param gym which we are going to add the user
     */
    public void registerUser(User user,Gym gym){
        List<User> userlist = gym.getUsersList();
        userlist.add(user);
        gym.setUsersList(userlist);
    }

    /**
     * Method that assign a MembershipType to a User
     * @param user which we are going to assign the MembershipType
     * @param membershipType to add
     */
    public void assignMembership(User user, MembershipType membershipType){
        Membership membership = user.getTheMembership();
        membership.setType(membershipType);
        user.setTheMembership(membership);
    }

    /**
     * Method that add a user in a Session
     * @param user to add
     * @param session to add the user
     */
    public void reserveSession(User user,Session session){
        List<User> userList = session.getSessionUsersList();
        userList.add(user);
        session.setSessionUsersList(userList);
    }

    /**
     * Method that check if the User can access the gym
     * @param id of the User
     * @param gym which we are going to search the User
     * @return the User Membership Status
     */
    public boolean checkMembership(int id,Gym gym){
        User user = gym.searchUserByPersonalId(id);
        Membership membership = user.getTheMembership();
        return membership.isStatus();
    }

}
