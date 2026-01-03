package Domain.Entities.Users;

import Domain.Exceptions.Exceptions.ValidationFailedException;
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
    private Status status;
    private EmailValidation emailValidation;
    private PasswordUpdater passwordUpdater;

    public BaseUser(Cpf cpf, Name name, Password password, Email email, Address address, PhoneNumber phoneNumber, Status status) {
        this.cpf = cpf;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cart = new Cart(new ArrayList<>());
        this.status = status;
        this.emailValidation = EmailValidation.Start();
        this.passwordUpdater = null;
    }

    public void StartChangePassword(){
        if (this.emailValidation.validated()) this.passwordUpdater = PasswordUpdater.Start();
        else throw new ValidationFailedException("Necessário validar o email primeiro");
    }

    public void ChangePassword(String token, Password newPassword){
        if (this.passwordUpdater != null && this.passwordUpdater.CheckToken(token)) {
            this.password = newPassword;
            this.passwordUpdater = null;
        }
        else throw new ValidationFailedException("Não é possível alterar a senha no momento");
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
