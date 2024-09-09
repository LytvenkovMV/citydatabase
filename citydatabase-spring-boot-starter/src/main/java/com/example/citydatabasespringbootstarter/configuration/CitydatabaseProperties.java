package com.example.citydatabasespringbootstarter.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "citydatabase.messagebroker")
@Data
public class CitydatabaseProperties {

    private String bootstrapAddress;
    private String consumerGroupId;
}
