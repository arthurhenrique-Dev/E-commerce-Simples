package Application.UseCases.Users;

import Application.Ports.Input.Users.DissmissAdminPort;
import Application.Ports.Output.UserRepository;
import Domain.Entities.Users.User;
import Domain.Exceptions.Exceptions.InvalidDataException;
import Domain.ValueObjects.Cpf;

public class DissmissAdminUseCase implements DissmissAdminPort {

    private final UserRepository repository;

    public DissmissAdminUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void dissmissAdmin(Cpf cpf) {
        User dissmissedAdmin = repository.getUserByCpf(cpf)
                .orElseThrow(() -> new InvalidDataException("Usuário inexistente"));
        dissmissedAdmin.DismissAdmin();
        repository.saveUser(dissmissedAdmin);
    }
}
