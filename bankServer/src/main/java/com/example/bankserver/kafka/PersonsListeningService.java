package com.example.bankserver.kafka;

import org.jooq.impl.QOM;

import java.util.List;

public interface PersonsListeningService {

    void listen(List<Integer> personIds);
}
