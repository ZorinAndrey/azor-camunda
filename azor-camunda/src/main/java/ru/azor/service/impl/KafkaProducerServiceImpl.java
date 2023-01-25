package ru.azor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.azor.model.SimpleEvent;
import ru.azor.service.KafkaProducerService;
import ru.azor.util.CommonConstants;

/**
 * {@inheritDoc}
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendEvent(SimpleEvent simpleEvent) {

        kafkaTemplate.send(CommonConstants.KAFKA_TOPIC, simpleEvent.getEvent());

        log.info("Send event to Kafka {}", simpleEvent.getEvent());
    }
}
