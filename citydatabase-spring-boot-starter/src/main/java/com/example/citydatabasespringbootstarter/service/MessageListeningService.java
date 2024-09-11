package com.example.citydatabasespringbootstarter.service;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class MessageListeningService {

    private final String topic = "topic_1";

    public MessageListeningService(final String topic) {
        ///this.topic = topic == null ? "topic_1" : topic;
    }

    @KafkaListener(topics = topic)
    public Long[] listenLongArray(Long[] longs) {

        return longs;
    }
}
