package org.example.citydatabase.controller;

import org.example.citydatabase.dto.person.AddPersonRequestDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.springframework.http.ResponseEntity;

public interface PersonController {

    ResponseEntity<GetPersonResponseDto> getPerson(Long personId);

    ResponseEntity<GetPersonResponseDto> addPerson(AddPersonRequestDto requestDto);

    ResponseEntity<GetPersonResponseDto> updatePerson(Long personId, AddPersonRequestDto requestDto);

    ResponseEntity<String> deletePerson(Long personId);
}
