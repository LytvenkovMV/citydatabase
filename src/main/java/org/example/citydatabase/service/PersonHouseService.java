package org.example.citydatabase.service;

import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.entity.PersonHouse;

import java.util.List;

public interface PersonHouseService {

    List<Person> updatePersonsInHouseWithId(House house, List<Person> persons);

    List<House> updateHousesInPerson(Person person, List<House> houses);

    void deleteAllByPersonId(Long personId);

    void deleteAllByHouseId(Long houseId);
}
