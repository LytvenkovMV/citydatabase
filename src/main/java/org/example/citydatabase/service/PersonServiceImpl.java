package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.AddPersonRequestDto;
import org.example.citydatabase.entity.*;
import org.example.citydatabase.mapper.PersonMapper;
import org.example.citydatabase.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final HouseRepository houseRepository;
    private final PersonHouseRepository personHouseRepository;
    private final PassportRepository passportRepository;
    private final CarRepository carRepository;
    private final PersonMapper mapper;

    @Override
    public Person getPerson(Long personId) {

        return personRepository.findById(personId).orElseThrow();
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Person addPerson(AddPersonRequestDto dto) {
        Person person = mapper.personFromAddPersonRequestDto(dto);
        Passport passport = mapper.passportFromAddPersonRequestDto(dto);

        personRepository.save(person);
        passportRepository.save(passport);

        for (Long houseId : dto.getHousesId()) {
            House house = houseRepository.findById(houseId).orElseThrow();

            PersonHouse personHouse = new PersonHouse();
            personHouse.setPerson(person);
            personHouse.setHouse(house);
            personHouseRepository.save(personHouse);
        }

        return person;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void deletePerson(Long personId) {
        Person person = personRepository.findById(personId).orElseThrow();
        Passport passport = person.getPassport();
        List<Car> cars = person.getCars();

        personHouseRepository.deleteAllByPersonId(personId);
        passportRepository.delete(passport);
        carRepository.deleteAll(cars);
        personRepository.delete(person);
    }
}
