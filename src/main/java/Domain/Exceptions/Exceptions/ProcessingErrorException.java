package Domain.Exceptions.Exceptions;

public class ProcessingErrorException extends RuntimeException {
    public ProcessingErrorException() {
        super("Erro de processamento");
    }
}
