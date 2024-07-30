package org.example.citydatabase.service;

import org.example.citydatabase.dto.person.AddPersonRequestDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.example.citydatabase.entity.Person;

public interface PersonService {

    GetPersonResponseDto getPerson(Long personId);

    GetPersonResponseDto addPerson(AddPersonRequestDto dto);

    void deletePerson(Long personId);
}
