package uniquindio.edu.co.model;
import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

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
        this.password = encrypt(password);
    }

    //All these variables are used to encrypt the password
    public static final KeyGenerator keygenerator;
    public static final Cipher desCipher;
    static {
        try {
            keygenerator = KeyGenerator.getInstance("AES");
            desCipher = Cipher.getInstance("AES");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static final SecretKey myDesKey = keygenerator.generateKey();

    /**
     * Method that encrypts a password
     * @param password to encrypt
     * @return the encrypted password
     */
    private static String encrypt(String password){
        try{
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            byte[] textEncrypted = desCipher.doFinal(passwordBytes);
            password = new String(textEncrypted);

        } catch (Exception e) {
            System.out.println("Exception");
        }
        return password;
    }

    /**
     * Method that compares a password with the encrypted one
     * @param password to compare
     * @return the comparison
     */
    public boolean comparePasswords(String password){
        return encrypt(password).equals(this.password);
    }


    //Getters and Setters

    /**
     * Method that gets the name of the Staff.
     * @return the name of the Staff
     */
    public String getName() {
        return name;
    }

    /**
     * Method that sets the name of the Staff.
     * @param name to be assigned to the Staff
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that gets the last name of the Staff.
     * @return the last name of the Staff
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method that sets the last name of the Staff.
     * @param lastName of the Staff
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method that gets the personal id of the Staff.
     * @return the personal id of the Staff
     */
    public int getPersonalId() {
        return personalId;
    }

    /**
     * Method that sets the personal id of the Staff.
     * @param personalId of the Staff
     */
    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    /**
     * Method that gets the phone number of the Staff.
     * @return the phone number of the Staff
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method that sets the phone number of the Staff.
     * @param phoneNumber of the Staff
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method that gets the age of the Staff.
     * @return the age of the Staff
     */
    public int getAge() {
        return age;
    }

    /**
     * Method that sets the age of the Staff.
     * @param age of the Staff
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * VERY SAFE AND ABSOLUTELY SECURE METHOD
     * @return returns the worker's password LMAO. (NOW encrypted :p)
     */
    public String getPassword() {
        return password;
    }

    /**
     * Safer than the last one is for sure (Well this needs a verification first)
     * @param password the password given by the Staff.
     */
    public void setPassword(String password) {
        this.password = encrypt(password);
    }

    /*
     * static String desencryptPassword(String password){
        try{
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted = desCipher.doFinal(passwordBytes);
            password = new String(textDecrypted);
        } catch (Exception e) {
            System.out.println("Exception");
        }
        return password;
     }
     */

    @Override
    public String toString() {
        return
                "Nombre: '" + name + lastName + '\n' +
                "Identificacion: " + personalId + '\n' +
                "Numero de telefono: '" + phoneNumber;
    }
}
