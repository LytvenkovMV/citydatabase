package com.example.citydatabasespringbootstarter.configuration;


import com.example.citydatabasespringbootstarter.properties.CitydatabaseKafkaProperties;
import com.example.citydatabasespringbootstarter.service.MessageSendingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@AutoConfiguration
@EnableConfigurationProperties(CitydatabaseKafkaProperties.class)
public class MessageSendingServiceConfig {

    private final CitydatabaseKafkaProperties citydatabaseKafkaProperties;
    private final KafkaTemplate<String, Long[]> kafkaTemplate;

    public MessageSendingServiceConfig(
            @Qualifier("KafkaTemplateForCitydatabase")
            KafkaTemplate<String, Long[]> kafkaTemplate,
            CitydatabaseKafkaProperties citydatabaseKafkaProperties) {
        this.kafkaTemplate = kafkaTemplate;
        this.citydatabaseKafkaProperties = citydatabaseKafkaProperties;
    }

    @Bean(name = "MessageSendingServiceForCitydatabase")
    public MessageSendingService messageSendingService() {

        return new MessageSendingService(kafkaTemplate, citydatabaseKafkaProperties);
    }
}
