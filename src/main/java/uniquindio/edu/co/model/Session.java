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

    // Relationships
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

    public void addUserToSession(User user){
        assert sessionUsersList.size() < maxCapacity : "Session is full";
            sessionUsersList.add(user);
            sendEmailSession(user);
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

    public LocalDate getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTheTrainer() {
        return theTrainer;
    }

    public void setTheTrainer(Trainer theTrainer) {
        this.theTrainer = theTrainer;
    }

    public List<User> getSessionUsersList() {
        return sessionUsersList;
    }

    public void setSessionUsersList(List<User> sessionUsersList) {
        this.sessionUsersList = sessionUsersList;
    }

    public void sendEmailSession(User user){
        try {
            Email email = EmailBuilder.startingBlank()
                    .from("Gym", "jacobo.londonod@uqvirtual.edu.co")
                    .to(user.getName(), user.getEmail())
                    .withSubject("Registro exitoso en la clase")
                    .withPlainText("Usted se ha registrado en la clase " + this.name + " para el dia "+ this.schedule + " A las " + this.hour)
                    .buildEmail();
            Mailer mailer = MailerBuilder
                    // Same here lol
                    .withSMTPServer("smtp.gmail.com", 587, "londonojacobo92@gmail.com", "gzxg xxyx xbqb lzey")
                    .withTransportStrategy(TransportStrategy.SMTP_TLS) // or SMTP_SSL, SMTPS
                    .buildMailer();
            mailer.sendMail(email);
        }catch (Exception e){
            System.out.println("Something failed " + e);
        }

    }

    public LocalTime getHour() {
        return hour;
    }
}
