package com.example.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<Object> myMessage(CustomException c)
    {
        return new ResponseEntity<>(c.getMessage(),HttpStatus.FORBIDDEN);
    }
}
