package Application.Mappers;

import Application.DTOs.Users.DTOReturnUser;
import Application.DTOs.Users.DTOSaveUser;
import Application.DTOs.Users.DTOSignInMaster;
import Domain.Entities.Users.*;

import java.util.List;

public class UserMapper {

    public DTOReturnUser toDTOReturnUser(User user) {
        DTOReturnUser dtoReturnUser = new DTOReturnUser(
                user.getCpf(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress()
        );
        return dtoReturnUser;
    }

    public User registerUser(DTOSaveUser dtoSaveUser) {
        User user = new User(
                dtoSaveUser.cpf(),
                dtoSaveUser.name(),
                dtoSaveUser.password(),
                dtoSaveUser.email(),
                dtoSaveUser.address(),
                dtoSaveUser.phoneNumber(),
                Role.COMUM
        );
        return user;
    }

    public User registerAdmin(DTOSaveUser dtoSaveUser) {
        User admin = new User(
                dtoSaveUser.cpf(),
                dtoSaveUser.name(),
                dtoSaveUser.password(),
                dtoSaveUser.email(),
                dtoSaveUser.address(),
                dtoSaveUser.phoneNumber(),
                Role.ADMIN
        );
        return admin;
    }

    public Master registerMaster(DTOSignInMaster dtoSignInMaster) {
        Master master = new Master(
                dtoSignInMaster.cpf(),
                dtoSignInMaster.name(),
                dtoSignInMaster.plainPassword(),
                dtoSignInMaster.email(),
                dtoSignInMaster.phoneNumber()
        );
        return master;
    }

    public List<DTOReturnUser> toDTOReturnUser(List<User> users) {
        return users.stream().map(this::toDTOReturnUser).toList();
    }
}
