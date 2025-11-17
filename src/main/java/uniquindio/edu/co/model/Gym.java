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

    public void registerMembership(Membership membership){
        membershipsList.add(membership);
    }

    public void checkMemberships(){
        for (User user : this.usersList) {
            Membership memb = user.getTheMembership();
            boolean status = memb.isStatus();
            memb.updateStatus();
            if(status!= memb.isStatus()){
                System.out.println(memb);
            }
            if(memb.getEndDate().minusDays(7).isEqual(LocalDate.now())){
                sendEmailMembership(user);
            }
        }
    }

    public List<User> mostActiveUsers(){
        List<User> mostActiveUsers = new ArrayList<>();
        List<User> test = new ArrayList<>();
        for (Session session : this.sessionList) {
            List<User> u = session.getSessionUsersList();
            for(User u1 : u){
                if(!test.contains(u1)){
                    test.add(u1);
                }
            }
        }

        return mostActiveUsers;
    }


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
     * Method to register a user in the usersList.
     * @param user to add
     */
    public void registerUser(User user){
        assert !verifyUserPersonalId(user) : "User already exists";
        usersList.add(user);
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

    public void registerSession(Session session){
        sessionList.add(session);
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


    public void sendEmailMembership(User user){
        Email email = EmailBuilder.startingBlank()
                .from("Gym", "jacobo.londonod@uqvirtual.edu.co")
                .to(user.getName(), user.getEmail())
                .withSubject("TU MEMBRESIA ESTA A PUNTO DE EXPIRAR")
                .withPlainText("Tu membresia caduca en 7 dias")
                .buildEmail();
        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "londonojacobo92@gmail.com", "gzxg xxyx xbqb lzey")
                .withTransportStrategy(TransportStrategy.SMTP_TLS) // or SMTP_SSL, SMTPS
                .buildMailer();
        mailer.sendMail(email);
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
}
