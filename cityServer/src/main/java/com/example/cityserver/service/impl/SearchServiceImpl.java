package com.example.cityserver.service.impl;

import com.example.cityserver.dto.car.GetCarResponseDto;
import com.example.cityserver.dto.passport.GetPassportResponseDto;
import com.example.cityserver.dto.person.GetPersonResponseDto;
import com.example.cityserver.entity.Car;
import com.example.cityserver.entity.House;
import com.example.cityserver.entity.Person;
import com.example.cityserver.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final PersonService personService;
    private final PassportService passportService;
    private final HouseService houseService;
    private final CarService carService;

    @Override
    public List<GetCarResponseDto> searchPersonCars(Long personId) {
        Person person = personService.getPerson(personId);

        List<GetCarResponseDto> cars = new ArrayList<>();
        for (Car car : person.getCars()) {
            GetCarResponseDto dto = carService.getCarDto(car.getId());
            cars.add(dto);
        }
        return cars;
    }

    @Override
    public List<GetPersonResponseDto> searchPersonsByHousesOnStreet(String streetName) {
        List<House> houses = houseService.getHousesBy(streetName);

        List<GetPersonResponseDto> dtoList = houses.stream()
                .flatMap(h -> h.getPersons().stream())
                .map(p -> personService.getPersonDto(p.getId()))
                .toList();

        return dtoList;
    }

    @Override
    public List<GetPassportResponseDto> searchPassportWithSurnameStartingWith(Character surnameStartChar) {

        List<Person> persons = personService.getPersonsBy(surnameStartChar);

        List<GetPassportResponseDto> dtoList = persons.stream()
                .map(Person::getPassport)
                .map(passport -> passportService.getPassportDto(passport.getId()))
                .toList();

        return dtoList;
    }
}
