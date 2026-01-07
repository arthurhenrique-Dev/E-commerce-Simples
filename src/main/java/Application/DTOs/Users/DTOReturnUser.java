package Application.DTOs.Users;

import Domain.ValueObjects.*;

public record DTOReturnUser(

        Cpf cpf,
        Name name,
        EmailVO email,
        PhoneNumber phoneNumber,
        Address address
) {
}
