package org.example.citydatabase.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.person.AddPersonRequestDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Passport;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.mapper.PersonMapper;
import org.example.citydatabase.repository.PersonRepository;
import org.example.citydatabase.service.EntityProvider;
import org.example.citydatabase.service.PassportService;
import org.example.citydatabase.service.PersonHouseService;
import org.example.citydatabase.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final EntityProvider entityProvider;
    private final PersonHouseService personHouseService;
    private final PassportService passportService;

    private final PersonRepository repository;
    private final PersonMapper mapper;

    @Override
    public Person getPerson(Long personId) {
        Optional<Person> optPerson = repository.findById(personId);
        if (optPerson.isEmpty()) throw new NoSuchElementException("Person not found");

        return optPerson.get();
    }

    @Override
    public List<Person> getPersonsBy(Character surnameStartChar) {
        return repository.findAllBySurnameStartingWith(surnameStartChar);
    }

    @Override
    public GetPersonResponseDto getPersonDto(Long personId) {
        Person person = getPerson(personId);

        return mapper.fromPerson(person);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public GetPersonResponseDto addPerson(AddPersonRequestDto dto) {
        Person person = mapper.personFromAddPersonRequestDto(dto);
        Passport passport = passportService.addPassport();
        person.setPassport(passport);
        repository.save(person);

        for (Long houseId : dto.getHousesId()) {
            House house = entityProvider.getHouseById(houseId);
            if (house != null) personHouseService.addPersonHouse(person, house);
        }

        return getPersonDto(person.getId());
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public GetPersonResponseDto updatePerson(Long personId, AddPersonRequestDto dto) {
        Optional<Person> existingPerson = repository.findById(personId);
        if (existingPerson.isEmpty()) throw new NoSuchElementException("Person not found");

        Person person = mapper.personFromAddPersonRequestDto(dto);
        person.setId(personId);
        person.setPassport(existingPerson.get().getPassport());
        repository.save(person);

        personHouseService.deleteAllByPersonId(personId);
        for (Long houseId : dto.getHousesId()) {
            House house = entityProvider.getHouseById(houseId);
            if (house != null) personHouseService.addPersonHouse(person, house);
        }

        return getPersonDto(personId);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public void deletePerson(Long personId) {
        Optional<Person> optPerson = repository.findById(personId);
        if (optPerson.isEmpty()) throw new NoSuchElementException("Person not found");

        Person person = optPerson.get();
        personHouseService.deleteAllByPersonId(personId);
        repository.delete(person);
    }
}
