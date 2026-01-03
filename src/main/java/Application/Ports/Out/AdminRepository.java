package Application.Ports.Out;

import Domain.Entities.Users.Admin;
import Domain.ValueObjects.Cpf;
import Domain.ValueObjects.Email;
import Domain.ValueObjects.Password;
import Domain.ValueObjects.PhoneNumber;

import java.util.List;
import java.util.Optional;

public interface AdminRepository {

    void saveAdmin(Admin admin);
    void updateAdmin(Cpf cpf, Email email, PhoneNumber phoneNumber);
    void updatePassword(Cpf cpf, Password newPassword);
    void deleteAdmin(Cpf cpf);
    List<Admin> getAdmins();
    List<Admin> findAdminsByName(String name);
    Optional<Admin> findAdminByCpf(Cpf cpf);
    Optional<Admin> findAdminByEmail(Email email);
    Optional<Admin> findAdminByPhoneNumber(PhoneNumber phoneNumber);
}
