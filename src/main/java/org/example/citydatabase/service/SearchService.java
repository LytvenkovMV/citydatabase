package org.example.citydatabase.service;

import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;

public interface SearchService {

    Person searchPersonById(Long personId);

    House searchHoseById(Long houseId);
}
