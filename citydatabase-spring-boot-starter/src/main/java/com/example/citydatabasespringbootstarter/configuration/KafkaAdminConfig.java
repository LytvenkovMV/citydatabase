package com.example.citydatabasespringbootstarter.configuration;

import com.example.citydatabasespringbootstarter.properties.CitydatabaseProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
@EnableConfigurationProperties(CitydatabaseProperties.class)
@RequiredArgsConstructor
public class KafkaAdminConfig {

    private final CitydatabaseProperties citydatabaseProperties;

    @Bean
    public KafkaAdmin kafkaAdmin() {

        String bootstrapAddress = citydatabaseProperties.getBootstrapAddress() == null
                ? "localhost:29092" : citydatabaseProperties.getBootstrapAddress();

        Map<String, Object> configs = new HashMap<>();

        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);

        return new KafkaAdmin(configs);
    }
}
