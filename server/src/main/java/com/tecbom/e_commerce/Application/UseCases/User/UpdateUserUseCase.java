package com.tecbom.e_commerce.Application.UseCases.User;

import com.tecbom.e_commerce.Application.DTOs.Users.DTOUpdateUser;
import com.tecbom.e_commerce.Application.Ports.Input.User.UpdateUserPort;
import com.tecbom.e_commerce.Application.Ports.Output.UserRepository;
import com.tecbom.e_commerce.Domain.Entities.Users.User;
import com.tecbom.e_commerce.Domain.Exceptions.Exceptions.UserNotFoundException;

public class UpdateUserUseCase implements UpdateUserPort {

    private final UserRepository repository;

    public UpdateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void updateUser(DTOUpdateUser dtoUpdateUser) {
        User user = repository.getUserByCpf(dtoUpdateUser.cpf())
                .orElseThrow(() -> new UserNotFoundException());
        user.UpdateUser(dtoUpdateUser.email(), dtoUpdateUser.phoneNumber(), dtoUpdateUser.address());
        repository.saveUser(user);
    }
}
