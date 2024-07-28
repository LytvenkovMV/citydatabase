package org.example.citydatabase.service;

import org.example.citydatabase.dto.AddPersonRequestDto;
import org.example.citydatabase.entity.Person;

public interface PersonService {

    Person getPerson(Long personId);

    Person addPerson(AddPersonRequestDto dto);

    void deletePerson(Long personId);
}
