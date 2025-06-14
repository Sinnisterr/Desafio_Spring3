package com.devsuperior.desafio3.controllers.handlers;

import com.devsuperior.desafio3.dto.CustomError;
import com.devsuperior.desafio3.dto.ValidationError;
import com.devsuperior.desafio3.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

    @ControllerAdvice
    public class ControllerExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<CustomError> customName(ResourceNotFoundException e, HttpServletRequest request) {
            HttpStatus status = HttpStatus.NOT_FOUND; // 404
            CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<CustomError> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
            HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY; // 422
            ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados Inválidos", request.getRequestURI());
            for(FieldError f : e.getBindingResult().getFieldErrors()) {
                err.addError(f.getField(), f.getDefaultMessage());
            }
            return ResponseEntity.status(status).body(err);
        }




    }

