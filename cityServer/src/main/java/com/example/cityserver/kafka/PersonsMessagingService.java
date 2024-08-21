package com.example.cityserver.kafka;

import java.util.List;

public interface PersonsMessagingService {

    void sendPersons(List<Long> personIds);
}
