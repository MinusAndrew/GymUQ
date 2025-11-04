package uniquindio.edu.co.model;

import uniquindio.edu.co.model.enums.MembershipPlan;
import uniquindio.edu.co.model.enums.MembershipType;

import java.time.LocalDate;

public class Membership {

    //Attributes
    private int cost;
    private final LocalDate startDate;
    private final LocalDate endDate;
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
     * @param startDate of the membership
     * @param endDate of the membership
     * @param status of the membership
     * @param theUser of the membership
     * @param plan of the membership
     * @param type of the membership
     */
    public Membership(int cost, LocalDate startDate, LocalDate endDate, boolean status, User theUser, MembershipPlan plan, MembershipType type) {
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.theUser = theUser;
        this.plan = plan;
        this.type = type;
    }

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
     * Sets the membership status.
     * @param status the status of the membership.
     */
    public void setStatus(boolean status) {
        this.status = status;
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


}
