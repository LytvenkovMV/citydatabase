package com.example.citydatabasespringbootstarter.service;

import com.example.citydatabasespringbootstarter.properties.CitydatabaseKafkaProperties;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class MessageListeningService {

    private final CitydatabaseKafkaProperties citydatabaseKafkaProperties;

    public MessageListeningService(CitydatabaseKafkaProperties citydatabaseKafkaProperties) {
        this.citydatabaseKafkaProperties = citydatabaseKafkaProperties;
    }


    //////////@KafkaListener(topics = citydatabaseKafkaProperties.senderTopic)

    @KafkaListener(topics = "topic_1")
    public Long[] listenLongArray(Long[] longs) {

        return longs;
    }
}
