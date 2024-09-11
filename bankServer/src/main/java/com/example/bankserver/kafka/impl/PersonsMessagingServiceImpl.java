package com.example.bankserver.kafka.impl;

import com.example.bankserver.kafka.PersonsMessagingService;
import com.example.citydatabasespringbootstarter.service.MessageSendingService;
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
