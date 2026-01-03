package Application.Ports.In.Users;

import Application.DTO.Users.DTOReturnUser;
import Domain.ValueObjects.Email;

import java.util.List;

public interface FindUserByEmailPort {

    List<DTOReturnUser> findUserByEmail(Email email);
}
