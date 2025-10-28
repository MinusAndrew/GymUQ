package uniquindio.edu.co.gymuq.model;
import java.util.Calendar;

public class User {

    private String name;
    private String lastName;
    private int personalId;
    private String phoneNumber;
    private int age;
    private Calendar date;

    //Relationships
    private Membership theMembership;

    /**
     * User class Constructor
     * @param name of the user
     * @param lastName of the user
     * @param personalId of the user
     * @param phoneNumber of the user
     * @param age of the user
     * @param theMembership of the user
     */

    public User(String name, String lastName, int personalId, String phoneNumber, int age, Membership theMembership,Calendar date) {
        this.name = name;
        this.lastName = lastName;
        this.personalId = personalId;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.theMembership = theMembership;
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     *
     * @return
     */
    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }
    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    /**
     *
     * @return
     */
    public Membership getTheMembership() {
        return theMembership;
    }



    /**
     *
     * @param theMembership
     */
    public void setTheMembership(Membership theMembership) {
        this.theMembership = theMembership;
    }
}
