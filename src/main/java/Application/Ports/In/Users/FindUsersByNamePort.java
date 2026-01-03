package Application.Ports.In.Users;

import Application.DTO.Users.DTOReturnUser;
import Domain.ValueObjects.Name;

import java.util.List;

public interface FindUsersByNamePort {

    List<DTOReturnUser> findUsersByName(Name name);
}
