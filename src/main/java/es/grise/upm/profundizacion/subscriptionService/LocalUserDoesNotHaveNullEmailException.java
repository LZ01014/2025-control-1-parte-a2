package es.grise.upm.profundizacion.subscriptionService;

public class LocalUserDoesNotHaveNullEmailException extends RuntimeException{
    public LocalUserDoesNotHaveNullEmailException(String message) {
        super(message);
    }
}
