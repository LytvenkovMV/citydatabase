package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.dto.passport.GetPassportResponseDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.example.citydatabase.entity.Car;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;
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
        Person person = personService.getPersonEntity(personId);

        List<GetCarResponseDto> cars = new ArrayList<>();
        for (Car car : person.getCars()) {
            GetCarResponseDto dto = carService.getCar(car.getId());
            cars.add(dto);
        }
        return cars;
    }

    @Override
    public List<GetPersonResponseDto> searchPersonByHouseOnStreet(String streetName) {
        List<House> houses = houseService.getHousesBy(streetName);

        List<GetPersonResponseDto> dtoList = houses.stream()
                .flatMap(h -> h.getPersons().stream())
                .map(p -> personService.getPerson(p.getId()))
                .toList();

        return dtoList;
    }

    @Override
    public List<GetPassportResponseDto> searchPassportWithSurnameStartingWith(Character surnameStartChar) {

        List<Person> persons = personService.getPersonsBy(surnameStartChar);

        List<GetPassportResponseDto> dtoList = persons.stream()
                .map(Person::getPassport)
                .map(passport -> passportService.getPassport(passport.getId()))
                .toList();

        return dtoList;
    }
}
