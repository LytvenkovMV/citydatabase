package com.example.citydatabasespringbootstarter.configuration;

import com.example.citydatabasespringbootstarter.properties.CitydatabaseKafkaProperties;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@AutoConfiguration
@EnableConfigurationProperties(CitydatabaseKafkaProperties.class)
public class KafkaTopicConfig {

    private final CitydatabaseKafkaProperties citydatabaseKafkaProperties;

    public KafkaTopicConfig(CitydatabaseKafkaProperties citydatabaseKafkaProperties) {
        this.citydatabaseKafkaProperties = citydatabaseKafkaProperties;
    }

    @Bean(name = "KafkaTopicForCitydatabase")
    public NewTopic topic1() {

        String topic = citydatabaseKafkaProperties.senderTopic == null
                ? "topic_1" : citydatabaseKafkaProperties.senderTopic;

        return new NewTopic(topic, 1, (short) 1);
    }
}
