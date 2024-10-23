package com.example.cityserver.service.impl;

import com.example.cityserver.dto.person.AddPersonRequestDto;
import com.example.cityserver.dto.person.GetPersonResponseDto;
import com.example.cityserver.entity.House;
import com.example.cityserver.entity.Passport;
import com.example.cityserver.entity.Person;
import com.example.cityserver.mapper.PersonMapper;
import com.example.cityserver.repository.PersonRepository;
import com.example.cityserver.service.HouseService;
import com.example.cityserver.service.PassportService;
import com.example.cityserver.service.PersonHouseService;
import com.example.cityserver.service.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Validated
public class PersonServiceImpl implements PersonService {

    private final HouseService houseService;
    private final PersonHouseService personHouseService;
    private final PassportService passportService;

    private final PersonRepository repository;
    private final PersonMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Override
    public Person getPerson(@Positive Long personId) {
        Optional<Person> optPerson = repository.findById(personId);
        if (optPerson.isEmpty()) throw new NoSuchElementException("Person not found");

        return optPerson.get();
    }

    @Override
    public List<Person> getPersonsBy(@NotBlank Character surnameStartChar) {
        return repository.findAllBySurnameStartingWith(surnameStartChar);
    }

    @Override
    public GetPersonResponseDto getPersonDto(@Positive Long personId) {
        Person person = getPerson(personId);

        return mapper.fromPerson(person);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public GetPersonResponseDto addPerson(@Valid AddPersonRequestDto dto) {
        Person person = mapper.personFromAddPersonRequestDto(dto);
        Passport passport = passportService.addPassport();
        person.setPassport(passport);
        person = repository.save(person);

        List<House> houses = dto.getHousesId().stream()
                .distinct()
                .map(houseService::getHouse)
                .toList();
        person.setHouses(personHouseService.updateHousesInPerson(person, houses));

        return mapper.fromPerson(person);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<GetPersonResponseDto> addPersonList(@Valid List<AddPersonRequestDto> requestDtoList) {

        List<Passport> passports = passportService.addPassportList(requestDtoList.size());
        Iterator<Passport> passportIterator = passports.iterator();

        List<Person> persons = requestDtoList.stream()
                .map(dto -> {
                    Person person = mapper.personFromAddPersonRequestDto(dto);
                    person.setPassport(passportIterator.next());
                    return person;
                })
                .toList();
        persons = (List<Person>) repository.saveAll(persons);

        for (int i = 0; i < requestDtoList.size(); i++) {
            List<House> houses = requestDtoList.get(i).getHousesId().stream()
                    .distinct()
                    .map(houseService::getHouse)
                    .toList();
            persons.get(i).setHouses(personHouseService.updateHousesInPerson(persons.get(i), houses));
        }

        return persons.stream()
                .map(mapper::fromPerson)
                .toList();
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public GetPersonResponseDto updatePerson(@Positive Long personId, @Valid AddPersonRequestDto dto) {
        logger.debug("Start updating person");
        Optional<Person> optPerson = repository.findById(personId);
        if (optPerson.isEmpty()) throw new NoSuchElementException("Person not found");
        logger.debug("Person found in DB");

        Person person = mapper.personFromAddPersonRequestDto(dto);
        person.setId(personId);
        person.setPassport(optPerson.get().getPassport());
        person = repository.save(person);
        logger.debug("Person saved in DB");

        List<House> houses = dto.getHousesId().stream()
                .distinct()
                .map(houseService::getHouse)
                .toList();
        List<House> updatedHouses = personHouseService.updateHousesInPerson(person, houses);
        logger.debug("Person house updated in DB");

        person.setHouses(updatedHouses);
        logger.debug("Set houses into person entity");

        GetPersonResponseDto dto1 = mapper.fromPerson(person);
        logger.debug("Response dto received from mapper");

        return dto1;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public void deletePerson(@Positive Long personId) {
        Optional<Person> optPerson = repository.findById(personId);
        if (optPerson.isEmpty()) throw new NoSuchElementException("Person not found");

        Person person = optPerson.get();
        personHouseService.deleteAllByPersonId(personId);
        repository.delete(person);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public void deletePersonList(@Positive List<Long> personIds) {
        for (Long id : personIds) personHouseService.deleteAllByPersonId(id);

        repository.deleteAllById(personIds);
    }
}



