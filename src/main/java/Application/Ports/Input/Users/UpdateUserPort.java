package Application.Ports.Input.Users;

import Application.DTO.Users.DTOUpdateUser;

public interface UpdateUserPort {

    void updateUser(DTOUpdateUser dtoUpdateUser);
}
