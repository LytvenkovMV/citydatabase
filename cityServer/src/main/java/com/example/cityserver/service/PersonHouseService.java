package com.example.cityserver.service;

import com.example.cityserver.entity.House;
import com.example.cityserver.entity.Person;

import java.util.List;

public interface PersonHouseService {

    List<Person> updatePersonsInHouseWithId(House house, List<Person> persons);

    List<House> updateHousesInPerson(Person person, List<House> houses);

    void deleteAllByPersonId(Long personId);

    void deleteAllByHouseId(Long houseId);
}
