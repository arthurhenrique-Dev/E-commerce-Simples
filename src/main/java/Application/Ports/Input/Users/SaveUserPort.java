package Application.Ports.Input.Users;

import Application.DTO.Users.DTOSaveUser;

public interface SaveUserPort {

    void saveUser(DTOSaveUser dtoSaveUser);
}
