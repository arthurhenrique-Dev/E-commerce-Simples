package Application.Ports.Input.Users;

import Application.DTO.Users.DTOUpdatePasswordUser;

public interface ConfirmPasswordTokenPort {

    void confirmToken(DTOUpdatePasswordUser dtoUpdatePasswordUser);
}
