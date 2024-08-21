package com.example.bankserver.kafka;

import java.util.List;

public interface PersonsListeningService {

    void listen(List<Long> personIds);
}
