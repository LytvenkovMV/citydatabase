package com.example.citydatabasespringbootstarter.service;

import com.example.citydatabasespringbootstarter.configuration.KafkaListenerConfig;
import com.example.citydatabasespringbootstarter.configuration.MessageSendingServiceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ServicesTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(
                    KafkaListenerConfig.class,
                    MessageSendingServiceConfig.class));

    @Test
    void shouldContainBeans() {
        contextRunner.run(context -> {
            assertTrue(context.containsBean("kafkaListenerContainerFactory"));
            assertTrue(context.containsBean("kafkaAdmin"));
            assertTrue(context.containsBean("topic1"));
            assertTrue(context.containsBean("messageSendingService"));
        });
    }
}