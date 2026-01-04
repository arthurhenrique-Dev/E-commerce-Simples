package Application.Ports.Input.Users;

import Domain.ValueObjects.Cpf;

public interface HireUserPort {

    void hireUser(Cpf cpf);
}
