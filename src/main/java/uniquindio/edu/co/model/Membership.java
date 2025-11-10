package uniquindio.edu.co.model;

import uniquindio.edu.co.model.enums.MembershipPlan;
import uniquindio.edu.co.model.enums.MembershipType;

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


    int monthsPerType(){
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


    public void setEndDate (LocalDate date){
        this.endDate = date;
    }


    /**
     * Gets cost of the membership.
     * @return cost of the membership
     */
    public int getCost() {
        this.status = startDate.isBefore(endDate);
        return cost;
    }


    /**
     * Sets new cost of the membership.
     * @param cost the membership cost.
     */
    public void setCost(int cost) {
        this.status = startDate.isBefore(endDate);
        this.cost = cost;
    }


    /**
     * Gets the date in which the membership starts.
     * @return date in which the membership starts
     */
    public LocalDate getStartDate() {
        this.status = startDate.isBefore(endDate);
        return startDate;
    }

    /**
     * Gets the date in which the membership ends.
     * @return the date in which the membership ends
     */
    public LocalDate getEndDate() {
        this.status = startDate.isBefore(endDate);
        return endDate;
    }


    /**
     * Checks for the status of the membership.
     * @return the membership status.
     */
    public boolean isStatus() {
        this.status = startDate.isBefore(endDate);
        return status;
    }


    /**
     * Gets the user.
     * @return returns theUser of the membership.
     */
    public User getTheUser() {
        this.status = startDate.isBefore(endDate);
        return theUser;
    }


    /**
     * Sets the user of the membership.
     * @param theUser the user of the membership.
     */
    public void setTheUser(User theUser) {
        this.theUser = theUser;
        this.status = startDate.isBefore(endDate);
    }


    /**
     * Gets the membership plan.
     * @return returns the membership plan.
     */
    public MembershipPlan getPlan() {
        this.status = startDate.isBefore(endDate);
        return plan;
    }


    /**
     * Sets the plan of the membership.
     * @param plan the plan of the membership.
     */
    public void setPlan(MembershipPlan plan) {
        this.plan = plan;
        this.status = startDate.isBefore(endDate);
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
        this.status = startDate.isBefore(endDate);
    }

    @Override
    public String toString() {
        this.status = startDate.isBefore(endDate);
        return "Membership{" +
                "cost=" + cost +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", theUser=" + theUser +
                ", plan=" + plan +
                ", type=" + type +
                '}';
    }


}
