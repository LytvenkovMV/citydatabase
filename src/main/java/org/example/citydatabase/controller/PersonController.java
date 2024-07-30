package org.example.citydatabase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.AddPersonRequestDto;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Для домов")
@RestController
@RequestMapping("/city/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @Operation(summary = "Получить жителя")
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable(name = "id") Long personId) {
        Person person = service.getPerson(personId);

        return ResponseEntity.ok(person);
    }

    @Operation(summary = "Добавить жителя")
    @PostMapping("/")
    public ResponseEntity<Person> addPerson(@RequestBody AddPersonRequestDto dto) {
        Person person = service.addPerson(dto);

        return ResponseEntity.ok(person);
    }

    @Operation(summary = "Удалить жителя")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable(name = "id") Long personId) {
        service.deletePerson(personId);

        return ResponseEntity.ok("Person deleted!");
    }
}
