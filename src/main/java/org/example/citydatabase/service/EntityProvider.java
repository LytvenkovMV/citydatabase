package org.example.citydatabase.service;

import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;

public interface EntityProvider {

    Person getPersonById(Long personId);

    House getHouseById(Long houseId);
}
