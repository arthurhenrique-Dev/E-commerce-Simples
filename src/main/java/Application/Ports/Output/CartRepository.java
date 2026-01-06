package Application.Ports.Output;

import Domain.Entities.Users.Cart;
import Domain.ValueObjects.Cpf;

import java.util.Optional;

public interface CartRepository {

    void saveCart(Cart cart);
    Optional<Cart> getCart(Cpf cpf);
}
