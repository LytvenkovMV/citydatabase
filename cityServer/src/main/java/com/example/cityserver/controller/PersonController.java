package com.example.cityserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.cityserver.dto.person.AddPersonRequestDto;
import com.example.cityserver.dto.person.GetPersonResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "API для жителей")
public interface PersonController {

    @Operation(summary = "Получить жителя")
    @GetMapping("/city/api/persons/{id}")
    ResponseEntity<GetPersonResponseDto> getPerson(@PathVariable(name = "id") Long personId);

    @Operation(summary = "Добавить жителя")
    @PostMapping("/city/api/persons")
    ResponseEntity<GetPersonResponseDto> addPerson(@RequestBody AddPersonRequestDto requestDto);

    @Operation(summary = "Добавить список жителей")
    @PostMapping("city/api/persons/list")
    ResponseEntity<List<GetPersonResponseDto>> addPersonList(@RequestBody List<AddPersonRequestDto> dtoList);

    @Operation(summary = "Обновить жителя")
    @PutMapping("/city/api/persons/{id}")
    ResponseEntity<GetPersonResponseDto> updatePerson(@PathVariable(name = "id") Long personId,
                                                      @RequestBody AddPersonRequestDto requestDto);

    @Operation(summary = "Удалить жителя")
    @DeleteMapping("/city/api/persons/{id}")
    ResponseEntity<String> deletePerson(@PathVariable(name = "id") Long personId);
}
