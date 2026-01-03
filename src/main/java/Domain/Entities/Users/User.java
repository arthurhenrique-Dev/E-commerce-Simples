package Domain.Entities.Users;

import Domain.ValueObjects.*;

public class User extends BaseUser{
    public User(Cpf cpf, Name name, Password password, Email email, Address address, PhoneNumber phoneNumber, Status status) {
        super(cpf, name, password, email, address, phoneNumber, status);
        this.role = Roles.COMUM;
    }
}
