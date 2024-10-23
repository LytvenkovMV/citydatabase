package com.example.cityserver.service.impl;

import com.example.cityserver.dto.car.AddCarRequestDto;
import com.example.cityserver.dto.car.GetCarResponseDto;
import com.example.cityserver.entity.Car;
import com.example.cityserver.entity.Person;
import com.example.cityserver.mapper.CarMapper;
import com.example.cityserver.repository.CarRepository;
import com.example.cityserver.service.CarService;
import com.example.cityserver.service.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Validated
public class CarServiceImpl implements CarService {

    private final PersonService personService;

    private final CarRepository repository;
    private final CarMapper mapper;

    @Override
    public GetCarResponseDto getCarDto(@Positive Long carId) {
        Optional<Car> optCar = repository.findById(carId);
        if (optCar.isEmpty()) throw new NoSuchElementException("Car not found");

        return mapper.fromCar(optCar.get());
    }

    @Override
    public Long addCar(@Valid AddCarRequestDto dto) {
        Person person = personService.getPerson(dto.getPersonId());
        if (person == null) throw new NoSuchElementException("Person not found");

        Car car = mapper.fromAddCarRequestDtoAndPerson(dto, person);
        repository.save(car);
        return car.getId();
    }

    @Override
    public void updateCar(@Positive Long carId, @Valid AddCarRequestDto dto) {
        if (!repository.existsById(carId)) throw new NoSuchElementException("Car not found");

        Person person = personService.getPerson(dto.getPersonId());
        if (person == null) throw new NoSuchElementException("Person not found");

        Car car = mapper.fromAddCarRequestDtoAndPerson(dto, person);
        car.setId(carId);
        repository.save(car);
    }

    @Override
    public void deleteCar(@Positive Long carId) {
        Optional<Car> optCar = repository.findById(carId);
        if (optCar.isEmpty()) throw new NoSuchElementException("Car not found");

        repository.delete(optCar.get());
    }
}
