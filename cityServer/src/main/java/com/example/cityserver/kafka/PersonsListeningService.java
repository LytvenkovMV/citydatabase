package com.example.cityserver.kafka;

public interface PersonsListeningService {

    void listen(Long[] personIds);
}
