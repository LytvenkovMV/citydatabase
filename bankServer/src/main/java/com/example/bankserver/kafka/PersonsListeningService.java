package com.example.bankserver.kafka;

public interface PersonsListeningService {

    void listen(Long[] personIds);
}
