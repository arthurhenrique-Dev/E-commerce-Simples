package Application.UseCases.Users;

import Application.DTO.Users.DTOUpdateUser;
import Application.Ports.Input.Users.UpdateUserPort;
import Application.Ports.Output.UserRepository;
import Domain.Entities.Users.User;
import Domain.Exceptions.Exceptions.InvalidDataException;

public class UpdateUserUseCase implements UpdateUserPort {

    private final UserRepository repository;

    public UpdateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void updateUser(DTOUpdateUser dtoUpdateUser) {
        User user = repository.getUserByCpf(dtoUpdateUser.cpf())
                .orElseThrow(() -> new InvalidDataException("Usuario nao encontrado"));
        user.UpdateUser(dtoUpdateUser.email(), dtoUpdateUser.phoneNumber(), dtoUpdateUser.address());
        repository.saveUser(user);
    }
}
