package Infra.Persistence.SQL.Adapters;

import Application.DTOs.Users.DTOSearchUser;
import Application.Ports.Output.UserRepository;
import Domain.Entities.Users.User;
import Domain.ValueObjects.Cpf;
import Infra.Persistence.SQL.Mappers.Mapper;
import Infra.Persistence.SQL.Models.UserEntity;
import Infra.Persistence.SQL.Repositories.JpaUserRepository;
import Infra.Security.Service.CryptographyService;

import java.util.List;
import java.util.Optional;

public class UserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository frameworkRepository;
    private final Mapper mapper;

    public UserRepositoryAdapter(JpaUserRepository frameworkRepository, Mapper mapper) {
        this.frameworkRepository = frameworkRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveUser(User user) {
        UserEntity userEntity = mapper.toDbModel(user);
        frameworkRepository.save(userEntity);
    }

    @Override
    public List<User> searchUsers(DTOSearchUser dtoSearchUser) {
        String cpfCrypt = (dtoSearchUser.cpf() != null) ? CryptographyService.encrypt(dtoSearchUser.cpf().toString()) : null;
        String nameCrypt = (dtoSearchUser.name() != null) ? CryptographyService.encrypt(dtoSearchUser.name().toString()) : null;
        String emailCrypt = (dtoSearchUser.email() != null) ? CryptographyService.encrypt(dtoSearchUser.email().toString()) : null;
        String phoneNumberCrypt = (dtoSearchUser.phoneNumber() != null) ? CryptographyService.encrypt(dtoSearchUser.phoneNumber().toString()) : null;

        List<UserEntity> entities = frameworkRepository.searchUsers(cpfCrypt, nameCrypt, emailCrypt, phoneNumberCrypt);

        return entities.stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<User> getUserByCpf(Cpf cpf) {
        String cpfCrypt = CryptographyService.encrypt(cpf.toString());
        return frameworkRepository.getUserByCpf(cpfCrypt)
                .map(mapper::toDomain);
    }

    @Override
    public List<User> searchAdmins(DTOSearchUser dtoSearchUser) {
        String cpfCrypt = (dtoSearchUser.cpf() != null) ? CryptographyService.encrypt(dtoSearchUser.cpf().toString()) : null;
        String nameCrypt = (dtoSearchUser.name() != null) ? CryptographyService.encrypt(dtoSearchUser.name().toString()) : null;
        String emailCrypt = (dtoSearchUser.email() != null) ? CryptographyService.encrypt(dtoSearchUser.email().toString()) : null;
        String phoneNumberCrypt = (dtoSearchUser.phoneNumber() != null) ? CryptographyService.encrypt(dtoSearchUser.phoneNumber().toString()) : null;

        List<UserEntity> entities = frameworkRepository.searchUsers(cpfCrypt, nameCrypt, emailCrypt, phoneNumberCrypt);

        return entities.stream()
                .map(mapper::toDomain)
                .toList();
    }
}
