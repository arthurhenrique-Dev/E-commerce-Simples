package Application.Ports.In.Users;

import Application.DTO.Users.DTOReturnUser;

import java.util.List;

public interface FindAllUsersPort {

    List<DTOReturnUser> findAllUsers();
}
