package org.example.citydatabase.service;

import org.example.citydatabase.entity.Car;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Passport;
import org.example.citydatabase.entity.Person;

import java.util.List;

public interface SearchService {

    Person searchPersonById(Long personId);

    House searchHoseById(Long houseId);

    List<Car> searchPersonCars(Long personId);

    List<Person> searchPersonByHouseOnStreet(String streetName);

    List<Passport> searchPassportByPersonWithSurnameStarts(Character startChar);
}
