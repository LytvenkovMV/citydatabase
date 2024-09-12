package com.example.bankserver.kafka.impl;

import com.example.bankserver.kafka.PersonsListeningService;
import com.example.bankserver.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonsListeningServiceImpl implements PersonsListeningService {

    private final AccountService accountService;

    @Override
    @KafkaListener(topics = "newpersons")
    public void listen(Long[] personIds) {

        accountService.addAccountList(personIds);
    }
}
