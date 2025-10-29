package uniquindio.edu.co.model;

import uniquindio.edu.co.model.workers.Trainer;
import java.util.ArrayList;
import java.util.List;

public class Session {

    //Attributes
    private int maxCapacity;
    private String type;
    private String schedule;
    private String name;

    // Relationships
    private List<Trainer> trainersList;


    /**
     * Session class Constructor
     *
     * @param maxCapacity of the Session
     * @param type of the Session
     * @param schedule of the Session
     * @param name of the Session
     */
    public Session(int maxCapacity, String type, String schedule, String name) {
        this.maxCapacity = maxCapacity;
        this.type = type;
        this.schedule = schedule;
        this.name = name;
        this.trainersList=new ArrayList<>();

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

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trainer> getListTrainers() {
        return trainersList;
    }

    public void setTrainersList(List<Trainer> trainersList) {
        this.trainersList = trainersList;
    }
}
