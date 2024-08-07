package org.example.citydatabase.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.car.AddCarRequestDto;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.entity.Car;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.mapper.CarMapper;
import org.example.citydatabase.repository.CarRepository;
import org.example.citydatabase.service.CarService;
import org.example.citydatabase.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final PersonService personService;

    private final CarRepository repository;
    private final CarMapper mapper;

    @Override
    public GetCarResponseDto getCarDto(Long carId) {
        Optional<Car> optCar = repository.findById(carId);
        if (optCar.isEmpty()) throw new NoSuchElementException("Car not found");

        return mapper.fromCar(optCar.get());
    }

    @Override
    public Long addCar(AddCarRequestDto dto) {
        Person person = personService.getPerson(dto.getPersonId());
        if (person == null) throw new NoSuchElementException("Person not found");

        Car car = mapper.fromAddCarRequestDtoAndPerson(dto, person);
        repository.save(car);
        return car.getId();
    }

    @Override
    public void updateCar(Long carId, AddCarRequestDto dto) {
        if (!repository.existsById(carId)) throw new NoSuchElementException("Car not found");

        Person person = personService.getPerson(dto.getPersonId());
        if (person == null) throw new NoSuchElementException("Person not found");

        Car car = mapper.fromAddCarRequestDtoAndPerson(dto, person);
        car.setId(carId);
        repository.save(car);
    }

    @Override
    public void deleteCar(Long carId) {
        Optional<Car> optCar = repository.findById(carId);
        if (optCar.isEmpty()) throw new NoSuchElementException("Car not found");

        repository.delete(optCar.get());
    }
}
