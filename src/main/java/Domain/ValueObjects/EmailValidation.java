package Domain.ValueObjects;

import Domain.Exceptions.Exceptions.InvalidDataException;
import Domain.Exceptions.Exceptions.ValidationFailedException;

import java.util.UUID;

public record EmailValidation(

        String token,
        boolean validated
) {

    public static EmailValidation Start(){

        String token = UUID.randomUUID().toString();
        return new EmailValidation(token, false);
    }

    public EmailValidation Validate(String token){

        if (this.validated) return this;
        if (token.equals(this.token)) return new EmailValidation(null, true);
        else throw new ValidationFailedException();
    }
}
