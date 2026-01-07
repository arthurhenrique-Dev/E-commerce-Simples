package Infra.Adapters.Output.Persistence.NoSQL.Repositories;

import Infra.Adapters.Output.Persistence.NoSQL.Models.CartEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoCartRepository extends MongoRepository<CartEntity, String> {
}
