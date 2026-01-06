package Application.Ports.Input.User;

import Application.DTOs.Users.DTOSignInMaster;

public interface AddMasterPort {

    void saveMaster(DTOSignInMaster master);
}
