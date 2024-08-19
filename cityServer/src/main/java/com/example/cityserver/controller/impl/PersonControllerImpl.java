package com.example.cityserver.controller.impl;

import lombok.RequiredArgsConstructor;
import com.example.cityserver.controller.PersonController;
import com.example.cityserver.dto.person.AddPersonRequestDto;
import com.example.cityserver.dto.person.GetPersonResponseDto;
import com.example.cityserver.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonControllerImpl implements PersonController {

    private final PersonService service;

    @Override
    public ResponseEntity<GetPersonResponseDto> getPerson(@PathVariable(name = "id") Long personId) {
        GetPersonResponseDto dto = service.getPersonDto(personId);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<GetPersonResponseDto> addPerson(@RequestBody AddPersonRequestDto requestDto) {
        GetPersonResponseDto dto = service.addPerson(requestDto);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<GetPersonResponseDto> updatePerson(@PathVariable(name = "id") Long personId,
                                                             @RequestBody AddPersonRequestDto requestDto) {
        GetPersonResponseDto dto = service.updatePerson(personId, requestDto);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<String> deletePerson(@PathVariable(name = "id") Long personId) {
        service.deletePerson(personId);

        return ResponseEntity.ok("Person deleted!");
    }
}
