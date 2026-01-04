package Application.UseCases.Users;

import Application.Ports.Input.Users.UpdatePasswordUserPort;
import Application.Ports.Output.UserRepository;
import Domain.Entities.Users.User;
import Domain.Exceptions.Exceptions.InvalidDataException;
import Application.Ports.Output.EmailService;
import Domain.ValueObjects.Cpf;

public class UpdatePasswordUserUseCase implements UpdatePasswordUserPort {

    private final UserRepository repository;
    private final EmailService service;

    public UpdatePasswordUserUseCase(UserRepository repository, EmailService service) {
        this.repository = repository;
        this.service = service;
    }


    @Override
    public void updatePassword(Cpf cpf) {
        User existingUser = repository.getUserByCpf(cpf)
                .orElseThrow(() -> new InvalidDataException("Usuario nao encontrado"));
        existingUser.StartChangePassword();
        repository.saveUser(existingUser);
        service.ChangePassword(existingUser.getEmail(), existingUser.getPasswordUpdater().token());
    }
}
