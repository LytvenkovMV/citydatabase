package com.example.citydatabasespringbootstarter.configuration;

import com.example.citydatabasespringbootstarter.properties.CitydatabaseProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(CitydatabaseProperties.class)
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    private final CitydatabaseProperties citydatabaseProperties;

    public ConsumerFactory<String, Long[]> consumerFactory() {

        String bootstrapAddress = citydatabaseProperties.getBootstrapAddress() == null
                ? "localhost:29092" : citydatabaseProperties.getBootstrapAddress();

        String groupId = citydatabaseProperties.getConsumerGroupId() == null
                ? "group_1" : citydatabaseProperties.getConsumerGroupId();

        Map<String, Object> props = new HashMap<>();

        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                groupId);
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Long[]>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Long[]> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
}
