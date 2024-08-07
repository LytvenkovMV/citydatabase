package org.example.citydatabase.service;

import org.example.citydatabase.dto.car.AddCarRequestDto;
import org.example.citydatabase.dto.car.GetCarResponseDto;

public interface CarService {

    GetCarResponseDto getCarDto(Long carId);

    Long addCar(AddCarRequestDto dto);

    void updateCar(Long carId, AddCarRequestDto dto);

    void deleteCar(Long carId);
}
