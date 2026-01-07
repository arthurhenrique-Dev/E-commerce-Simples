package Infra.Adapters.Output.Persistence.NoSQL.Repositories;

import Infra.Adapters.Output.Persistence.NoSQL.Models.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MongoProductRepository extends MongoRepository<ProductEntity, UUID> {
}
