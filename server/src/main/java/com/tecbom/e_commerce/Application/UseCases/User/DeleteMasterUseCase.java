package com.tecbom.e_commerce.Application.UseCases.User;

import com.tecbom.e_commerce.Application.Mappers.UserMapper;
import com.tecbom.e_commerce.Application.Ports.Input.User.DeleteMasterPort;
import com.tecbom.e_commerce.Application.Ports.Output.MasterRepository;
import com.tecbom.e_commerce.Domain.Entities.Users.Master;
import com.tecbom.e_commerce.Domain.Exceptions.Exceptions.UserNotFoundException;
import com.tecbom.e_commerce.Domain.ValueObjects.Cpf;

public class DeleteMasterUseCase implements DeleteMasterPort {

    private final MasterRepository repository;
    private final UserMapper mapper;

    public DeleteMasterUseCase(MasterRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void deleteMasterUser(Cpf cpf) {
        Master master = repository.findMasterByCpf(cpf)
                .orElseThrow(() -> new UserNotFoundException());
        master.masterOff();
        repository.saveMaster(master);
    }
}
