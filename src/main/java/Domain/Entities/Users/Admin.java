package Domain.Entities.Users;

import Domain.ValueObjects.*;

public class Admin extends BaseUser {


    public Admin(Cpf cpf, Name name, Password password, Email email, Address address, PhoneNumber phoneNumber) {
        super(cpf, name, password, email, address, phoneNumber);
        this.role = Roles.ADMIN;
    }
}
