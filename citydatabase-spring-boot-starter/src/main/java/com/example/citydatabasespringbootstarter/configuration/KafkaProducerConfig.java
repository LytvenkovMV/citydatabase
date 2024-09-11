package com.example.citydatabasespringbootstarter.configuration;

import com.example.citydatabasespringbootstarter.properties.CitydatabaseKafkaProperties;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@AutoConfiguration
@EnableConfigurationProperties(CitydatabaseKafkaProperties.class)
public class KafkaProducerConfig {

    private final CitydatabaseKafkaProperties citydatabaseKafkaProperties;

    public KafkaProducerConfig(CitydatabaseKafkaProperties citydatabaseKafkaProperties) {
        this.citydatabaseKafkaProperties = citydatabaseKafkaProperties;
    }

    public ProducerFactory<String, Long[]> producerFactory() {

        String bootstrapAddress = citydatabaseKafkaProperties.bootstrapAddress == null
                ? "localhost:29092" : citydatabaseKafkaProperties.bootstrapAddress;

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

    @Bean(name = "KafkaTemplateForCitydatabase")
    public KafkaTemplate<String, Long[]> kafkaTemplate() {

        return new KafkaTemplate<>(producerFactory());
    }
}
