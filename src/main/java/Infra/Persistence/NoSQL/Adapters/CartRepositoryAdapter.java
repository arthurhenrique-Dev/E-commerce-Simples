package Infra.Persistence.NoSQL.Adapters;

import Application.Ports.Output.CartRepository;
import Domain.Entities.Users.Cart;
import Domain.Exceptions.Exceptions.DatabaseFailedException;
import Domain.ValueObjects.Cpf;
import Infra.Persistence.NoSQL.Mappers.Mapper;
import Infra.Persistence.NoSQL.Models.CartEntity;
import Infra.Persistence.NoSQL.Repositories.MongoCartRepository;

import java.util.Optional;

public class CartRepositoryAdapter implements CartRepository {

    private final MongoCartRepository repository;
    private final Mapper mapper;

    public CartRepositoryAdapter(MongoCartRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void saveCart(Cart cart) {
        try {
            CartEntity cartEntity = mapper.toEntity(cart);
            repository.save(cartEntity);
        } catch (Exception e) {
            throw new DatabaseFailedException();
        }

    }

    @Override
    public Optional<Cart> getCart(Cpf cpf) {
        try {
            return repository.findById(cpf.cpf())
                    .map(mapper::toDomain);
        } catch (Exception e) {
            throw new DatabaseFailedException();
        }
    }
}
