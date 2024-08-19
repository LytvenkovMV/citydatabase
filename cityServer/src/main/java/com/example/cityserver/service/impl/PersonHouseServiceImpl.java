package com.example.cityserver.service.impl;

import lombok.RequiredArgsConstructor;
import com.example.cityserver.entity.House;
import com.example.cityserver.entity.Person;
import com.example.cityserver.entity.PersonHouse;
import com.example.cityserver.repository.PersonHouseRepository;
import com.example.cityserver.service.PersonHouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonHouseServiceImpl implements PersonHouseService {

    private final PersonHouseRepository repository;

    @Override
    public List<Person> updatePersonsInHouseWithId(House house, List<Person> persons) {
        repository.deleteAllByHouseId(house.getId());

        for (Person p : persons) {
            PersonHouse personHouse = new PersonHouse();
            personHouse.setPerson(p);
            personHouse.setHouse(house);
            repository.save(personHouse);
        }

        return repository.findAllByHouseId(house.getId()).stream()
                .map(PersonHouse::getPerson)
                .distinct()
                .sorted((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .toList();
    }

    @Override
    public List<House> updateHousesInPerson(Person person, List<House> houses) {
        repository.deleteAllByPersonId(person.getId());

        for (House h : houses) {
            PersonHouse personHouse = new PersonHouse();
            personHouse.setPerson(person);
            personHouse.setHouse(h);
            repository.save(personHouse);
        }

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
