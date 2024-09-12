package com.example.cityserver.kafka.impl;

import com.example.citydatabasespringbootstarter.service.MessageSendingService;
import com.example.cityserver.kafka.PersonsMessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonsMessagingServiceImpl implements PersonsMessagingService {

    private final MessageSendingService service;

    @Override
    public void sendPersons(Long[] personIds) {

        service.sendLongArray(personIds);
    }
}
