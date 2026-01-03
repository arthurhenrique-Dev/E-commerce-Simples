package Application.Ports.Out;

import Application.DTO.Users.DTOUpdatePasswordUser;
import Application.DTO.Users.DTOUpdateUser;
import Domain.Entities.Users.Cart;
import Domain.Entities.Users.User;
import Domain.ValueObjects.*;

import java.util.List;

public interface UserRepository {

    void saveUser(User user);
    void updateUser(DTOUpdateUser dtoUpdateUser);
    void updatePassword(DTOUpdatePasswordUser dtoUpdatePasswordUser);
    void deleteUser(Cpf cpf);
    void manageCart(Cpf cpf, Cart cart);
    List<User> findAllUsers();
    List<User> findUsersByName(Name name);
    List<User> findUserByCpf(Cpf cpf);
    List<User> findUserByEmail(Email email);
    List<User> findUserByPhoneNumber(PhoneNumber phoneNumber);
}
