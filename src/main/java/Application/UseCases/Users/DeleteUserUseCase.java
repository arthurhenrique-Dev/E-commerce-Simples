package Application.UseCases.Users;

import Application.Ports.Input.Users.DeleteUserPort;
import Application.Ports.Output.UserRepository;
import Domain.Entities.Users.Status;
import Domain.Entities.Users.User;
import Domain.Exceptions.Exceptions.InvalidDataException;
import Domain.ValueObjects.Cpf;


public class DeleteUserUseCase implements DeleteUserPort {

    private final UserRepository repository;

    public DeleteUserUseCase(UserRepository repository) {
        this.repository = DeleteUserUseCase.this.repository;
    }

    @Override
    public void deleteUserByCpf(Cpf cpf) {
        User existingUser = repository.getUserByCpf(cpf)
                .orElseThrow(() -> new InvalidDataException("Usuario não encontrado"));
        if (existingUser.getStatus() == Status.ON) {
            existingUser.Deactivate();
            repository.saveUser(existingUser);
        }
        else throw new InvalidDataException("Usuário já inativo");
    }
}
