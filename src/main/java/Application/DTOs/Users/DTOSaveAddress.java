package Application.DTOs.Users;

import Domain.ValueObjects.Cep;
import Domain.ValueObjects.ValidText;

public record DTOSaveAddress(

        Cep cep,
        ValidText numero,
        String complemento
) {
}
