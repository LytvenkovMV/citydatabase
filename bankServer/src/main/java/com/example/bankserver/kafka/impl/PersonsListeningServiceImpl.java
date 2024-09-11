package com.example.bankserver.kafka.impl;

import com.example.bankserver.kafka.PersonsListeningService;
import com.example.bankserver.service.AccountService;
import com.example.citydatabasespringbootstarter.service.MessageListeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonsListeningServiceImpl implements PersonsListeningService {

    private final AccountService accountService;
    private final MessageListeningService service;

    @Override
    public void listen(Long[] personIds) {

        accountService.addAccountList(service.listenLongArray(new Long[100]));
    }
}
