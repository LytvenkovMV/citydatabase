package com.example.cityserver.service;

import com.example.cityserver.dto.car.AddCarRequestDto;
import com.example.cityserver.dto.car.GetCarResponseDto;

public interface CarService {

    GetCarResponseDto getCarDto(Long carId);

    Long addCar(AddCarRequestDto dto);

    void updateCar(Long carId, AddCarRequestDto dto);

    void deleteCar(Long carId);
}
