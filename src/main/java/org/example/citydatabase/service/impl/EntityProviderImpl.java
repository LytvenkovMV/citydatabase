package org.example.citydatabase.service.impl;

import lombok.Setter;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.service.EntityProvider;
import org.example.citydatabase.service.HouseService;
import org.example.citydatabase.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Setter
@Service
public class EntityProviderImpl implements EntityProvider {

    @Autowired
    @Lazy
    private PersonService personService;
    private HouseService houseService;

    @Override
    public Person getPersonById(Long personId) {

        return personService.getPerson(personId);
    }

    @Override
    public House getHouseById(Long houseId) {

        return houseService.getHouse(houseId);
    }
}
