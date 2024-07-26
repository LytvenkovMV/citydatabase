package org.example.citydatabase.controller;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.AddPersonRequestDto;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("citydatabase/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping("/{id}")
    public ResponseEntity<String> getPerson(@PathVariable(name = "id") int personId) {
        Person person = service.getPerson(personId);

        return ResponseEntity.ok(person.toString());
    }

    public ResponseEntity<String> addPerson(@RequestBody AddPersonRequestDto dto) {
        service.addPerson(dto);

        return ResponseEntity.ok("OK");
    }
}
