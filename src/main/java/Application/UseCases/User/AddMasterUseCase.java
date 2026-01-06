package Application.UseCases.User;

import Application.DTOs.Users.DTOSignInMaster;
import Application.Mappers.UserMapper;
import Application.Ports.Input.User.AddMasterPort;
import Application.Ports.Output.MasterRepository;
import Domain.Entities.Users.Master;
import Domain.Exceptions.Exceptions.InvalidDataException;
import Domain.Exceptions.Exceptions.UserNotFoundException;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public class AddMasterUseCase implements AddMasterPort {

    private final MasterRepository repository;
    private final UserMapper mapper;

    public AddMasterUseCase(MasterRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void saveMaster(DTOSignInMaster master) {
        Optional existingMaster = repository.findMasterByCpf(master.cpf());
        if (existingMaster.isEmpty()){
            repository.saveMaster(mapper.registerMaster(master));
        } else throw new InvalidDataException("Usuario existente");
    }
}
