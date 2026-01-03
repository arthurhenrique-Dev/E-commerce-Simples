package Application.Ports.In.Users;

import Application.DTO.Users.DTOUpdateUser;

public interface UpdateUserPort {

    void updateUser(DTOUpdateUser dtoUpdateUser);
}
