package Application.UseCases.User;

import Application.DTOs.Users.DTORemoveCartItem;
import Application.Ports.Input.User.RemoveCartItemPort;
import Application.Ports.Output.CartRepository;
import Application.Ports.Output.UserRepository;
import Domain.Entities.Users.Cart;
import Domain.Entities.Users.User;
import Domain.Exceptions.Exceptions.ValidationFailedException;

public class RemoveCartItemUseCase implements RemoveCartItemPort {

    private final CartRepository repository;

    public RemoveCartItemUseCase(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public void removeCartItem(DTORemoveCartItem dtoRemoveCartItem) {
        Cart cart = repository.getCart(dtoRemoveCartItem.cpf())
                .orElseThrow(() -> new ValidationFailedException("Usuário fora de sessão"));
        cart.removeCartItem(dtoRemoveCartItem.idxItem());
        repository.saveCart(cart);
    }
}
