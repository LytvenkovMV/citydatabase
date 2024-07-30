package org.example.citydatabase.service;

import lombok.Setter;
import org.example.citydatabase.entity.Car;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Passport;
import org.example.citydatabase.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Setter
    private PersonService personService;

    @Setter
    private HouseService houseService;

    @Override
    public Person searchPersonById(Long personId) {
        return personService.getPerson(personId);
    }

    @Override
    public House searchHoseById(Long houseId) {
        return houseService.getHouse(houseId);
    }

    @Override
    public List<Car> searchPersonCars(Long personId) {
        Person person = personService.getPerson(personId);

        return person.getCars();
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
