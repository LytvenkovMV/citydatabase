package com.example.cityserver.service;

import com.example.cityserver.dto.car.AddCarRequestDto;
import com.example.cityserver.dto.car.GetCarResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

public interface CarService {

    GetCarResponseDto getCarDto(@Positive Long carId);

    Long addCar(@Valid AddCarRequestDto dto);

    void updateCar(@Positive Long carId, @Valid AddCarRequestDto dto);

    void deleteCar(@Positive Long carId);
}
