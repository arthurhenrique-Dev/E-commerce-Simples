package Application.Ports.Output;

import Domain.ValueObjects.EmailVO;

public interface EmailService {

    void ValidateEmail(EmailVO email, String sendToken);

    void ChangePassword(EmailVO email, String sendToken);
}
