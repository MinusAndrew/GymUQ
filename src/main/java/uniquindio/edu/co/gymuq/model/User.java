package uniquindio.edu.co.gymuq.model;

public class User {

    //Attributes
    private String name;
    private String lastName;
    private int personalId;
    private String phoneNumber;
    private int age;

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

    public User(String name, String lastName, int personalId, String phoneNumber, int age, Membership theMembership) {
        this.name = name;
        this.lastName = lastName;
        this.personalId = personalId;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.theMembership = theMembership;
    }

    //Getters and Setters

    /**
     * Get username
     * @return username
     */
    public String getName() {
        return name;
    }

    /**
     * Set username
     * @param name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get user lastName
     * @return user lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set user lastName
     * @param lastName of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get user personalId
     * @return user personalI
     */
    public int getPersonalId() {
        return personalId;
    }

    /**
     * Set user personalId
     * @param personalId of the user
     */
    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    /**
     * Get user phoneNumber
     * @return user phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set user phoneNumber
     * @param phoneNumber of the user
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get user age
     * @return age of the user
     */
    public int getAge() {
        return age;
    }

    /**
     * Set user age
     * @param age of the user
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get user Membership
     * @return user Membership
     */
    public Membership getTheMembership() {
        return theMembership;
    }

    /**
     * Set user Membership
     * @param theMembership of the user
     */
    public void setTheMembership(Membership theMembership) {
        this.theMembership = theMembership;
    }
}
