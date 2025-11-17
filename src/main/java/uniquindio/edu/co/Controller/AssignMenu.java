package uniquindio.edu.co.Controller;

import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.Membership;
import uniquindio.edu.co.model.User;
import uniquindio.edu.co.model.enums.MembershipPlan;
import uniquindio.edu.co.model.enums.MembershipType;

public class AssignMenu {
    private Gym theGym;


    public void assignMembershipToUser(int personalId, MembershipPlan plan, MembershipType type){
        User user = theGym.searchUserByPersonalId(personalId);
        //10 for now
        Membership membership = new Membership(10, user, plan, type);
        user.setTheMembership(membership);
        theGym.registerMembership(membership);
    }


    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }
}
