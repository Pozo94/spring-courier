package pl.com.gymtech.courierspring.exception;

import org.flywaydb.core.api.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.com.gymtech.courierspring.dto.Error;

import javax.xml.bind.ValidationException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Error> handleNoSuchElementException(NoSuchElementException ex) {
        Error errorDetails = new Error();
        errorDetails.setCode(HttpStatus.NOT_FOUND.value());
        errorDetails.setMessage("Object not found!");
        errorDetails.setDetails(ex.getMessage());

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleValidationException(MethodArgumentNotValidException ex) {
        Error errorDetails = new Error();
        errorDetails.setCode(HttpStatus.BAD_REQUEST.value());
        errorDetails.setMessage("Provide all necessary data! ");
        errorDetails.setDetails(ex.getMessage());

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
