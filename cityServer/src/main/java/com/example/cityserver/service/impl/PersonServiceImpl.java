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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final HouseService houseService;
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
    public List<GetPersonResponseDto> addPersonList(List<AddPersonRequestDto> requestDtoList) {

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
    public GetPersonResponseDto updatePerson(Long personId, AddPersonRequestDto dto) {
        Optional<Person> optPerson = repository.findById(personId);
        if (optPerson.isEmpty()) throw new NoSuchElementException("Person not found");

        Person person = mapper.personFromAddPersonRequestDto(dto);
        person.setId(personId);
        person.setPassport(optPerson.get().getPassport());
        person = repository.save(person);

        List<House> houses = dto.getHousesId().stream()
                .distinct()
                .map(houseService::getHouse)
                .toList();
        person.setHouses(personHouseService.updateHousesInPerson(person, houses));

        return mapper.fromPerson(person);
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

    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public void deletePersonList(List<Long> personIds) {
        for (Long id : personIds) personHouseService.deleteAllByPersonId(id);

        repository.deleteAllById(personIds);
    }
}
