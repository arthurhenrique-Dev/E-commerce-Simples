package Application.UseCases.User;

import Application.DTOs.Users.DTOAddCartItem;
import Application.Ports.Input.User.AddCartItemPort;
import Application.Ports.Output.CartRepository;
import Application.Ports.Output.UserRepository;
import Domain.Entities.Users.Cart;
import Domain.Entities.Users.User;
import Domain.Exceptions.Exceptions.UserNotFoundException;

public class AddCartItemUseCase implements AddCartItemPort {

    private final CartRepository repository;

    public AddCartItemUseCase(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addCartItem(DTOAddCartItem dtoAddCartItem) {
        Cart cart = repository.getCart(dtoAddCartItem.cpf())
                .orElseThrow(() -> new UserNotFoundException());
        cart.addCartItem(dtoAddCartItem.cartItem());
        repository.saveCart(cart);
    }
}
