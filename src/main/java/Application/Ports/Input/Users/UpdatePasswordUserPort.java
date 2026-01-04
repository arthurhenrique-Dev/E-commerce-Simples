package Application.Ports.Input.Users;

import Domain.ValueObjects.Cpf;

public interface UpdatePasswordUserPort {

    void updatePassword(Cpf cpf);
}
