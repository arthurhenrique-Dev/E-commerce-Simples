package com.tecbom.e_commerce.Application.Mappers;

import com.tecbom.e_commerce.Application.DTOs.Users.DTOReturnCepService;
import com.tecbom.e_commerce.Application.DTOs.Users.DTOReturnUser;
import com.tecbom.e_commerce.Application.DTOs.Users.DTOSaveUser;
import com.tecbom.e_commerce.Application.DTOs.Users.DTOSignInMaster;
import com.tecbom.e_commerce.Application.Ports.Output.CepService;
import com.tecbom.e_commerce.Domain.Entities.Users.Master;
import com.tecbom.e_commerce.Domain.Entities.Users.Role;
import com.tecbom.e_commerce.Domain.Entities.Users.User;
import com.tecbom.e_commerce.Domain.ValueObjects.Address;

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
