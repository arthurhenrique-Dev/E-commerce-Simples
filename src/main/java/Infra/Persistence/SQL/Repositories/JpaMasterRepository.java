package Infra.Persistence.SQL.Repositories;

import Infra.Persistence.SQL.Models.MasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JpaMasterRepository extends JpaRepository<MasterEntity, String> {

    @Query("SELECT u FROM MasterEntity u WHERE u.cpf = :cpf")
    Optional<MasterEntity> findMasterByCpf(String cpfCrypt);
}
