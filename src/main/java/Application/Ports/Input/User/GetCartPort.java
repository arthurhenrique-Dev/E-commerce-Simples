package Application.Ports.Input.User;

import Domain.Entities.Users.Cart;
import Domain.ValueObjects.Cpf;

import java.util.Optional;

public interface GetCartPort {

    Cart getCart(Cpf cpf);
}
