package Application.Ports.Input.Users;

import Domain.ValueObjects.Cpf;

public interface DissmissAdminPort {

    void dissmissAdmin(Cpf cpf);
}
