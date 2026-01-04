package Application.Ports.Output;

import Domain.Entities.Users.Master;
import Domain.ValueObjects.Cpf;
import Domain.ValueObjects.Email;
import Domain.ValueObjects.Password;
import Domain.ValueObjects.PhoneNumber;

import java.util.List;
import java.util.Optional;

public interface MasterRepository {

    void saveMaster(Master master);
    void updateMaster(Cpf cpf, Email email, PhoneNumber phoneNumber);
    void updatePassword(Cpf cpf, Password newPassword);
    List<Master> getMasters();
    List<Master> findMastersByName(String name);
    Optional<Master> findMasterByCpf(Cpf cpf);
    Optional<Master> findMasterByEmail(Email email);
    Optional<Master> findMasterByPhoneNumber(PhoneNumber phoneNumber);
}
