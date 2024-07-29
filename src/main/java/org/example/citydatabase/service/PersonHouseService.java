package org.example.citydatabase.service;

import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;

public interface PersonHouseService {

    void addPersonHouse(Person person, House house);

    void deleteAllByPersonId(Long personId);

    void deleteAllByHouseId(Long houseId);
}
