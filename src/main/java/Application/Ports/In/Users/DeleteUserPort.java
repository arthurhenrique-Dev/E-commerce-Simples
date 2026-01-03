package Application.Ports.In.Users;

import Domain.ValueObjects.Cpf;

public interface DeleteUserPort {

    void deleteUserByCpf(Cpf cpf);
}
