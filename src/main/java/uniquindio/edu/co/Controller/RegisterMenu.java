package uniquindio.edu.co.Controller;


import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.Session;
import uniquindio.edu.co.model.Staff;
import uniquindio.edu.co.model.User;
import uniquindio.edu.co.model.staffs.Trainer;

public class RegisterMenu {
    private Gym theGym;

    public void registerUser(User user){
        theGym.registerUser(user);
    }

    public void registerStaff(Staff staff) { theGym.registerStaff(staff); }

    public void registerTrainer(Trainer trainer) {
        theGym.registerStaff(trainer);
        theGym.registerTrainer(trainer);
    }

    public void registerSession(Session session){
        theGym.registerSession(session);
    }

    public void registerSessionToTrainer(Trainer trainer, Session session){
        trainer.addSessionToTrainer(session);
    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }
}
