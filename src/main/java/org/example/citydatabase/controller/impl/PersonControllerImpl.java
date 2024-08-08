package org.example.citydatabase.controller.impl;

import lombok.RequiredArgsConstructor;
import org.example.citydatabase.controller.PersonController;
import org.example.citydatabase.dto.person.AddPersonRequestDto;
import org.example.citydatabase.dto.person.GetPersonResponseDto;
import org.example.citydatabase.service.PersonService;
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
        GetPersonResponseDto responseDto = service.getPersonDto(personId);

        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<GetPersonResponseDto> addPerson(@RequestBody AddPersonRequestDto requestDto) {
        Long personId = service.addPerson(requestDto);

        return ResponseEntity.ok(service.getPersonDto(personId));
    }

    @Override
    public ResponseEntity<GetPersonResponseDto> updatePerson(@PathVariable(name = "id") Long personId,
                                                             @RequestBody AddPersonRequestDto requestDto) {
        service.updatePerson(personId, requestDto);

        return ResponseEntity.ok(service.getPersonDto(personId));
    }

    @Override
    public ResponseEntity<String> deletePerson(@PathVariable(name = "id") Long personId) {
        service.deletePerson(personId);

        return ResponseEntity.ok("Person deleted!");
    }
}
