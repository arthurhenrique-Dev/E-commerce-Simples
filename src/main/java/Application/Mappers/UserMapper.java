package Application.Mappers;

import Application.DTOs.Users.DTOReturnCepService;
import Application.DTOs.Users.DTOReturnUser;
import Application.DTOs.Users.DTOSaveUser;
import Application.DTOs.Users.DTOSignInMaster;
import Application.Ports.Output.CepService;
import Domain.Entities.Users.*;
import Domain.ValueObjects.Address;

import java.util.List;

public class UserMapper {

    private final CepService service;

    public UserMapper(CepService service) {
        this.service = service;
    }

    public DTOReturnUser toDTOReturnUser(User user) {
        DTOReturnUser dtoReturnUser = new DTOReturnUser(
                user.getCpf(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress()
        );
        return dtoReturnUser;
    }

    public User registerUser(DTOSaveUser dtoSaveUser) {
        DTOReturnCepService dtoReturnCepService = service.getAddressByCep(dtoSaveUser.address().cep());
        Address address = new Address(
                dtoSaveUser.address().cep(),
                dtoReturnCepService.rua(),
                dtoReturnCepService.bairro(),
                dtoReturnCepService.cidade(),
                dtoReturnCepService.estado(),
                dtoSaveUser.address().complemento(),
                dtoSaveUser.address().numero()
        );

        User user = new User(
                dtoSaveUser.cpf(),
                dtoSaveUser.name(),
                dtoSaveUser.password(),
                dtoSaveUser.email(),
                address,
                dtoSaveUser.phoneNumber(),
                Role.COMUM
        );
        return user;
    }

    public User registerAdmin(DTOSaveUser dtoSaveUser) {
        DTOReturnCepService dtoReturnCepService = service.getAddressByCep(dtoSaveUser.address().cep());
        Address address = new Address(
                dtoSaveUser.address().cep(),
                dtoReturnCepService.rua(),
                dtoReturnCepService.bairro(),
                dtoReturnCepService.cidade(),
                dtoReturnCepService.estado(),
                dtoSaveUser.address().complemento(),
                dtoSaveUser.address().numero()
        );

        User admin = new User(
                dtoSaveUser.cpf(),
                dtoSaveUser.name(),
                dtoSaveUser.password(),
                dtoSaveUser.email(),
                address,
                dtoSaveUser.phoneNumber(),
                Role.ADMIN
        );
        return admin;
    }

    public Master registerMaster(DTOSignInMaster dtoSignInMaster) {
        Master master = new Master(
                dtoSignInMaster.cpf(),
                dtoSignInMaster.name(),
                dtoSignInMaster.plainPassword(),
                dtoSignInMaster.email(),
                dtoSignInMaster.phoneNumber()
        );
        return master;
    }

    public List<DTOReturnUser> toDTOReturnUser(List<User> users) {
        return users.stream().map(this::toDTOReturnUser).toList();
    }
}
