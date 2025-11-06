package es.grise.upm.profundizacion.subscriptionService;

public class ExistingUserException extends RuntimeException {
    public ExistingUserException(String message) {
        super(message);
    }
}
