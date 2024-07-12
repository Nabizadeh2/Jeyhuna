package com.example.springatldma.exception;

import com.example.springatldma.model.dto.ErrorDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorDto> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(400,
                        ex.getMessage(),
                        LocalDateTime.now()));
    }
}
