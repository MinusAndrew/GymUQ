package uniquindio.edu.co.model;

import uniquindio.edu.co.model.enums.MembershipPlan;
import uniquindio.edu.co.model.enums.MembershipType;

public class Membership {

    //Attributes
    private int cost;
    private String startDate;
    private String endDate;
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
    public Membership(int cost, String startDate, String endDate, boolean status, User theUser, MembershipPlan plan, MembershipType type) {
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.theUser = theUser;
        this.plan = plan;
        this.type = type;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getTheUser() {
        return theUser;
    }

    public void setTheUser(User theUser) {
        this.theUser = theUser;
    }

    public MembershipPlan getPlan() {
        return plan;
    }

    public void setPlan(MembershipPlan plan) {
        this.plan = plan;
    }

    public MembershipType getType() {
        return type;
    }

    public void setType(MembershipType type) {
        this.type = type;
    }


}
