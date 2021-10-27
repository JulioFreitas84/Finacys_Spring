package trilha.back.presenter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import trilha.back.data.exceptions.EntityNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    //metodo personalizado criado EntityNotFoundException

    //retorno vai ser ResponseEntity e generic será o StandarError
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> meuEntityNotFoud(EntityNotFoundException enfe, HttpServletRequest request){

        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Meu erro Inserido");
        error.setMessage(enfe.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
