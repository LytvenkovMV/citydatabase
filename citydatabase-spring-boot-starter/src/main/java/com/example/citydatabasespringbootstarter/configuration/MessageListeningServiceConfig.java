package com.example.citydatabasespringbootstarter.configuration;

import com.example.citydatabasespringbootstarter.properties.CitydatabaseKafkaProperties;
import com.example.citydatabasespringbootstarter.service.MessageListeningService;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(CitydatabaseKafkaProperties.class)
public class MessageListeningServiceConfig {

    private final CitydatabaseKafkaProperties citydatabaseKafkaProperties;

    public MessageListeningServiceConfig(CitydatabaseKafkaProperties citydatabaseKafkaProperties) {
        this.citydatabaseKafkaProperties = citydatabaseKafkaProperties;
    }

    @Bean(name = "MessageListeningServiceForCitydatabase")
    public MessageListeningService messageListeningService() {

        return new MessageListeningService(citydatabaseKafkaProperties);
    }
}
