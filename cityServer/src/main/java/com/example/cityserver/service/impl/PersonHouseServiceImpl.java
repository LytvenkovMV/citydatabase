package com.example.cityserver.service.impl;

import com.example.cityserver.entity.House;
import com.example.cityserver.entity.Person;
import com.example.cityserver.entity.PersonHouse;
import com.example.cityserver.repository.PersonHouseRepository;
import com.example.cityserver.service.PersonHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonHouseServiceImpl implements PersonHouseService {

    private final PersonHouseRepository repository;

    @Override
    public List<Person> updatePersonsInHouseWithId(House house, List<Person> persons) {
        repository.deleteAllByHouseId(house.getId());

        List<PersonHouse> personHouses = persons.stream()
                .map(p -> {
                    PersonHouse ph = new PersonHouse();
                    ph.setPerson(p);
                    ph.setHouse(house);
                    return ph;
                }).toList();
        repository.saveAll(personHouses);

        return repository.findAllByHouseId(house.getId()).stream()
                .map(PersonHouse::getPerson)
                .distinct()
                .sorted((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .toList();
    }

    @Override
    public List<House> updateHousesInPerson(Person person, List<House> houses) {
        repository.deleteAllByPersonId(person.getId());

        List<PersonHouse> personHouses = houses.stream()
                .map(h -> {
                    PersonHouse ph = new PersonHouse();
                    ph.setPerson(person);
                    ph.setHouse(h);
                    return ph;
                }).toList();
        repository.saveAll(personHouses);

        return repository.findAllByPersonId(person.getId()).stream()
                .map(PersonHouse::getHouse)
                .distinct()
                .sorted((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .toList();
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
