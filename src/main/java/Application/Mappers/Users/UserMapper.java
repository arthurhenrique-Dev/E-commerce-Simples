package Application.Mappers.Users;

import Application.DTO.Users.DTOReturnUser;
import Domain.Entities.Users.User;

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
}
