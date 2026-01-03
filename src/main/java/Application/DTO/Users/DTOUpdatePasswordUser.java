package Application.DTO.Users;

import Domain.ValueObjects.Cpf;
import Domain.ValueObjects.Password;

public record DTOUpdatePasswordUser(

        Cpf cpf,
        Password password
) {
}
