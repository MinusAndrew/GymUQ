package uniquindio.edu.co.gymuq.model;

public class Class {
    private int maxCapacity;
    private String type;
    private String schedule;
    private String name;

    // Relationship to trainer

    /**
     *
     * @param maxCapacity of the class
     * @param type of the class
     * @param schedule of the class
     * @param name of the class
     */
    public Class(int maxCapacity, String type, String schedule, String name) {
        this.maxCapacity = maxCapacity;
        this.type = type;
        this.schedule = schedule;
        this.name = name;
        //add Trainer

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
}
