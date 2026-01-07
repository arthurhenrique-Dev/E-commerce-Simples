package Application.DTOs.Users;

import Domain.ValueObjects.Cpf;
import Domain.ValueObjects.EmailVO;
import Domain.ValueObjects.Name;
import Domain.ValueObjects.PhoneNumber;

public record DTOSearchUser(

        Cpf cpf,
        Name name,
        EmailVO email,
        PhoneNumber phoneNumber
) {
}
