package uniquindio.edu.co.model;

import uniquindio.edu.co.model.enums.*;

import java.time.LocalDate;

public class Membership {

    //Attributes
    private int cost;
    private final LocalDate startDate;
    private LocalDate endDate;
    boolean status;

    //Relationships
    private User theUser;

    //Enums
    private MembershipPlan plan;
    private MembershipType type;

    /**
     * Membership class Constructor
     *
     * @param cost of the membership
     * @param theUser of the membership
     * @param plan of the membership
     * @param type of the membership
     */
    public Membership(int cost, User theUser, MembershipPlan plan, MembershipType type) {
        this.cost = cost;
        this.theUser = theUser;
        this.plan = plan;
        assert type != null;
        this.type = type;
        this.startDate = LocalDate.now();
        this.endDate = startDate.plusMonths(monthsPerType());
        this.status = startDate.isBefore(endDate);
    }


    /**
     * Method that returns the number of months for a type of membership.
     * @return the number of months for a type of membership.
     */
    private int monthsPerType(){
        MembershipType memb = getType();
        if(memb == MembershipType.MONTHLY){
            return 1;
        } else if(memb == MembershipType.QUARTERLY){
            return 3;
        } else if(memb == MembershipType.ANNUALLY){
            return 12;
        } else {
            return 0;
        }
    }

    //This method is only for testing purposes
    /**
     * Sets the end date of the membership.
     * @param date the end date of the membership.
     */
    public void setEndDate (LocalDate date){
        this.endDate = date;
    }


    //Getters and Setters

    /**
     * Gets cost of the membership.
     * @return cost of the membership
     */
    public int getCost() {
        return cost;
    }

    /**
     * Sets new cost of the membership.
     * @param cost the membership cost.
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Gets the date in which the membership starts.
     * @return date in which the membership starts
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Gets the date in which the membership ends.
     * @return the date in which the membership ends
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Checks for the status of the membership.
     * @return the membership status.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Update the status of the membership
     */
    public void updateStatus(){
        this.status = LocalDate.now().isBefore(endDate);
    }

    /**
     * Gets the user.
     * @return returns theUser of the membership.
     */
    public User getTheUser() {
        return theUser;
    }

    /**
     * Sets the user of the membership.
     * @param theUser the user of the membership.
     */
    public void setTheUser(User theUser) {
        this.theUser = theUser;
    }

    /**
     * Gets the membership plan.
     * @return returns the membership plan.
     */
    public MembershipPlan getPlan() {
        return plan;
    }

    /**
     * Sets the plan of the membership.
     * @param plan the plan of the membership.
     */
    public void setPlan(MembershipPlan plan) {
        this.plan = plan;
    }

    /**
     * Gets the membership type.
     * @return returns the membership type.
     */
    public MembershipType getType() {
        return type;
    }

    /**
     * Sets the membership type.
     * @param type the membership type.
     */
    public void setType(MembershipType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        this.status = startDate.isBefore(endDate);
        return "Membership: " +
                "Plan:" + plan +
                "\nTipo: " + type +
                "\nFecha de Inicio: " + startDate +
                "\nFecha de Fin: " + endDate;
    }


}
