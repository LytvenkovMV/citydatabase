package org.example.citydatabase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.person.AddPersonRequestDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.example.citydatabase.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API для жителей")
@RestController
@RequestMapping("/city/api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @Operation(summary = "Получить жителя")
    @GetMapping("/{id}")
    public ResponseEntity<GetPersonResponseDto> getPerson(@PathVariable(name = "id") Long personId) {
        GetPersonResponseDto responseDto = service.getPersonDto(personId);

        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "Добавить жителя")
    @PostMapping
    public ResponseEntity<GetPersonResponseDto> addPerson(@RequestBody AddPersonRequestDto requestDto) {
        GetPersonResponseDto responseDto = service.addPerson(requestDto);

        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "Удалить жителя")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable(name = "id") Long personId) {
        service.deletePerson(personId);

        return ResponseEntity.ok("Person deleted!");
    }
}
