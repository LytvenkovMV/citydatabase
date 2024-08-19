package com.example.cityserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.cityserver.dto.car.AddCarRequestDto;
import com.example.cityserver.dto.car.GetCarResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "API для машин")
public interface CarController {

    @Operation(summary = "Получить машину")
    @GetMapping("/city/api/cars/{id}")
    ResponseEntity<GetCarResponseDto> getCar(@PathVariable(name = "id") Long carId);

    @Operation(summary = "Добавить машину")
    @PostMapping("/city/api/cars")
    ResponseEntity<GetCarResponseDto> addCar(@RequestBody AddCarRequestDto requestDto);

    @Operation(summary = "Обновить машину")
    @PutMapping("/city/api/cars/{id}")
    ResponseEntity<GetCarResponseDto> updateCar(@PathVariable(name = "id") Long carId,
                                                @RequestBody AddCarRequestDto requestDto);

    @Operation(summary = "Удалить машину")
    @DeleteMapping("/city/api/cars/{id}")
    ResponseEntity<String> deleteCar(@PathVariable(name = "id") Long carId);
}
