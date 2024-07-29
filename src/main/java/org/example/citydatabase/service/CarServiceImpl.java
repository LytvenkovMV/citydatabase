package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.AddCarRequestDto;
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

    private final CarRepository carRepository;
    private final PersonService personService;
    private final CarMapper mapper;

    @Override
    public Car getCar(Long carId) {
        Optional<Car> optCar = carRepository.findById(carId);
        if (optCar.isEmpty()) throw new NoSuchElementException("Car not found");

        return optCar.get();
    }

    @Override
    public Car addCar(AddCarRequestDto dto) {
        Person person = personService.getPerson(dto.getPersonId());
        if (person == null) throw new NoSuchElementException("Person not found");

        Car car = mapper.fromAddCarRequestDto(dto);
        carRepository.save(car);
        return car;
    }

    @Override
    public void deleteCar(Long carId) {
        Optional<Car> optCar = carRepository.findById(carId);
        if (optCar.isEmpty()) throw new NoSuchElementException("Car not found");

        carRepository.delete(optCar.get());
    }
}
