package com.tecbom.e_commerce.Domain.Entities.Users;

import com.tecbom.e_commerce.Domain.ValueObjects.*;

public class Master {

    private final Cpf cpf;
    private final Name name;
    private Password password;
    private EmailVO email;
    private PhoneNumber phoneNumber;
    private Role role;
    private Status status;

    public Master(Cpf cpf, Name name, Password password, EmailVO email, PhoneNumber phoneNumber) {
        this.cpf = cpf;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = Role.MASTER;
        this.status = Status.ON;
    }

    public Master(Cpf cpf, Name name, Password password, EmailVO email, PhoneNumber phoneNumber, Role role, Status status) {
        this.cpf = cpf;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.status = status;
    }

    public void masterOff() {
        this.status = Status.OFF;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Name getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }

    public EmailVO getEmail() {
        return email;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }
}
