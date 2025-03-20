package excepciones;

public class PagoInvalidoException extends RuntimeException {
    public PagoInvalidoException(String message) {
        super(message);
    }
}
