package az.atlacademy.springjpaexample.exception;

import az.atlacademy.springjpaexample.model.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice

public class GlobalExceptionHndler {
   @ExceptionHandler
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public ResponseEntity<ErrorDto>handlerNotFoundException(StudentNotFoundException ex){
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body(new ErrorDto(404,
                      ex.getMessage(),
                      LocalDateTime.now()));
   }

}
