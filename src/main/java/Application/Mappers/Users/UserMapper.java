package Application.Mappers.Users;

import Application.DTO.Users.DTOReturnUser;
import Application.DTO.Users.DTOSaveUser;
import Domain.Entities.Users.Status;
import Domain.Entities.Users.User;

import java.util.List;

public class UserMapper {

    public DTOReturnUser toDTOReturnUser(User user) {
        DTOReturnUser dtoReturnUser = new DTOReturnUser(
            user.getCpf(),
            user.getName(),
            user.getEmail(),
            user.getPhoneNumber(),
            user.getAddress(),
            user.getCart()
        );
        return dtoReturnUser;
    }
    public User register(DTOSaveUser dtoSaveUser) {
        User user = new User(
            dtoSaveUser.cpf(),
            dtoSaveUser.name(),
            dtoSaveUser.password(),
            dtoSaveUser.email(),
            dtoSaveUser.address(),
            dtoSaveUser.phoneNumber(),
            Status.VALIDATING
        );
        return user;
    }
    public List<DTOReturnUser> toDTOReturnUser(List<User> users) {
        return users.stream().map(this::toDTOReturnUser).toList();
    }
}
