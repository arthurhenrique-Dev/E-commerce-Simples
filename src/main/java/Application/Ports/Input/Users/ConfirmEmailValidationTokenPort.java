package Application.Ports.Input.Users;

import Application.DTO.Users.DTOEmailValidation;

public interface ConfirmEmailValidationTokenPort {

    void confirmEmailValidationToken(DTOEmailValidation dtoEmailValidation);
}
