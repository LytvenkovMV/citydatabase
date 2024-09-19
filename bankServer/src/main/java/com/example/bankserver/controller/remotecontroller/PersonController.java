package com.example.bankserver.controller.remotecontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface PersonController {

    @GetMapping("/city/api/persons/{id}")
    ResponseEntity<String> getPerson(@PathVariable(name = "id") Long personId);
}
