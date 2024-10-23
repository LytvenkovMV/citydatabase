package com.example.cityserver.service;

import com.example.cityserver.dto.person.AddPersonRequestDto;
import com.example.cityserver.dto.person.GetPersonResponseDto;
import com.example.cityserver.entity.Person;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.List;

public interface PersonService {

    Person getPerson(@Positive Long personId);

    List<Person> getPersonsBy(@NotBlank Character surnameStartChar);

    GetPersonResponseDto getPersonDto(@Positive Long personId);

    GetPersonResponseDto addPerson(@Valid AddPersonRequestDto dto);

    List<GetPersonResponseDto> addPersonList(@Valid List<AddPersonRequestDto> requestDtoList);

    GetPersonResponseDto updatePerson(@Positive Long personId, @Valid AddPersonRequestDto dto);

    void deletePerson(@Positive Long personId);

    void deletePersonList(@Positive List<Long> personIds);
}
