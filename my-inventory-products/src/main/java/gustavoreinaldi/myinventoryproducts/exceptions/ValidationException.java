package gustavoreinaldi.myinventoryproducts.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException() {
        super("Error(s) during validation(s).");
    }
    public ValidationException(String message) {
        super(message);
    }
}
