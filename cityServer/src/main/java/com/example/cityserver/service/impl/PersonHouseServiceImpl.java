package com.example.cityserver.service.impl;

import com.example.cityserver.entity.House;
import com.example.cityserver.entity.Person;
import com.example.cityserver.entity.PersonHouse;
import com.example.cityserver.repository.PersonHouseRepository;
import com.example.cityserver.service.PersonHouseService;
import com.example.cityserver.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonHouseServiceImpl implements PersonHouseService {

    private final PersonHouseRepository repository;
    private final Logger logger = LoggerFactory.getLogger(PersonHouseService.class);

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
        logger.debug("Start updating houses in person");
        repository.deleteAllByPersonId(person.getId());
        logger.debug("Deleted all record by person id in DB");

        List<PersonHouse> personHouses = houses.stream()
                .map(h -> {
                    PersonHouse ph = new PersonHouse();
                    ph.setPerson(person);
                    ph.setHouse(h);
                    return ph;
                }).toList();

        StringBuilder sb = new StringBuilder();
        for (PersonHouse ph : personHouses) {
            sb.append("{Person id: ").append(ph.getPerson().getId()).append(", ");
            sb.append("House id: ").append(ph.getHouse().getId()).append("} ");
        }
        logger.debug("Prepared new records: " + sb);

        repository.saveAll(personHouses);
        logger.debug("Saved all new records in DB");

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
