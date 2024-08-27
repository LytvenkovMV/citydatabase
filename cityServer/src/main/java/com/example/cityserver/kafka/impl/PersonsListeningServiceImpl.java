package com.example.cityserver.kafka.impl;

import com.example.cityserver.kafka.PersonsListeningService;
import com.example.cityserver.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonsListeningServiceImpl implements PersonsListeningService {

    private final PersonService personService;

    @Override
    @KafkaListener(topics = "personsrollback", containerFactory = "PersonListenerConsumerContainer")
    public void listen(Long[] personIds) {

        List<Long> personsList = Arrays.stream(personIds).toList();
        personService.deletePersonList(personsList);
    }
}
