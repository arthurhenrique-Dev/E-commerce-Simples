package Application.Ports.Output;

import Domain.Entities.Users.Master;
import Domain.ValueObjects.Cpf;

import java.util.Optional;


public interface MasterRepository {

    void saveMaster(Master master);
    Optional<Master> findMasterByCpf(Cpf cpf);
}
