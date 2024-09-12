package com.example.citydatabasespringbootstarter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "citydatabase.kafka")
public class CitydatabaseKafkaProperties {

    String bootstrapAddress;
    String consumerGroupId;
    String senderTopic;
    Integer numPartitions;
    Integer replicationFactor;

    public String getBootstrapAddress() {
        return bootstrapAddress;
    }

    public void setBootstrapAddress(String bootstrapAddress) {
        this.bootstrapAddress = bootstrapAddress;
    }

    public String getConsumerGroupId() {
        return consumerGroupId;
    }

    public void setConsumerGroupId(String consumerGroupId) {
        this.consumerGroupId = consumerGroupId;
    }

    public String getSenderTopic() {
        return senderTopic;
    }

    public void setSenderTopic(String senderTopic) {
        this.senderTopic = senderTopic;
    }

    public Integer getNumPartitions() {
        return numPartitions;
    }

    public void setNumPartitions(Integer numPartitions) {
        this.numPartitions = numPartitions;
    }

    public Integer getReplicationFactor() {
        return replicationFactor;
    }

    public void setReplicationFactor(Integer replicationFactor) {
        this.replicationFactor = replicationFactor;
    }
}
