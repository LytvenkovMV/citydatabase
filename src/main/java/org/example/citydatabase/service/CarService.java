package org.example.citydatabase.service;

import org.example.citydatabase.dto.AddCarRequestDto;
import org.example.citydatabase.entity.Car;

public interface CarService {

    Car getCar(Long carId);

    Car addCar(AddCarRequestDto dto);

    void deleteCar(Long carId);
}
