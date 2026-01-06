package Application.Ports.Input.User;

import Domain.ValueObjects.Cpf;

public interface DeleteMasterPort {

    void deleteMasterUser(Cpf cpf);
}
