package org.example.citydatabase.service;

import org.example.citydatabase.dto.AddPersonRequestDto;
import org.example.citydatabase.entity.Person;

public interface PersonService {

    Person getPerson(int personId);

    void addPerson(AddPersonRequestDto dto);
}
