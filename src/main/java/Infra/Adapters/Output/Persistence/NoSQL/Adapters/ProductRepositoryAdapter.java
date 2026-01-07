package Infra.Adapters.Output.Persistence.NoSQL.Adapters;

import Application.DTOs.Products.DTOSearchProduct;
import Application.DTOs.Products.OrderBy;
import Application.Ports.Output.ProductRepository;
import Domain.Entities.Products.Product;
import Domain.Exceptions.Exceptions.DatabaseFailedException;
import Infra.Adapters.Output.Persistence.NoSQL.Models.ProductEntity;
import Infra.Adapters.Output.Persistence.NoSQL.Repositories.MongoProductRepository;
import Infra.Adapters.Output.Persistence.NoSQL.Mappers.Mapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
public class ProductRepositoryAdapter implements ProductRepository {

    private final MongoTemplate mongoTemplate;
    private final MongoProductRepository frameworkRepository;
    private final Mapper mapper;

    public ProductRepositoryAdapter(MongoTemplate mongoTemplate, MongoProductRepository frameworkRepository, Mapper mapper) {
        this.mongoTemplate = mongoTemplate;
        this.frameworkRepository = frameworkRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveProduct(Product product) {
        try {
            ProductEntity productEntity = mapper.toEntity(product);
            frameworkRepository.save(productEntity);
        } catch (Exception ex) {
            throw new DatabaseFailedException();
        }

    }

    private Sort handleOrderBy(OrderBy orderBy) {
        return switch (orderBy) {
            case PRICE_ASC -> Sort.by(Sort.Direction.ASC, "models.price");
            case PRICE_DESC -> Sort.by(Sort.Direction.DESC, "models.price");
            case LATEST -> Sort.by(Sort.Direction.DESC, "createdAt");
            case POPULARITY -> Sort.by(Sort.Direction.DESC, "timesPurchased");
            case RELEVANCE -> Sort.by(Sort.Direction.DESC, "timesViewed");
        };
    }

    @Override
    public List<Product> adminSearchProducts(DTOSearchProduct dtoSearchProduct) {
        try {
            Query query = new Query();

            if (dtoSearchProduct.searchTerm() != null && !dtoSearchProduct.searchTerm().isBlank()) {
                String term = dtoSearchProduct.searchTerm().trim();
                Criteria nameLike = Criteria.where("name").regex(term, "i");

                String uuidRegex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

                if (term.matches(uuidRegex)) {
                    query.addCriteria(new Criteria().orOperator(
                            Criteria.where("id").is(UUID.fromString(term)),
                            nameLike
                    ));
                } else {
                    query.addCriteria(nameLike);
                }
            }

            if (dtoSearchProduct.category() != null) {
                query.addCriteria(Criteria.where("category").is(dtoSearchProduct.category()));
            }

            if (dtoSearchProduct.price() != null) {
                query.addCriteria(Criteria.where("models.price").lte(dtoSearchProduct.price().price().doubleValue()));
            }

            if (dtoSearchProduct.orderBy() != null) {
                query.with(handleOrderBy(dtoSearchProduct.orderBy()));
            }

            List<ProductEntity> entities = mongoTemplate.find(query, ProductEntity.class);
            return entities.stream()
                    .map(mapper::toDomain)
                    .toList();

        } catch (Exception e) {
            throw new DatabaseFailedException();
        }
    }

    @Override
    public List<Product> searchProducts(DTOSearchProduct dtoSearchProduct) {
        return List.of();
    }

    @Override
    public Optional<Product> checkProductById(UUID id) {
        return Optional.empty();
    }
}
