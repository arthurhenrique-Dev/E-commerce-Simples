package Application.Ports.Input.Users;

import Application.DTO.Users.DTOReturnUser;
import Application.DTO.Users.DTOSearchUser;

import java.util.List;

public interface SearchUserPort {

    List<DTOReturnUser> searchUsers(DTOSearchUser dtoSearchUser);
}
