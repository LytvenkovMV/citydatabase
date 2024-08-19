package com.example.cityserver.controller.impl;

import lombok.RequiredArgsConstructor;
import com.example.cityserver.controller.CarController;
import com.example.cityserver.dto.car.AddCarRequestDto;
import com.example.cityserver.dto.car.GetCarResponseDto;
import com.example.cityserver.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarControllerImpl implements CarController {

    private final CarService service;

    @Override
    public ResponseEntity<GetCarResponseDto> getCar(@PathVariable(name = "id") Long carId) {
        GetCarResponseDto responseDto = service.getCarDto(carId);

        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<GetCarResponseDto> addCar(@RequestBody AddCarRequestDto requestDto) {
        Long carId = service.addCar(requestDto);

        return ResponseEntity.ok(service.getCarDto(carId));
    }

    @Override
    public ResponseEntity<GetCarResponseDto> updateCar(@PathVariable(name = "id") Long carId,
                                                       @RequestBody AddCarRequestDto requestDto) {
        service.updateCar(carId, requestDto);

        return ResponseEntity.ok(service.getCarDto(carId));
    }

    @Override
    public ResponseEntity<String> deleteCar(@PathVariable(name = "id") Long carId) {
        service.deleteCar(carId);

        return ResponseEntity.ok("Car deleted!");
    }
}
