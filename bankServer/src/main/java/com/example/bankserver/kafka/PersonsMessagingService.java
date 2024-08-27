package com.example.bankserver.kafka;

public interface PersonsMessagingService {

    void sendPersons(Long[] personIds);
}
