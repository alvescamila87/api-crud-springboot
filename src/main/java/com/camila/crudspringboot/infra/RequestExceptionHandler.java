package com.camila.crudspringboot.infra;

import com.camila.crudspringboot.dto.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDTO> threat404(EntityNotFoundException ex) {
        ExceptionDTO response = new ExceptionDTO("Info not found!", 404);
        return ResponseEntity.badRequest().body(response);
    }
}
