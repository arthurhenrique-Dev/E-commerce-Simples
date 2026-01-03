package Domain.ValueObjects;

import Domain.Exceptions.Exceptions.WeakPasswordException;

public record Password(String password) {

    public Password(String password) {
        if (password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$")) this.password = password;
        else throw new WeakPasswordException();
    }
}
