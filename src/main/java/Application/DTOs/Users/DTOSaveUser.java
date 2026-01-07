package Application.DTOs.Users;

import Domain.ValueObjects.*;

public record DTOSaveUser(

        Cpf cpf,
        Name name,
        Password password,
        EmailVO email,
        DTOSaveAddress address,
        PhoneNumber phoneNumber
) {
}
