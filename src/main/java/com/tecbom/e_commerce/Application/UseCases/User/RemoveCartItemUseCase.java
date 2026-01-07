package com.tecbom.e_commerce.Application.UseCases.User;

import com.tecbom.e_commerce.Application.DTOs.Users.DTORemoveCartItem;
import com.tecbom.e_commerce.Application.Ports.Input.User.RemoveCartItemPort;
import com.tecbom.e_commerce.Application.Ports.Output.CartRepository;
import com.tecbom.e_commerce.Domain.Entities.Users.Cart;
import com.tecbom.e_commerce.Domain.Exceptions.Exceptions.ValidationFailedException;

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
