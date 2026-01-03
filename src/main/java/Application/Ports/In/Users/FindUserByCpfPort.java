package Application.Ports.In.Users;

import Application.DTO.Users.DTOReturnUser;
import Domain.ValueObjects.Cpf;

import java.util.List;

public interface FindUserByCpfPort {

    List<DTOReturnUser> findUserByCpf(Cpf cpf);
}
