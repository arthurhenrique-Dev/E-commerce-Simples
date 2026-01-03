package Domain.Entities.Users;

import Domain.ValueObjects.*;

import java.util.ArrayList;

public abstract class BaseUser {

    private final Cpf cpf;
    private final Name name;
    private Password password;
    private Email email;
    private Address address;
    private PhoneNumber phoneNumber;
    private Cart cart;
    protected Roles role;

    public BaseUser(Cpf cpf, Name name, Password password, Email email, Address address, PhoneNumber phoneNumber) {
        this.cpf = cpf;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cart = new Cart(new ArrayList<>());
    }
}
