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
     * Get gym name
     * @return name of the gym
     */
    public String getName() {
        return name;
    }

    /**
     * Set gym name
     * @param name of the gym
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get gym id
     * @return gym id
     */
    public int getId() {
        return id;
    }

    /**
     * Set gym id
     * @param id if the gym
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the list of users in the gym
     * @return gym usersList
     */
    public List<User> getUsersList() {
        return usersList;
    }

    /**
     * Set the list of users in the gym
     * @param usersList of the gym
     */
    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    /**
     * Get the list of trainers in the gym
     * @return gym trainersList
     */
    public List<Trainer> getTrainersList() {
        return trainersList;
    }

    /**
     * Set the list of trainers in the gym
     * @param trainersList of the gym
     */
    public void setTrainersList(List<Trainer> trainersList) {
        this.trainersList = trainersList;
    }
}
