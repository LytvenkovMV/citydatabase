package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;
import org.springframework.stereotype.Service;

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
}
