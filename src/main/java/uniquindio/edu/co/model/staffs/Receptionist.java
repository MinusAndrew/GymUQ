package uniquindio.edu.co.model.staffs;
import uniquindio.edu.co.model.*;
import uniquindio.edu.co.model.enums.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Receptionist extends Staff {

    /**
     * Receptionist class Constructor
     *
     * @param name           of the Receptionist
     * @param lastName       of the Receptionist
     * @param personalId     of the Receptionist
     * @param phoneNumber    of the Receptionist
     * @param age            of the Receptionist
     * @param password       of the Receptionist
     */
    public Receptionist(String name, String lastName, int personalId, String phoneNumber, int age, String password) {
        super(name, lastName, personalId, phoneNumber, age, "R"+password);
    }


    /**
     * Method that registers a user inside the Gym usersList
     * @param user to add
     * @param gym which we are going to add the user
     */
    public void registerUser(User user,Gym gym){
        List<User> userlist = gym.getUsersList();
        userlist.add(user);
        gym.setUsersList(userlist);
    }

    /**
     * Method that assigns a MembershipType to the User.
     * @param user which we are going to assign the MembershipType.
     * @param membershipType to add.
     */
    public void assignMembershipType(User user, MembershipType membershipType){
        Membership membership = user.getTheMembership();
        membership.setType(membershipType);
        user.setTheMembership(membership);
    }

    /**
     * Method that assigns a Membership to the User.
     * @param user which we are going to assign the Membership.
     * @param membership to add.
     */
    public void assignMembership(User user, Membership membership){
        user.setTheMembership(membership);
        membership.setTheUser(user);
    }

    /**
     * Method that adds a user in a Session.
     * @param user to add
     * @param session to add the user
     */
    public void reserveSession(User user,Session session){
        List<User> userList = session.getSessionUsersList();
        userList.add(user);
        session.setSessionUsersList(userList);
    }

    /**
     * Method that checks if a User can access the gym.
     * @param id of the User
     * @param gym which we are going to search the User
     * @return the User Membership Status.
     */
    public String checkMembership(int id,Gym gym){
        User user = gym.searchUserByPersonalId(id);
        gym.dailyCheck.add(user);
        Membership membership = user.getTheMembership();
        if(membership.isStatus()){
            return "Ingreso APROBADO la membresia caduca en: "+ ChronoUnit.DAYS.between(LocalDate.now(),membership.getEndDate()) + " dias";
        } else {
            return "Ingreso RECHAZADO la membresia caduco hace: " + ChronoUnit.DAYS.between(membership.getEndDate(),LocalDate.now()) + " dias";
        }
    }

    /**
     * Method that generates a report of the gym.
     * @param gym which we are going to generate the report
     * @return the report
     */
    public String report(Gym gym){
        return "Usuarios activos: \n" + activeUsers(gym) + "\n Clases mas reservadas: \n" + mostReservedSession(gym) +  "\n Reporte de membresias: \n" + membershipsReport(gym.getMembershipsList());
    }

    //All these methods are used to generate the report

    /**
     * Method that checks if a Membership is expired.
     * @param memb to check
     * @return if the Membership is expired
     */
    static boolean expiredMembership (Membership memb){
        LocalDate hoy = LocalDate.now();
        return memb.getEndDate().isBefore(hoy);
    }
    /**
     * Method that checks if a Membership is about to expire.
     * @param memb to check
     * @return if the Membership is about to expire
     */
    static boolean toExpireMembership (Membership memb){
        LocalDate hoy = LocalDate.now();
        LocalDate toExp = LocalDate.now().plusDays(15);
        return memb.getEndDate().isBefore(toExp) && memb.getEndDate().isAfter(hoy);
    }
    /**
     * Method that generates a report of the memberships.
     * @param list of the memberships
     * @return the memberships report
     */
    static String membershipsReport(List<Membership> list){
        LocalDate hoy = LocalDate.now();

        StringBuilder reporteExpirados = new StringBuilder();
        StringBuilder reportePorExpirar = new StringBuilder();

        for(Membership memb : list){
            User usuario = memb.getTheUser();
            String nombreUsario = usuario.getName();
            int idUsuario = usuario.getPersonalId();
            LocalDate fechaFinal = memb.getEndDate();
            if (toExpireMembership(memb)){
                long caducaEn = ChronoUnit.DAYS.between(hoy,fechaFinal);
                reportePorExpirar.append("La membresia del usuario: ").append(nombreUsario).append(" con documento ").append(idUsuario).append(" caduca en ").append(caducaEn).append(" dias\n");
            }
            if (expiredMembership(memb)) {
                long caducoHace = ChronoUnit.DAYS.between(fechaFinal,hoy);
                reporteExpirados.append("La membresia del usuario: ").append(nombreUsario).append(" con documento ").append(idUsuario).append(" caduco hace ").append(caducoHace).append(" dias\n");
            }
        }
        return "Membresias por caducar: \n" + reportePorExpirar + "Membresias caducadas: \n" + reporteExpirados;
    }
    /**
     * Method that generates a report of the active users.
     * @param gym which we are going to generate the report
     * @return the report of the active users
     */
    static String activeUsers(Gym gym){
        StringBuilder s = new StringBuilder();
        for(User u : gym.dailyCheck){
            s.append(u.getName()).append(" ").append(u.getLastName()).append("   ").append(u.getPersonalId()).append("\n");
        }
        return s.toString();
    }
    /**
     * Method that generates a report of the most reserved session.
     * @param gym which we are going to generate the report
     * @return the report of the most reserved session
     */
    static String mostReservedSession (Gym gym){
        List<Session> list = gym.getSessionList();
        Session mostReservedSession = null;
        int idk = 0;
        for(Session session : list){
            if(session.getSessionUsersList().size() > idk){
                mostReservedSession = session;
                idk = session.getSessionUsersList().size();
            }
        }
        if(mostReservedSession == null){
            return "No hay clases";
        } else {
            return mostReservedSession.toString();
        }

    }





}
