package org.example.citydatabase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.citydatabase.dto.car.AddCarRequestDto;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API для машин")
@RequestMapping("/city/api/cars")
public interface CarController {

    @Operation(summary = "Получить машину")
    @GetMapping("/{id}")
    ResponseEntity<GetCarResponseDto> getCar(Long carId);

    @Operation(summary = "Добавить машину")
    @PostMapping
    ResponseEntity<GetCarResponseDto> addCar(@RequestBody AddCarRequestDto requestDto);

    @Operation(summary = "Обновить машину")
    @PutMapping("/{id}")
    ResponseEntity<GetCarResponseDto> updateCar(Long carId, AddCarRequestDto requestDto);

    @Operation(summary = "Удалить машину")
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteCar(Long carId);
}
