package Application.UseCases.Users;

import Application.DTO.Users.DTOEmailValidation;
import Application.Ports.Input.Users.ConfirmEmailValidationTokenPort;
import Application.Ports.Output.UserRepository;
import Domain.Entities.Users.User;
import Domain.Exceptions.Exceptions.ValidationFailedException;

public class ConfirmEmailValidationTokenUseCase implements ConfirmEmailValidationTokenPort {

    private final UserRepository repository;

    public ConfirmEmailValidationTokenUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void confirmEmailValidationToken(DTOEmailValidation dtoEmailValidation) {
        User existingUser = repository.getUserByCpf(dtoEmailValidation.cpf())
                .orElseThrow(() -> new ValidationFailedException("Token inválido"));
        existingUser.ValidateEmail(dtoEmailValidation.token());
        repository.saveUser(existingUser);
    }
}
