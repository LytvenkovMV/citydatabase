package com.example.citydatabasespringbootstarter.configuration;

import com.example.citydatabasespringbootstarter.properties.CitydatabaseKafkaProperties;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@AutoConfiguration
@EnableConfigurationProperties(CitydatabaseKafkaProperties.class)
public class KafkaAdminConfig {

    private final CitydatabaseKafkaProperties citydatabaseKafkaProperties;

    public KafkaAdminConfig(CitydatabaseKafkaProperties citydatabaseKafkaProperties) {
        this.citydatabaseKafkaProperties = citydatabaseKafkaProperties;
    }

    @Bean(name = "KafkaAdminForCitydatabase")
    public KafkaAdmin kafkaAdmin() {

        String bootstrapAddress = citydatabaseKafkaProperties.bootstrapAddress == null
                ? "localhost:29092" : citydatabaseKafkaProperties.bootstrapAddress;

        Map<String, Object> configs = new HashMap<>();

        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);

        return new KafkaAdmin(configs);
    }
}
