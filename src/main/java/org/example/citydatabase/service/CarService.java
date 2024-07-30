package org.example.citydatabase.service;

import org.example.citydatabase.dto.car.AddCarRequestDto;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.entity.Car;

public interface CarService {

    GetCarResponseDto getCar(Long carId);

    GetCarResponseDto addCar(AddCarRequestDto dto);

    void deleteCar(Long carId);
}
