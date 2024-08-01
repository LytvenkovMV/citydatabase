package org.example.citydatabase.service;

import lombok.Setter;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;
import org.springframework.stereotype.Service;

@Setter
@Service
public class EntityProviderImpl implements EntityProvider {

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
