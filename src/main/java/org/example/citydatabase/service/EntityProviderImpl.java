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
        return personService.getPersonEntity(personId);
    }

    @Override
    public House getHouseById(Long houseId) {
        return houseService.getHouseEntity(houseId);
    }
}
