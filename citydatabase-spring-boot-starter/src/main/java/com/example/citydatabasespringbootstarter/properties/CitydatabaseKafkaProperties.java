package com.example.citydatabasespringbootstarter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "citydatabase.kafka")
public class CitydatabaseKafkaProperties {

    public String bootstrapAddress;
    public String consumerGroupId;
    public String senderTopic;
    public String listenerTopic;
}
