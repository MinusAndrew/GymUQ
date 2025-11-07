package uniquindio.edu.co.model;

import uniquindio.edu.co.model.workers.Trainer;

import java.util.ArrayList;
import java.util.List;

public class Gym {

    //Attributes
    private String name;
    private int id;

    //Relationships
    private List<User> usersList;
    private List<Trainer> trainersList;

    /**
     * Gym class Constructor
     * @param name of the Gym
     * @param id of the Gym
     */
    public Gym(String name, int id) {
        this.name = name;
        this.id = id;
        this.usersList = new ArrayList<>();
        this.trainersList = new ArrayList<>();
    }

    /**
     * Method to register a user in the usersList.
     * @param user to add
     */
    public void registerUser(User user){
        assert !verifyUserPersonalId(user) : "User already exists";
            usersList.add(user);
    }

    /**
     * Method to search a user using their personalId
     * @param id of the user to search
     * @return the user with the personalId
     */
    public User searchUserByPersonalId(int id){
        User user = null;
        for(User u : usersList){
            if(u.getPersonalId() == id){
                user = u;
                break;
            }
        }
        return user;
    }

    public boolean verifyUserPersonalId(User user){
        boolean flag = false;
        for(User u : usersList){
            if(user.getPersonalId() == u.getPersonalId()){
                flag = true;
                break;
            }
        }
        return flag;
    }

    //Getters and Setters

    /**
     * Gets gym name.
     * @return name of the gym.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a gym name.
     * @param name the name of the gym.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets gym id.
     * @return returns the gym id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets gym id.
     * @param id the gym id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the list of users in the gym.
     * @return the usersList of the gym.
     */
    public List<User> getUsersList() {
        return usersList;
    }

    /**
     * Sets the list of users in the gym
     * @param usersList the list of the users in the gym.
     */
    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    /**
     * Gets the list of trainers in the gym.
     * @return the trainerList of the gym
     */
    public List<Trainer> getTrainersList() {
        return trainersList;
    }

    /**
     * Sets the list of trainers in the gym
     * @param trainersList of the gym
     */
    public void setTrainersList(List<Trainer> trainersList) {
        this.trainersList = trainersList;
    }

}
