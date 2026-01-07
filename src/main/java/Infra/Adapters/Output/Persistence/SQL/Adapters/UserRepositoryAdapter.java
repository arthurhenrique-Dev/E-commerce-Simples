package Infra.Adapters.Output.Persistence.SQL.Adapters;

import Application.DTOs.Users.DTOSearchUser;
import Application.Ports.Output.UserRepository;
import Domain.Entities.Users.User;
import Domain.Exceptions.Exceptions.DatabaseFailedException;
import Domain.ValueObjects.Cpf;
import Infra.Adapters.Output.Persistence.SQL.Mappers.Mapper;
import Infra.Adapters.Output.Persistence.SQL.Models.UserEntity;
import Infra.Adapters.Output.Persistence.SQL.Repositories.JpaUserRepository;
import Infra.Security.Service.CryptographyService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository frameworkRepository;
    private final Mapper mapper;

    public UserRepositoryAdapter(JpaUserRepository frameworkRepository, Mapper mapper) {
        this.frameworkRepository = frameworkRepository;
        this.mapper = mapper;
    }

    private EncryptedSearchFilters encryptFilters(DTOSearchUser dto) {
        return new EncryptedSearchFilters(
                (dto.cpf() != null) ? CryptographyService.encrypt(dto.cpf().toString()) : null,
                (dto.name() != null) ? CryptographyService.encrypt(dto.name().toString()) : null,
                (dto.email() != null) ? CryptographyService.encrypt(dto.email().toString()) : null,
                (dto.phoneNumber() != null) ? CryptographyService.encrypt(dto.phoneNumber().toString()) : null
        );
    }

    @Override
    public void saveUser(User user) {
        try {
            UserEntity userEntity = mapper.toDbModel(user);
            frameworkRepository.save(userEntity);
        } catch (Exception e) {
            throw new DatabaseFailedException();
        }

    }

    @Override
    public List<User> searchUsers(DTOSearchUser dtoSearchUser) {
        try {
            EncryptedSearchFilters filters = encryptFilters(dtoSearchUser);

            List<UserEntity> entities = frameworkRepository.searchUsers(filters.cpf(), filters.name(), filters.email(), filters.phone());

            return entities.stream()
                    .map(mapper::toDomain)
                    .toList();
        } catch (Exception e) {
            throw new DatabaseFailedException();
        }
    }

    @Override
    public Optional<User> getUserByCpf(Cpf cpf) {
        try {
            String cpfCrypt = CryptographyService.encrypt(cpf.toString());
            return frameworkRepository.getUserByCpf(cpfCrypt)
                    .map(mapper::toDomain);
        } catch (Exception e) {
            throw new DatabaseFailedException();
        }
    }

    @Override
    public List<User> searchAdmins(DTOSearchUser dtoSearchUser) {
        try {
            EncryptedSearchFilters filters = encryptFilters(dtoSearchUser);

            List<UserEntity> entities = frameworkRepository.searchAdmins(filters.cpf(), filters.name(), filters.email(), filters.phone());

            return entities.stream()
                    .map(mapper::toDomain)
                    .toList();
        } catch (Exception e) {
            throw new DatabaseFailedException();
        }
    }

    private record EncryptedSearchFilters(
            String cpf,
            String name,
            String email,
            String phone
    ) {
    }
}
