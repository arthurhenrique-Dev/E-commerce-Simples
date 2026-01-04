package Application.Ports.Input.Users;

import Domain.ValueObjects.Cpf;

public interface ReactivateUserPort {

    void reactivateUser(Cpf cpf);
}
