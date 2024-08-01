package org.example.citydatabase.service;

import org.example.citydatabase.dto.person.AddPersonRequestDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.example.citydatabase.entity.Person;

import java.util.List;

public interface PersonService {

    Person getPersonEntity(Long personId);

    List<Person> getPersonsBy(Character surnameStartChar);

    GetPersonResponseDto getPerson(Long personId);

    GetPersonResponseDto addPerson(AddPersonRequestDto dto);

    void deletePerson(Long personId);
}
