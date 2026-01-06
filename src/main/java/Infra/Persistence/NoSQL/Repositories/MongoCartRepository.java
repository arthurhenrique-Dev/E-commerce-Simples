package Infra.Persistence.NoSQL.Repositories;

import Infra.Persistence.NoSQL.Models.CartEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoCartRepository extends MongoRepository<CartEntity, String> {
}
