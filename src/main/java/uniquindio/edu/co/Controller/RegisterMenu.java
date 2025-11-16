package uniquindio.edu.co.Controller;


import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.Staff;
import uniquindio.edu.co.model.User;

public class RegisterMenu {
    private Gym theGym;

    public void registerUser(User user){
        theGym.registerUser(user);
    }

    public void registerStaff(Staff staff) { theGym.registerStaff(staff); }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }
}
