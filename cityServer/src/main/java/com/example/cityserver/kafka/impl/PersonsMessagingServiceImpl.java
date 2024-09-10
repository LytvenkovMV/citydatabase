package com.example.cityserver.kafka.impl;

import com.example.cityserver.kafka.PersonsMessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonsMessagingServiceImpl implements PersonsMessagingService {

    private final KafkaTemplate<String, Long[]> kafkaTemplate;

    @Override
    public void sendPersons(Long[] personIds) {

        kafkaTemplate.send("newpersons", personIds);
    }
}
