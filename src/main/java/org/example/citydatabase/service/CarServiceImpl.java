package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.car.AddCarRequestDto;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.entity.Car;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.mapper.CarMapper;
import org.example.citydatabase.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final EntityProvider entityProvider;

    private final CarRepository carRepository;
    private final CarMapper mapper;

    @Override
    public GetCarResponseDto getCar(Long carId) {
        Optional<Car> optCar = carRepository.findById(carId);
        if (optCar.isEmpty()) throw new NoSuchElementException("Car not found");

        return mapper.fromCar(optCar.get());
    }

    @Override
    public GetCarResponseDto addCar(AddCarRequestDto dto) {
        Person person = entityProvider.getPersonById(dto.getPersonId());
        if (person == null) throw new NoSuchElementException("Person not found");

        Car car = mapper.fromAddCarRequestDtoAndPerson(dto, person);
        carRepository.save(car);
        return mapper.fromCar(car);
    }

    @Override
    public void deleteCar(Long carId) {
        Optional<Car> optCar = carRepository.findById(carId);
        if (optCar.isEmpty()) throw new NoSuchElementException("Car not found");

        carRepository.delete(optCar.get());
    }
}
