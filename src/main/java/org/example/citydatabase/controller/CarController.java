package org.example.citydatabase.controller;

import org.example.citydatabase.dto.car.AddCarRequestDto;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CarController {

    ResponseEntity<GetCarResponseDto> getCar(Long carId);

    ResponseEntity<GetCarResponseDto> addCar(@RequestBody AddCarRequestDto requestDto);

    ResponseEntity<GetCarResponseDto> updateCar(Long carId, AddCarRequestDto requestDto);

    ResponseEntity<String> deleteCar(Long carId);
}
