package Application.DTOs.Users;

import Domain.ValueObjects.*;

public record DTOSignInMaster(

        Cpf cpf,
        Name name,
        Password plainPassword,
        EmailVO email,
        PhoneNumber phoneNumber
) {
}
