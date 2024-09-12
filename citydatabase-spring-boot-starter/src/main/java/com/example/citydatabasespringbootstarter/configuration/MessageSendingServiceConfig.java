package com.example.citydatabasespringbootstarter.configuration;


import com.example.citydatabasespringbootstarter.properties.CitydatabaseKafkaProperties;
import com.example.citydatabasespringbootstarter.service.MessageSendingService;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@AutoConfiguration
@EnableConfigurationProperties(CitydatabaseKafkaProperties.class)
public class MessageSendingServiceConfig {

    private final CitydatabaseKafkaProperties citydatabaseKafkaProperties;

    public MessageSendingServiceConfig(CitydatabaseKafkaProperties citydatabaseKafkaProperties) {
        this.citydatabaseKafkaProperties = citydatabaseKafkaProperties;
    }

    public ProducerFactory<String, Long[]> producerFactory() {

        String bootstrapAddress = citydatabaseKafkaProperties.getBootstrapAddress() == null
                ? "localhost:29092" : citydatabaseKafkaProperties.getBootstrapAddress();

        Map<String, Object> configProps = new HashMap<>();

        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public MessageSendingService messageSendingService() {
        KafkaTemplate<String, Long[]> kafkaTemplate = new KafkaTemplate<>(producerFactory());

        return new MessageSendingService(kafkaTemplate, citydatabaseKafkaProperties);
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {

        String bootstrapAddress = citydatabaseKafkaProperties.getBootstrapAddress() == null
                ? "localhost:29092" : citydatabaseKafkaProperties.getBootstrapAddress();

        Map<String, Object> configs = new HashMap<>();

        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);

        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {

        String topic = citydatabaseKafkaProperties.getSenderTopic() == null
                ? "topic_1" : citydatabaseKafkaProperties.getSenderTopic();

        int numPartitions = citydatabaseKafkaProperties.getNumPartitions() == null
                ? 1 : citydatabaseKafkaProperties.getNumPartitions();

        int replicationFactor = citydatabaseKafkaProperties.getReplicationFactor() == null
                ? 1 : citydatabaseKafkaProperties.getReplicationFactor();

        return new NewTopic(topic, numPartitions, (short) replicationFactor);
    }
}
