package Application.UseCases.User;

import Application.Ports.Input.User.GetCartPort;
import Application.Ports.Output.CartRepository;
import Domain.Entities.Users.Cart;
import Domain.Exceptions.Exceptions.UserNotFoundException;
import Domain.ValueObjects.Cpf;

public class GetCartUseCase implements GetCartPort {

    private final CartRepository repository;

    public GetCartUseCase(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cart getCart(Cpf cpf) {
        return repository.getCart(cpf)
                .orElseThrow(() -> new UserNotFoundException());
    }
}
