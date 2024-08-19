package com.example.cityserver.kafka.impl;

import com.example.cityserver.kafka.PersonsMessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonsMessagingServiceImpl implements PersonsMessagingService {

//    private final KafkaTemplate<String, List<Long>> kafkaTemplate;
//
//    @Override
//    public void sendPersons(List<Long> personIds) {
//
//        kafkaTemplate.send("newpersons", personIds);
//    }
}
