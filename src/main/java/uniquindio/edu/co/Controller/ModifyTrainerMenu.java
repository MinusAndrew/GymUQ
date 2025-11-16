package uniquindio.edu.co.Controller;

import uniquindio.edu.co.model.Gym;
import uniquindio.edu.co.model.staffs.Trainer;

public class ModifyTrainerMenu {
    private Gym theGym;

    public void setTrainerName(String name, Trainer trainer){
        trainer.setName(name);
    }

    public void setTrainerLastName(String lastName, Trainer trainer){
        trainer.setLastName(lastName);
    }

    public void setTrainerAge(int age, Trainer trainer){
        trainer.setAge(age);
    }

    public void setTrainerPersonalId(int trainerPersonalId, Trainer trainer){
        trainer.setPersonalId(trainerPersonalId);
    }

    public void setTrainerPhoneNumber(String trainerPhoneNumber, Trainer trainer){
        trainer.setPhoneNumber(trainerPhoneNumber);
    }

    public void removeTrainerFromGym(Trainer trainer){
        theGym.removeTrainer(trainer);
        theGym.removeStaff(trainer);
    }

    public void setTheGym(Gym theGym) {
        this.theGym = theGym;
    }
}
