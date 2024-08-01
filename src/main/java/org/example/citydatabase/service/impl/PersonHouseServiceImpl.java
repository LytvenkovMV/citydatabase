package org.example.citydatabase.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.entity.PersonHouse;
import org.example.citydatabase.repository.PersonHouseRepository;
import org.example.citydatabase.service.PersonHouseService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonHouseServiceImpl implements PersonHouseService {

    private final PersonHouseRepository repository;

    @Override
    public void addPersonHouse(Person person, House house) {
        PersonHouse personHouse = new PersonHouse();
        personHouse.setPerson(person);
        personHouse.setHouse(house);
        repository.save(personHouse);
    }

    @Override
    public void deleteAllByPersonId(Long personId) {
        repository.deleteAllByPersonId(personId);
    }

    @Override
    public void deleteAllByHouseId(Long houseId) {
        repository.deleteAllByHouseId(houseId);
    }
}
