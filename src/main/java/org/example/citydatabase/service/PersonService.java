package org.example.citydatabase.service;

import org.example.citydatabase.dto.person.AddPersonRequestDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.example.citydatabase.entity.Person;

import java.util.List;

public interface PersonService {

    Person getPerson(Long personId);

    List<Person> getPersonsBy(Character surnameStartChar);

    GetPersonResponseDto getPersonDto(Long personId);

    GetPersonResponseDto addPerson(AddPersonRequestDto dto);

    GetPersonResponseDto updatePerson(Long personId, AddPersonRequestDto dto);

    void deletePerson(Long personId);
}
