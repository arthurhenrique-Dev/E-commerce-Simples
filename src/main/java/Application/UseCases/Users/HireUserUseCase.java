package Application.UseCases.Users;

import Application.Ports.Input.Users.HireUserPort;
import Application.Ports.Output.UserRepository;
import Domain.Entities.Users.User;
import Domain.Exceptions.Exceptions.InvalidDataException;
import Domain.ValueObjects.Cpf;

public class HireUserUseCase implements HireUserPort {

    private final UserRepository repository;

    public HireUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void hireUser(Cpf cpf) {
        User hiredUser = repository.getUserByCpf(cpf)
                .orElseThrow(() -> new InvalidDataException("Usuario inexistente"));
        hiredUser.HireUser();
        repository.saveUser(hiredUser);
    }
}
