package org.example.citydatabase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExControllerAdvice {

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<String> handleBadRequestEx(NoSuchElementException e) {
        e.printStackTrace();

        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<String> handleBadRequestEx(RuntimeException e) {
        e.printStackTrace();

        return ResponseEntity.status(503).body("Service Unavailable");
    }
}
