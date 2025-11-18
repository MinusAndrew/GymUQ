package uniquindio.edu.co.model;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import uniquindio.edu.co.model.staffs.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Gym {

    public List<User> dailyCheck =  new ArrayList<>();
    //Attributes
    private String name;
    private int id;

    //Relationships
    private List<User> usersList;
    private List<Session> sessionList;
    private List<Trainer> trainersList;
    private List<Staff> staffList;
    private List<Membership> membershipsList;

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
        this.staffList = new ArrayList<>();
        this.membershipsList = new ArrayList<>();
        this.sessionList = new ArrayList<>();
    }


    //Register

    /**
     * Registers a membership into the gym's membershipsList
     * @param membership that will be added.
     */
    public void registerMembership(Membership membership){
        membershipsList.add(membership);
    }

    /**
     * Registers a staff member into the gym's staffList
     * @param staff that will be added.
     */
    public void registerStaff(Staff staff){
        staffList.add(staff);
    }

    /**
     * Registers a trainer into the gym's trainerList
     * @param trainer that will be added.
     */
    public void registerTrainer(Trainer trainer){ trainersList.add(trainer); }

    /**
     * Method to register a user in the usersList.
     * @param user to add
     */
    public void registerUser(User user){
        assert !verifyUserPersonalId(user) : "User already exists";
        usersList.add(user);
    }

    /**
     * Method to register a session in the sessionList.
     * @param session to add
     */
    public void registerSession(Session session){
        sessionList.add(session);
    }

    //Search

    /**
     * Method to search a receptionist using their name
     * @param name of the receptionist to search
     * @return the receptionist with the name
     */
    public Receptionist getReceptionistFromName(String name){
        for(Staff receptionist : staffList){
            if(receptionist.getName().equals(name)){
                return (Receptionist) receptionist;
            }
        }
        //if this happens there's no receptionist with such name thus it cannot access their Functionality
        return null;
    }

    /**
     * Method to search a trainer using their name
     * @param name of the trainer to search
     * @return the trainer with the name
     */
    public Trainer getTrainerFromName(String name) {
        for (Staff trainer : staffList) {
            if (trainer.getName().equals(name)) {
                return (Trainer) trainer;
            }
        }
        //if this happens there's no trainer with such name thus it cannot access their Functionality
        return null;
    }

    /**
     * Method to search a user using their personalId
     * @param id of the user to search
     * @return the user with the personalId
     */
    public User searchUserByPersonalId(int id){
        User user = null;
        for(User u : usersList){
            if(u.getPersonalId() == id){
                user = u;
                break;
            }
        }
        return user;
    }


    /**
     * Method that updates all membership status and send an email if the membership is to expire.
     */
    public void checkMemberships(){
        for (User user : this.usersList) {
            Membership memb = user.getTheMembership();
            memb.updateStatus();
            if(memb.getEndDate().minusDays(7).isEqual(LocalDate.now())){
                sendEmailMembership(user);
            }
        }
    }

    /**
     * Method that verifies if a Staff can log in.
     * @param name of the Staff
     * @param password of the Staff
     * @return if the Staff can log in
     */
    public boolean login(String name, String password){
        boolean flag = false;
        for(Staff staff : staffList){
            if(staff.getName().equals(name) && staff.comparePasswords(password)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * Removes trainer from the gym's trainerList
     * @param trainer that will be removed.
     */
    public void removeTrainer(Trainer trainer){
        trainersList.remove(trainer);
    }

    /**
     * Removes the staff member from the gym's staffList
     * @param staff that will be removed.
     */
    public void removeStaff(Staff staff){
        staffList.remove(staff);
    }

    /**
     * Method that verifies if a user already exists in the gym's usersList.
     * @param user to verify
     * @return if the user already exists
     */
    public boolean verifyUserPersonalId(User user){
        boolean flag = false;
        for(User u : usersList){
            if(user.getPersonalId() == u.getPersonalId()){
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * Method that sends an email to the user if his membership is to expire.
     * @param user to whom the email is to be sent
     */
    public void sendEmailMembership(User user){
        Email email = EmailBuilder.startingBlank()
                .from("Gym", "jacobo.londonod@uqvirtual.edu.co")
                .to(user.getName(), user.getEmail())
                .withSubject("TU MEMBRESIA ESTA A PUNTO DE EXPIRAR")
                .withPlainText("Tu membresia caduca en 7 dias")
                .buildEmail();
        Mailer mailer = MailerBuilder
                //I don't think putting your token as plain text is a good idea
                .withSMTPServer("smtp.gmail.com", 587, "londonojacobo92@gmail.com", "gzxg xxyx xbqb lzey")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .buildMailer();
        mailer.sendMail(email);
    }

    //Getters and Setters

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
    public List<User> getUsersList() {
        return usersList;
    }

    /**
     * Sets the list of users in the gym
     * @param usersList the list of the users in the gym.
     */
    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    /**
     * Gets the list of trainers in the gym.
     * @return the trainerList of the gym
     */
    public List<Trainer> getTrainersList() {
        return trainersList;
    }

    /**
     * Sets the list of trainers in the gym
     * @param trainersList of the gym
     */
    public void setTrainersList(List<Trainer> trainersList) {
        this.trainersList = trainersList;
    }

    /**
     * Returns the list of the staff members inside the gym.
     * @return the gym's staffList
     */
    public List<Staff> getStaffList() {
        return staffList;
    }

    /**
     * Returns the gym's sessionList
     * @return gym's sessionList
     */
    public List<Session> getSessionList() {
        return sessionList;
    }

    /**
     * Sets the list of sessions in the gym.
     * @param sessionList the list of sessions to be set for the gym
     */
    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }

    /**
     * Sets the list of staff members in the gym.
     * @param staffList the list of staff members to be assigned to the gym
     */
    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    /**
     * Gets the list of memberships in the gym.
     * @return the list of memberships in the gym.
     */
    public List<Membership> getMembershipsList() {
        return membershipsList;
    }

    /**
     * Sets the list of memberships in the gym.
     * @param membershipsList the list of memberships to set.
     */
    public void setMembershipsList(List<Membership> membershipsList) {
        this.membershipsList = membershipsList;
    }



}
