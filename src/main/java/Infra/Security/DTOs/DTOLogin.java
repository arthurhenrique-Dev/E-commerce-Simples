package Infra.Security.DTOs;

import jakarta.validation.constraints.NotEmpty;

public record DTOLogin(

        @NotEmpty (message = "Insira seu cpf")String cpf,
        @NotEmpty (message = "Insira sua senha")String password
) {
}
