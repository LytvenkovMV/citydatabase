package org.example.citydatabase.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.car.AddCarRequestDto;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "API для машин")
@RestController
@RequestMapping("/city/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @Operation(summary = "Получить машину")
    @GetMapping("/{id}")
    public ResponseEntity<GetCarResponseDto> getCar(@PathVariable(name = "id") Long carId) {
        GetCarResponseDto responseDto = service.getCarDto(carId);

        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "Добавить машину")
    @PostMapping
    public ResponseEntity<GetCarResponseDto> addCar(@RequestBody AddCarRequestDto requestDto) {
        GetCarResponseDto responseDto = service.addCar(requestDto);

        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "Обновить машину")
    @PutMapping("/{id}")
    public ResponseEntity<GetCarResponseDto> updateCar(@PathVariable(name = "id") Long carId,
                                                       @RequestBody AddCarRequestDto requestDto) {
        GetCarResponseDto responseDto = service.updateCar(carId, requestDto);

        return ResponseEntity.ok(responseDto);
    }

    @Operation(summary = "Удалить машину")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable(name = "id") Long carId) {
        service.deleteCar(carId);

        return ResponseEntity.ok("Car deleted!");
    }
}
