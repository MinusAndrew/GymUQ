package uniquindio.edu.co.gymuq.model;

public class Membership {
    private int cost;
    private String startDate;
    private String endDate;
    boolean status;

    // Aggregation Relationship
    private User theUser;

    /**
     *
     * @param cost of the membership
     * @param startDate of the membership
     * @param endDate of the membership
     * @param status of the membership
     */

    public Membership(int cost, String startDate, String endDate, boolean status) {
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
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
}
