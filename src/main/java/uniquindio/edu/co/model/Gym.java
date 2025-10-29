package uniquindio.edu.co.model;

import uniquindio.edu.co.model.workers.Trainer;

import java.util.ArrayList;
import java.util.List;

public class Gym {

    //Attributes
    private String name;
    private int id;

    //Relationships
    private List<User> userList;
    private List<Trainer> trainerList;

    /**
     * Gym class Constructor
     * @param name of the Gym
     * @param id of the Gym
     */
    public Gym(String name, int id) {
        this.name = name;
        this.id = id;
        this.userList = new ArrayList<>();
        this.trainerList = new ArrayList<>();
    }

    /**
     * Method to register a user in the usersList.
     * @param user to add
     */
    public void registerUser(User user){
        userList.add(user);
    }

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
    public List<User> getUserList() {
        return userList;
    }

    /**
     * Sets the list of users in the gym
     * @param userList the list of the users in the gym.
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * Gets the list of trainers in the gym.
     * @return the trainerList of the gym
     */
    public List<Trainer> getTrainerList() {
        return trainerList;
    }

    /**
     * Sets the list of trainers in the gym
     * @param trainerList of the gym
     */
    public void setTrainerList(List<Trainer> trainerList) {
        this.trainerList = trainerList;
    }
}
