package com.example.cityserver.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExControllerAdvice {

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<String> handleNoSuchElementEx(NoSuchElementException e) {
        e.printStackTrace();

        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<String> handleConstraintViolationEx(ConstraintViolationException e) {
        e.printStackTrace();

        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<String> handleMethodArgumentNotValidEx(MethodArgumentNotValidException e) {
        e.printStackTrace();

        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<String> handleRuntimeEx(RuntimeException e) {
        e.printStackTrace();

        return ResponseEntity.status(503).body("Service Unavailable");
    }
}
