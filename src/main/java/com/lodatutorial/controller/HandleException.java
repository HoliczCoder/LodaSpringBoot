package com.lodatutorial.controller;


import com.lodatutorial.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice
public class HandleException
{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity notFoundException(Exception exception) {
        exception.getMessage();
        //return ResponseEntity.ok(exception.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
    }

}
