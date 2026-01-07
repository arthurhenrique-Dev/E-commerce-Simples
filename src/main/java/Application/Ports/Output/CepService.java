package Application.Ports.Output;

import Application.DTOs.Users.DTOReturnCepService;
import Domain.ValueObjects.Cep;

public interface CepService {

    DTOReturnCepService getAddressByCep(Cep cep);
}
