package Application.Ports.Output;

import Application.DTO.Users.DTOSearchUser;
import Application.DTO.Users.DTOUpdatePasswordUser;
import Application.DTO.Users.DTOUpdateUser;
import Domain.Entities.Users.Admin;
import Domain.Entities.Users.User;
import Domain.ValueObjects.Cpf;

import java.util.List;
import java.util.Optional;

public interface AdminRepository {

    void saveAdmin(Admin admin);
    void updateAdmin(DTOUpdateUser dtoUpdateUser);
    void updatePassword(DTOUpdatePasswordUser dtoUpdatePasswordUser);
    List<User> searchAdmins(DTOSearchUser dtoSearchUser);
    Optional<User> getAdminByCpf(Cpf cpf);
}
