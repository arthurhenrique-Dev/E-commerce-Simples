package Application.UseCases.User;

import Application.Mappers.UserMapper;
import Application.Ports.Input.User.DeleteMasterPort;
import Application.Ports.Output.MasterRepository;
import Domain.Entities.Users.Master;
import Domain.Exceptions.Exceptions.UserNotFoundException;
import Domain.ValueObjects.Cpf;

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
