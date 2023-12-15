package gustavoreinaldi.myinventoryproducts.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class GenericUnrecognizedErrorException extends RuntimeException{
    public GenericUnrecognizedErrorException() {
        super("Unrecognized error during execution, please try again later.");
    }

    public GenericUnrecognizedErrorException(String message) {
        super(message);
    }
}
