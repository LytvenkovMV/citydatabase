package com.example.citydatabasespringbootstarter.service;

import com.example.citydatabasespringbootstarter.properties.CitydatabaseKafkaProperties;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

@EnableKafka
public class MessageSendingService {

    private final KafkaTemplate<String, Long[]> kafkaTemplate;
    private final CitydatabaseKafkaProperties citydatabaseKafkaProperties;

    public MessageSendingService(
            KafkaTemplate<String, Long[]> kafkaTemplate,
            CitydatabaseKafkaProperties citydatabaseKafkaProperties) {
        this.kafkaTemplate = kafkaTemplate;
        this.citydatabaseKafkaProperties = citydatabaseKafkaProperties;
    }

    public void sendLongArray(Long[] longs) {

        kafkaTemplate.send(citydatabaseKafkaProperties.senderTopic, longs);
    }
}
