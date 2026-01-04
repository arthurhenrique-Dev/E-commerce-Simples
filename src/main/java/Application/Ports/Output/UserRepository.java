package Application.Ports.Output;

import Application.DTO.Users.DTOSearchUser;
import Application.DTO.Users.DTOUpdatePasswordUser;
import Application.DTO.Users.DTOUpdateUser;
import Domain.Entities.Users.Cart;
import Domain.Entities.Users.User;
import Domain.ValueObjects.*;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void saveUser(User user);
    List<User> searchUsers(DTOSearchUser dtoSearchUser);
    Optional<User> getUserByCpf(Cpf cpf);
}
