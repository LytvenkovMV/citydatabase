package org.example.citydatabase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.citydatabase.dto.person.AddPersonRequestDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API для жителей")
@RequestMapping("/city/api/persons")
public interface PersonController {

    @Operation(summary = "Получить жителя")
    @GetMapping("/{id}")
    ResponseEntity<GetPersonResponseDto> getPerson(Long personId);

    @Operation(summary = "Добавить жителя")
    @PostMapping
    ResponseEntity<GetPersonResponseDto> addPerson(AddPersonRequestDto requestDto);

    @Operation(summary = "Обновить жителя")
    @PutMapping("/{id}")
    ResponseEntity<GetPersonResponseDto> updatePerson(Long personId, AddPersonRequestDto requestDto);

    @Operation(summary = "Удалить жителя")
    @DeleteMapping("/{id}")
    ResponseEntity<String> deletePerson(Long personId);
}
