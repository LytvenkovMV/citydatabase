package com.example.cityserver.controller.impl;

import com.example.cityserver.controller.PersonController;
import com.example.cityserver.dto.person.AddPersonRequestDto;
import com.example.cityserver.dto.person.GetPersonResponseDto;
import com.example.cityserver.kafka.PersonsMessagingService;
import com.example.cityserver.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonControllerImpl implements PersonController {

    private final PersonService personService;
    private final PersonsMessagingService messagingService;

    @Override
    public ResponseEntity<GetPersonResponseDto> getPerson(@PathVariable(name = "id") Long personId) {
        GetPersonResponseDto dto = personService.getPersonDto(personId);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<GetPersonResponseDto> addPerson(@RequestBody AddPersonRequestDto requestDto) {
        GetPersonResponseDto dto = personService.addPerson(requestDto);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<GetPersonResponseDto>> addPersonList(List<AddPersonRequestDto> requestDtoList) {
        List<GetPersonResponseDto> dtoList = personService.addPersonList(requestDtoList);

        messagingService.sendPersons(dtoList.stream()
                .map(GetPersonResponseDto::getId)
                .toList());

        return ResponseEntity.ok(dtoList);
    }

    @Override
    public ResponseEntity<GetPersonResponseDto> updatePerson(@PathVariable(name = "id") Long personId,
                                                             @RequestBody AddPersonRequestDto requestDto) {
        GetPersonResponseDto dto = personService.updatePerson(personId, requestDto);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<String> deletePerson(@PathVariable(name = "id") Long personId) {
        personService.deletePerson(personId);

        return ResponseEntity.ok("Person deleted!");
    }
}
