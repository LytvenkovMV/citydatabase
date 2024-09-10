package com.example.cityserver.kafka.impl;

import com.example.cityserver.kafka.PersonsListeningService;
import com.example.cityserver.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonsListeningServiceImpl implements PersonsListeningService {

    private final PersonService personService;

    @Override
    @KafkaListener(topics = "personsrollback")
    public void listen(Long[] personIds) {

        List<Long> personsList = Arrays.stream(personIds).toList();
        personService.deletePersonList(personsList);

        log.warn("Transaction rolled back! Persons deleted.");
    }
}
