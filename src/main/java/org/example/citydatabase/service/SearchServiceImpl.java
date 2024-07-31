package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.car.GetCarResponseDto;
import org.example.citydatabase.entity.Car;
import org.example.citydatabase.entity.Passport;
import org.example.citydatabase.entity.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final EntityProvider entityProvider;
    private final CarService carService;

    @Override
    public List<GetCarResponseDto> searchPersonCars(Long personId) {
        Person person = entityProvider.getPersonById(personId);

        List<GetCarResponseDto> cars = new ArrayList<>();
        for (Car car : person.getCars()) {
            GetCarResponseDto dto = carService.getCar(car.getId());
            cars.add(dto);
        }
        return cars;
    }

    @Override
    public List<Person> searchPersonByHouseOnStreet(String streetName) {
        return List.of();
    }

    @Override
    public List<Passport> searchPassportByPersonWithSurnameStarts(Character startChar) {
        return List.of();
    }
}
