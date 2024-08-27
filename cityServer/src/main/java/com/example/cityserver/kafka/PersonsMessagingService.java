package com.example.cityserver.kafka;

public interface PersonsMessagingService {

    void sendPersons(Long[] personIds);
}
