package payroll.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BasicExceptionHandler extends ResponseEntityExceptionHandler {
    @Value("${spring.application.name}")
    private String APP_NAME;

    @ExceptionHandler(EmployeeNameLengthException.class)
    public ResponseEntity<ErrorResponse> handleException(EmployeeNameLengthException e) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), e.getMessage(), APP_NAME), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity<ErrorResponse> handlerException(ValidateException ex) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), ex.getMessage(), APP_NAME), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoMoneyException.class)
    public ResponseEntity<ErrorResponse> handlerException(NoMoneyException exe) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), exe.getMessage(),APP_NAME),HttpStatus.BAD_REQUEST);
    }
}
