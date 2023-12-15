package gustavoreinaldi.myinventoryproducts.exceptions;

import gustavoreinaldi.myinventoryproducts.exceptions.model.ErrorObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler ({GenericUnrecognizedErrorException.class})
    public ResponseEntity<ErrorObject> genericErrorException(GenericUnrecognizedErrorException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorObject.builder()
                        .error(exception.getMessage())
                        .build());
    }
    @ExceptionHandler ({NotFoundException.class})
    public ResponseEntity<ErrorObject> notFoundException(NotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorObject.builder()
                        .error(exception.getMessage())
                        .build());
    }

    @ExceptionHandler ({ValidationException.class})
    public ResponseEntity<ErrorObject> validationException(NotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorObject.builder()
                        .error(exception.getMessage())
                        .build());
    }
}
