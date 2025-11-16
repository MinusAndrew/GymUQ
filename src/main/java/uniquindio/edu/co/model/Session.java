package uniquindio.edu.co.model;

import uniquindio.edu.co.model.staffs.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Session {

    //Attributes
    private int maxCapacity;
    private String type;
    private LocalDate schedule;
    private String name;

    // Relationships
    private Trainer theTrainer;
    private List<User> sessionUsersList;

    /**
     * Session class Constructor
     *
     * @param maxCapacity of the Session
     * @param type of the Session
     * @param schedule of the Session
     * @param name of the Session
     */
    public Session(int maxCapacity, String type, LocalDate schedule, String name, Trainer theTrainer) {
        this.maxCapacity = maxCapacity;
        this.type = type;
        this.schedule = schedule;
        this.name = name;
        this.theTrainer = theTrainer;
        this.sessionUsersList=new ArrayList<>();

    }

    public void addUserToSession(User user){
        assert sessionUsersList.size() < maxCapacity : "Session is full";
        sessionUsersList.add(user);
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTheTrainer() {
        return theTrainer;
    }

    public void setTheTrainer(Trainer theTrainer) {
        this.theTrainer = theTrainer;
    }

    public List<User> getSessionUsersList() {
        return sessionUsersList;
    }

    public void setSessionUsersList(List<User> sessionUsersList) {
        this.sessionUsersList = sessionUsersList;
    }
}
