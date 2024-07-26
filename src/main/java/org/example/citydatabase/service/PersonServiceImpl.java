package org.example.citydatabase.service;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.dto.AddPersonRequestDto;
import org.example.citydatabase.entity.Person;
import org.example.citydatabase.mapper.PersonMapper;
import org.example.citydatabase.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;
    private final PersonMapper mapper;

    @Override
    public Person getPerson(int personId) {
        Optional<Person> optPerson = repository.findById(personId);
        return optPerson.orElseThrow();
    }

    @Override
    public void addPerson(AddPersonRequestDto dto) {
        Person person = mapper.personFromAddPersonRequestDto(dto);
        person.setPassport(mapper.passportFromAddPersonRequestDto(dto));
        repository.save(person);
    }
}
