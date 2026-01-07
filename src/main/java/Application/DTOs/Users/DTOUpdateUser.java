package Application.DTOs.Users;

import Domain.ValueObjects.Address;
import Domain.ValueObjects.Cpf;
import Domain.ValueObjects.EmailVO;
import Domain.ValueObjects.PhoneNumber;

public record DTOUpdateUser(

        Cpf cpf,
        EmailVO email,
        PhoneNumber phoneNumber,
        Address address
) {
}
