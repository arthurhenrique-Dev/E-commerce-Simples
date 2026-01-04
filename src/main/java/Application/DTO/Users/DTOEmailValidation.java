package Application.DTO.Users;

import Domain.ValueObjects.Cpf;

public record DTOEmailValidation(

        Cpf cpf,
        String token
) {
}
