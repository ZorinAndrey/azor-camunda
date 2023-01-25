package ru.azor.service;

import ru.azor.model.SimpleEvent;

/**
 * Kafka producer.
 */

public interface KafkaProducerService {

    /**
     * Method to send event to Kafka.
     */
    void sendEvent(SimpleEvent simpleEvent);
}
