package Application.DTO.Users;

import Domain.ValueObjects.CartItem;
import Domain.ValueObjects.Cpf;

public record DTOAddCartItem(

        Cpf cpf,
        CartItem cartItem
) {
}
