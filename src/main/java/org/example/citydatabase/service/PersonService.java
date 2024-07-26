package org.example.citydatabase.service;

import org.example.citydatabase.dto.AddPersonRequestDto;
import org.example.citydatabase.entity.Person;
import org.springframework.stereotype.Service;

public interface PersonService {

    Person getPerson(int personId);

    void addPerson(AddPersonRequestDto dto);
}
