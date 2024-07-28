package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.AddCarRequestDto;
import org.example.citydatabase.entity.Car;
import org.example.citydatabase.mapper.CarMapper;
import org.example.citydatabase.repository.CarRepository;
import org.example.citydatabase.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;
    private final CarMapper mapper;

    @Override
    public Car getCar(Long carId) {

        return carRepository.findById(carId).orElseThrow();
    }

    @Override
    public Car addCar(AddCarRequestDto dto) {
        personRepository.findById(dto.getPersonId()).orElseThrow();

        Car car = mapper.fromAddCarRequestDto(dto);
        carRepository.save(car);
        return car;
    }

    @Override
    public void deleteCar(Long carId) {
        Car car = carRepository.findById(carId).orElseThrow();

        carRepository.delete(car);
    }
}
