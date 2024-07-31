package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.person.AddPersonRequestDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.example.citydatabase.entity.Car;
import org.example.citydatabase.entity.House;
import org.example.citydatabase.entity.Passport;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.mapper.PersonMapper;
import org.example.citydatabase.repository.PersonRepository;
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
    private final CarService carService;

    private final PersonRepository personRepository;
    private final PersonMapper mapper;

    @Override
    public Person getPersonEntity(Long personId) {
        Optional<Person> optPerson = personRepository.findById(personId);
        if (optPerson.isEmpty()) throw new NoSuchElementException("Person not found");

        return optPerson.get();
    }

    @Override
    public GetPersonResponseDto getPerson(Long personId) {
        Person person = getPersonEntity(personId);

        return mapper.fromPerson(person);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public GetPersonResponseDto addPerson(AddPersonRequestDto dto) {
        Person person = mapper.personFromAddPersonRequestDto(dto);
        Passport passport = passportService.addPassport();
        person.setPassport(passport);

        personRepository.save(person);

        for (Long houseId : dto.getHousesId()) {
            House house = entityProvider.getHouseById(houseId);
            if (house == null) throw new NoSuchElementException("House not found");

            personHouseService.addPersonHouse(person, house);
        }

        return mapper.fromPerson(person);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void deletePerson(Long personId) {
        Optional<Person> optPerson = personRepository.findById(personId);
        if (optPerson.isEmpty()) throw new NoSuchElementException("Person not found");

        Person person = optPerson.get();
        Passport passport = person.getPassport();
        List<Car> cars = person.getCars();

        for (Car c : cars) carService.deleteCar(c.getId());
        personHouseService.deleteAllByPersonId(personId);
        passportService.deletePassport(passport.getId());
        personRepository.delete(person);
    }
}
