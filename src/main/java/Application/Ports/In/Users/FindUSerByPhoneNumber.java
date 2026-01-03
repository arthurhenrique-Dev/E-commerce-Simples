package Application.Ports.In.Users;

import Application.DTO.Users.DTOReturnUser;
import Domain.ValueObjects.PhoneNumber;

import java.util.List;

public interface FindUSerByPhoneNumber {

    List<DTOReturnUser> findUserByPhoneNumber(PhoneNumber phoneNumber);
}
