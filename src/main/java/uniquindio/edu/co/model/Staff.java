package uniquindio.edu.co.model;

public class Staff {

    //Attributes
    private String name;
    private String lastName;
    private int personalId;
    private String phoneNumber;
    private int age;
    private String password;

    /**
     * Staff class Constructor
     *
     * @param name           of the Staff
     * @param lastName       of the Staff
     * @param personalId     of the Staff
     * @param phoneNumber    of the Staff
     * @param age            of the Staff
     * @param password       of the Staff
     */
    public Staff(String name, String lastName, int personalId, String phoneNumber, int age, String password) {
        this.name = name;
        this.lastName = lastName;
        this.personalId = personalId;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * VERY SAFE AND ABSOLUTELY SECURE METHOD
     * @return returns the worker's password LMAO.
     */
    public String getPassword() {
        return password;
    }


    /**
     * Safer than the last one is for sure
     * @param password the password given by the Staff.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
