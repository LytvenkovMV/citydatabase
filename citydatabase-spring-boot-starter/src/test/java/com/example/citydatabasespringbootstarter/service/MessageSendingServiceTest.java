package com.example.citydatabasespringbootstarter.service;

import com.example.citydatabasespringbootstarter.configuration.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ServicesTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(KafkaProducerConfig.class,
                    KafkaConsumerConfig.class,
                    KafkaAdminConfig.class,
                    KafkaTopicConfig.class,
                    MessageListeningServiceConfig.class,
                    MessageListeningServiceConfig.class));

    @Test
    void shouldContainBeans() {
        contextRunner.run(context -> {
            assertTrue(context.containsBean("KafkaTemplateForCitydatabase"));
            assertTrue(context.containsBean("KafkaListenerContainerFactoryForCitydatabase"));
            assertTrue(context.containsBean("KafkaAdminForCitydatabase"));
            assertTrue(context.containsBean("KafkaTopicForCitydatabase"));
            assertTrue(context.containsBean("MessageListeningServiceForCitydatabase"));
            assertTrue(context.containsBean("MessageSendingServiceForCitydatabase"));
        });
    }
}