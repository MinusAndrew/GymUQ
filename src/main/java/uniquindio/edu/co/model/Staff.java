package uniquindio.edu.co.model;
import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class Staff {

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


    static String encrypt(String password){
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

    public boolean comparePasswords(String password){
        return encrypt(password).equals(this.password);
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
     * @return returns the worker's password LMAO.(NOW encrypted :p)
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
        return "Staff: \n" +
                "name: '" + name + '\n' +
                "lastName: '" + lastName + '\n' +
                "personalId: " + personalId + '\n' +
                "phoneNumber: '" + phoneNumber;
    }
}
