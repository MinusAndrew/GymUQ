package uniquindio.edu.co.model;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import uniquindio.edu.co.model.staffs.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Session {

    //Attributes
    private int maxCapacity;
    private String type;
    private LocalDate schedule;
    private String name;
    private LocalTime hour;

    //Relationships
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
    public Session(int maxCapacity, String type, LocalDate schedule, String name, Trainer theTrainer, LocalTime hour) {
        this.maxCapacity = maxCapacity;
        this.type = type;
        this.schedule = schedule;
        this.name = name;
        this.theTrainer = theTrainer;
        this.hour = hour;
        this.sessionUsersList=new ArrayList<>();


    }

    /**
     * Method that adds a user to the session
     * @param user to add
     */
    public void addUserToSession(User user){
        assert sessionUsersList.size() < maxCapacity : "Session is full";
            sessionUsersList.add(user);
            sendEmailSession(user);
    }

    /**
     * Method that sends an email to the user when booking a session
     * @param user to whom the email is to be sent
     */
    public void sendEmailSession(User user){
        try {
            Email email = EmailBuilder.startingBlank()
                    .from("GymUQ", "jacobo.londonod@uqvirtual.edu.co")
                    .to(user.getName(), user.getEmail())
                    .withSubject("Registro exitoso en la clase")
                    .withPlainText("Usted se ha registrado en la clase " + this.name + " para el dia "+ this.schedule + " A las " + this.hour)
                    .buildEmail();
            Mailer mailer = MailerBuilder
                    //Same here lol
                    .withSMTPServer("smtp.gmail.com", 587, "londonojacobo92@gmail.com", "gzxg xxyx xbqb lzey")
                    .withTransportStrategy(TransportStrategy.SMTP_TLS)
                    .buildMailer();
            mailer.sendMail(email);
        }catch (Exception e){
            System.out.println("Something failed " + e);
        }

    }


    //Getters and Setters

    /**
     * Method that get the Session max Capacity
     * @return the Session max Capacity
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Method that sets the Session max Capacity
     * @param maxCapacity of the Session
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * Method that gets the type of the Session
     * @return the type of the Session
     */
    public String getType() {
        return type;
    }

    /**
     * Method that set the type of the Session
     * @param type of the Session
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method that gets the Schedule of the Session
     * @return the Schedule of the Session
     */
    public LocalDate getSchedule() {
        return schedule;
    }

    /**
     * Method that sets the Schedule of the Session
     * @param schedule of the Session
     */
    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }

    /**
     * Method that gets the name of the Session
     * @return the name of the Session
     */
    public String getName() {
        return name;
    }

    /**
     * Method that sets the name of the Session
     * @param name of the Session
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that gets the hour of the Session
     * @return the hour of the Session
     */
    public LocalTime getHour() {
        return hour;
    }

    /**
     * Method that sets the hour of the Session
     * @param hour of the Session
     */
    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    /**
     * Method that gets the trainer of the Session
     * @return the trainer of the Session
     */
    public Trainer getTheTrainer() {
        return theTrainer;
    }

    /**
     * Method that sets the trainer of the Session
     * @param theTrainer of the Session
     */
    public void setTheTrainer(Trainer theTrainer) {
        this.theTrainer = theTrainer;
    }

    /**
     * Method that gets the list of the users in the Session
     * @return the list of the users in the Session
     */
    public List<User> getSessionUsersList() {
        return sessionUsersList;
    }

    /**
     * Method that sets the list of user in the Session
     * @param sessionUsersList in the Session
     */
    public void setSessionUsersList(List<User> sessionUsersList) {
        this.sessionUsersList = sessionUsersList;
    }

    @Override
    public String toString() {
        return "Session{" +
                "maxCapacity=" + maxCapacity +
                ", type='" + type + '\'' +
                ", schedule=" + schedule +
                ", name='" + name + '\'' +
                ", hour=" + hour +
                ", theTrainer=" + theTrainer +
                ", sessionUsersList=" + sessionUsersList +
                '}';
    }
}
