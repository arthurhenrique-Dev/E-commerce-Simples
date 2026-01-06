package Domain.Exceptions.Exceptions;

public class DatabaseFailedException extends RuntimeException {
    public DatabaseFailedException(String message) {
        super(message);
    }

    public DatabaseFailedException() {
        super("Falha no banco de dados");
    }
}
