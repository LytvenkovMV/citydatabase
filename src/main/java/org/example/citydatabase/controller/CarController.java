package org.example.citydatabase.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.AddCarRequestDto;
import org.example.citydatabase.entity.Car;
import org.example.citydatabase.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Для машин")
@RestController
@RequestMapping("/city/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @Operation(summary = "Получить машину")
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable(name = "id") Long carId) {
        Car car = service.getCar(carId);

        return ResponseEntity.ok(car);
    }

    @Operation(summary = "Добавить машину")
    @PostMapping("/")
    public ResponseEntity<Car> addCar(@RequestBody AddCarRequestDto dto) {
        Car car = service.addCar(dto);

        return ResponseEntity.ok(car);
    }

    @Operation(summary = "Удалить машину")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable(name = "id") Long carId) {
        service.deleteCar(carId);

        return ResponseEntity.ok("Car deleted!");
    }
}
