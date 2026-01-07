package Infra.Adapters.Output.Persistence.SQL.Adapters;

import Application.Ports.Output.MasterRepository;
import Domain.Entities.Users.Master;
import Domain.Exceptions.Exceptions.DatabaseFailedException;
import Domain.ValueObjects.Cpf;
import Infra.Adapters.Output.Persistence.SQL.Mappers.Mapper;
import Infra.Adapters.Output.Persistence.SQL.Models.MasterEntity;
import Infra.Adapters.Output.Persistence.SQL.Repositories.JpaMasterRepository;
import Infra.Security.Service.CryptographyService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MasterRepositoryAdapter implements MasterRepository {

    private final JpaMasterRepository frameworkRepository;
    private final Mapper mapper;

    public MasterRepositoryAdapter(JpaMasterRepository frameworkRepository, Mapper mapper) {
        this.frameworkRepository = frameworkRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveMaster(Master master) {
        try {
            MasterEntity masterEntity = mapper.masterToEntity(master);
            frameworkRepository.save(masterEntity);
        } catch (Exception e) {
            throw new DatabaseFailedException();
        }

    }

    @Override
    public Optional<Master> findMasterByCpf(Cpf cpf) {
        try {
            String cpfCrypt = CryptographyService.encrypt(cpf.toString());
            return frameworkRepository.findMasterByCpf(cpfCrypt)
                    .map(mapper::masterToDomain);
        } catch (Exception e) {
            throw new DatabaseFailedException();
        }
    }
}
