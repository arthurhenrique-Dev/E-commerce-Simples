package Domain.Services;

import Domain.ValueObjects.Email;

public interface EmailService {

    boolean ValidateEmail(Email email, String sendToken);

    boolean ChangePassword(Email email, String sendToken);
}
