package com.example.cityserver.service;

import com.example.cityserver.dto.person.AddPersonRequestDto;
import com.example.cityserver.dto.person.GetPersonResponseDto;
import com.example.cityserver.entity.Person;

import java.util.List;

public interface PersonService {

    Person getPerson(Long personId);

    List<Person> getPersonsBy(Character surnameStartChar);

    GetPersonResponseDto getPersonDto(Long personId);

    GetPersonResponseDto addPerson(AddPersonRequestDto dto);

    GetPersonResponseDto updatePerson(Long personId, AddPersonRequestDto dto);

    void deletePerson(Long personId);
}
