package Domain.ValueObjects;

import Domain.Exceptions.Exceptions.InvalidDataException;

public record Email(String email) {

    public Email(String email) {
        if (email != null && email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){
            this.email = email;
        }
        else throw new InvalidDataException("Email invalido");
    }
}
