package Application.Ports.Input.Users;

import Domain.ValueObjects.Cpf;

public interface DeleteUserPort {

    void deleteUserByCpf(Cpf cpf);
}
